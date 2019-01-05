package es.gate.Discover;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.UsersDiscovered;
import es.gate.Fragments.Discovery;
import io.realm.Realm;
import io.realm.RealmList;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.*;


public class DiscoveryProcess {

    private static final String TAG = "Discover";
    private String MULTICAST_IP = "226.0.0.1";
    private int PORT = 6667;
    private int INTERVAL = 2500; //intervalo de tempo em ms
    private boolean enabled = true;
    private String curAccount;
    private Realm realm;
    private Discovery discoveryInstance;
    //private ExecutorService executor;

    public DiscoveryProcess(String curAccount, Discovery discoveryInstance) {
        this.discoveryInstance = discoveryInstance;
        this.realm = Realm.getDefaultInstance();
        this.curAccount = curAccount;
        //User info
        AccountInformation userAccount = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();
        new Thread(new DiscoverPacket()).start();
        new Thread(new ReceivePacket(userAccount.getOrcid(), userAccount.getUserFirstName() + " " + userAccount.getUserLastName())).start();
        realm.close();
    }


    public void toggleHeartbeat() {
        enabled = !enabled;
    }

    class DiscoverPacket implements Runnable {

        @Override
        public void run() {
            MulticastSocket socket;
            InetAddress group;
            byte[] buffer;
            DatagramPacket packet;
            Map<String, Object> map;

            try {
                socket = new MulticastSocket(PORT);
                group = InetAddress.getByName(MULTICAST_IP);
                socket.joinGroup(group);
                map = new HashMap<>();

                map.put("type", "discover");
                map.put("orcid", curAccount);
                buffer = Serializer.serialize(map);
                packet = new DatagramPacket(buffer, buffer.length, group, PORT);

                while (enabled) {
                    socket.send(packet);
                    Log.d(TAG, "Sent packet: " + packet + " " + map);
                    Thread.sleep(INTERVAL);
                }

            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Log.e(TAG, "Stopped discover heartbeat");
                } else e.printStackTrace();
            }
        }
    }

    class ReceivePacket implements Runnable {

        String orcid;
        String username;

        ReceivePacket(String orcid, String username) {
            this.orcid = orcid;
            this.username = username;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void run() {
            MulticastSocket socket;
            InetAddress group;
            byte[] buffer;
            DatagramPacket packet;
            Map<String, Object> map;

            Realm realm;

            Log.d("Receive", "Startup");
            try {
                socket = new MulticastSocket(PORT);
                group = InetAddress.getByName(MULTICAST_IP);
                socket.joinGroup(group);
                buffer = new byte[8192];
                packet = new DatagramPacket(buffer, buffer.length);

                while (enabled) {
                    socket.receive(packet);
                    map = (Map<String, Object>) Serializer.deserialize(packet.getData());


                    Log.d(TAG, " Received packet: " + map + packet.getAddress());

                    switch ((String) map.get("type")) {

                        case "discover": {
                            if (map.get("orcid").equals(curAccount))
                                break;
                            new Thread(new DiscoverResponse((String) map.get("orcid"))).start();
                            //executor.submit(new DiscoverResponse((String)map.get("orcid")));
                            break;
                        }
                        case "discoverAnswer": {


                            if (!map.get("destination").equals(curAccount))
                                break;


                            String orcid = (String) map.get("orcid");

                            System.out.println("Sending contacts to " + orcid);

                            realm = Realm.getDefaultInstance();
                            UsersDiscovered user = Objects.requireNonNull(realm
                                    .where(AccountInformation.class)
                                    .equalTo("orcid", curAccount)
                                    .findFirst())
                                    .getUsersDiscovered()
                                    .where()
                                    .equalTo("userORCID", Long.parseLong(orcid))
                                    .findFirst();

                            System.out.println(user);
                            if (user == null) {
                                new Thread(new SendContacts(orcid)).start();
                            } else if ((System.currentTimeMillis() - user.getLastSeen().getTime()) > 60000) {
                                new Thread(new SendContacts(orcid)).start();
                            }
                            realm.close();
                            break;
                        }
                        case "usersDiscovered": {

                            if (!map.get("destination").equals(curAccount))
                                break;

                            ArrayList<Map> contacts = (ArrayList<Map>) map.get("usersDiscovered");

                            realm = Realm.getDefaultInstance();

                            UsersDiscovered newUser = new UsersDiscovered();
                            newUser.setUserORCID(Long.parseLong((String) map.get("userOrcid")));
                            newUser.setUserName((String) map.get("userName"));
                            newUser.setLastSeen(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());

                            RealmList<UsersDiscovered> userContacts = new RealmList<>();

                            UsersDiscovered userContact;
                            for (Map m : contacts) {

                                userContact = new UsersDiscovered();
                                userContact.setUserORCID((Long) m.get("userOrcid"));
                                userContact.setUserName((String) m.get("userName"));
                                userContact.setLastSeen((Date) m.get("lastSeen"));
                                userContacts.add(userContact);
                            }

                            RealmList<UsersDiscovered> accountDiscovered = Objects.requireNonNull(realm
                                    .where(AccountInformation.class)
                                    .equalTo("orcid", curAccount)
                                    .findFirst())
                                    .getUsersDiscovered();


                            realm.beginTransaction();

                            UsersDiscovered update;

                            if ((update = accountDiscovered.where().equalTo("userORCID", newUser.getUserORCID()).findFirst()) == null)
                                accountDiscovered.add(newUser);
                            else {
                                if (update.getLastSeen().before(newUser.getLastSeen())) {
                                    update.setLastSeen(newUser.getLastSeen());
                                }
                            }
                            System.out.println(update);


                            for (UsersDiscovered disc : userContacts) {

                                if ((update = accountDiscovered.where().equalTo("userORCID", disc.getUserORCID()).findFirst()) == null)
                                    accountDiscovered.add(disc);
                                else if (update.getLastSeen().before(newUser.getLastSeen())) {
                                    update.setLastSeen(newUser.getLastSeen());
                                }
                                System.out.println(update);
                            }

                            realm.commitTransaction();

                            Message message = discoveryInstance.getDiscoveryHandler().obtainMessage();
                            Bundle bundle = new Bundle();
                            bundle.putInt("clickEvent", 4);
                            message.setData(bundle);
                            discoveryInstance.getDiscoveryHandler().sendMessage(message);

                            realm.close();
                            break;
                        }
                        case "profileRequest": {

                            if (!map.get("destination").equals(curAccount))
                                break;

                            realm = Realm.getDefaultInstance();

                            AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();

                            Map answer = new HashMap<String, Object>();

                            answer.put("type", "profileSend");
                            answer.put("destination", map.get("orcid"));
                            answer.put("orcid", Objects.requireNonNull(accInfo).getOrcid());
                            answer.put("userName", accInfo.getUserFirstName() + accInfo.getUserLastName());
                            answer.put("userEmail", accInfo.getUserEmail());
                            answer.put("institution", accInfo.getInstitution());
                            answer.put("research", accInfo.getInvestigationUnits());

                            buffer = Serializer.serialize(answer);
                            packet = new DatagramPacket(buffer, buffer.length, group, PORT);

                            socket.send(packet);

                            realm.close();

                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class SendContacts implements Runnable {
        String destination;

        SendContacts(String destination) {
            this.destination = destination;
        }

        @Override
        public void run() {
            try {
                Map<String, Object> map;
                byte[] buffer;
                InetAddress group = InetAddress.getByName(MULTICAST_IP);
                DatagramPacket packet;

                MulticastSocket out = new MulticastSocket(PORT);
                out.joinGroup(group);

                map = new HashMap<>();

                ArrayList<Map> contacts = new ArrayList<>();

                realm = Realm.getDefaultInstance();

                AccountInformation account = Objects.requireNonNull(realm
                        .where(AccountInformation.class)
                        .equalTo("orcid", curAccount)
                        .findFirst());

                RealmList<UsersDiscovered> discovered = account.getUsersDiscovered();

                for (UsersDiscovered users : discovered) {
                    map.put("userOrcid", users.getUserORCID());
                    map.put("userName", users.getUserName());
                    map.put("lastSeen", users.getLastSeen());
                    contacts.add(map);
                    map = new HashMap<>();
                }

                map.put("userOrcid", curAccount);
                map.put("userName", account.getUserFirstName() + " " + account.getUserLastName());
                map.put("usersDiscovered", contacts);
                map.put("destination", destination);
                map.put("type", "usersDiscovered");

                realm.close();

                buffer = Serializer.serialize(map);
                packet = new DatagramPacket(buffer, buffer.length, group, PORT);

                Log.d(TAG, "Sent packet with type: " + map.get("type"));

                out.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class DiscoverResponse implements Runnable {

        private String destination;

        public DiscoverResponse(String destination) {
            this.destination = destination;
        }

        @Override
        public void run() {
            MulticastSocket socket;
            InetAddress group;
            byte[] buffer;
            DatagramPacket packet;
            Map<String, Object> map;

            try {
                socket = new MulticastSocket(PORT);
                group = InetAddress.getByName(MULTICAST_IP);
                socket.joinGroup(group);
                map = new HashMap<>();

                map.put("type", "discoverAnswer");
                map.put("orcid", curAccount);
                map.put("destination", destination);
                buffer = Serializer.serialize(map);
                packet = new DatagramPacket(buffer, buffer.length, group, PORT);

                socket.send(packet);
                Log.d(TAG, "Sent packet: " + packet + " " + map);
                Thread.sleep(INTERVAL);


            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Log.e(TAG, "Stopped discover heartbeat");
                } else e.printStackTrace();
            }

        }
    }
}