package es.gate.Discover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.UsersConnected;
import es.gate.Fragments.Discovery;
import es.gate.Static_Functions;
import io.realm.Realm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.*;

public class ContactProfile implements Runnable {

    private Context context;
    @SuppressLint("HandlerLeak")
    private final Handler contactProfileHandler = new Handler() {

        @Override
        public void handleMessage(Message message) {
            Toast.makeText(context, "The user seems to be inaccessible", Toast.LENGTH_LONG).show();
        }
    };
    private String curAccount;
    private String userProfile;
    private Discovery discoveryInstance;

    public ContactProfile(String curAccount, String userProfile, Discovery discoveryInstance, Context context) {
        this.context = context;
        this.curAccount = curAccount;
        this.userProfile = Static_Functions.padOrcid(userProfile);
        this.discoveryInstance = discoveryInstance;

        new Thread(this).start();
    }


    @Override
    public void run() {

        String MULTICAST_IP = "226.0.0.1";
        int PORT = 6667;
        final MulticastSocket socket;
        InetAddress group;
        byte[] buffer;
        DatagramPacket packet;
        Map<String, Object> map = new HashMap<>();

        try {
            socket = new MulticastSocket(PORT);
            group = InetAddress.getByName(MULTICAST_IP);
            socket.joinGroup(group);

            map.put("type", "profileRequest");
            map.put("orcid", curAccount);
            map.put("destination", userProfile);

            buffer = Serializer.serialize(map);
            packet = new DatagramPacket(buffer, buffer.length, group, PORT);

            socket.send(packet);

            buffer = new byte[8192];
            packet = new DatagramPacket(buffer, buffer.length);

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    socket.close();
                }
            }, 2500);


            while (true) {
                socket.receive(packet);
                map = (Map<String, Object>) Serializer.deserialize(packet.getData());

                if (map.get("type").equals("profileSend")) {
                    if (!map.get("destination").equals(curAccount)) {
                        break;
                    }

                    Realm realm = Realm.getDefaultInstance();

                    AccountInformation accInfo = realm.where(AccountInformation.class).equalTo("orcid", curAccount).findFirst();
                    UsersConnected user = new UsersConnected();

                    user.setUserORCID(Long.parseLong(userProfile));
                    user.setUserName((String) map.get("userName"));
                    user.setUserEmail((String) map.get("userEmail"));
                    user.setInstitution((String) map.get("institution"));
                    user.setResearchUnits((String) map.get("research"));
                    user.setLastSeen(Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime());

                    realm.beginTransaction();
                    realm.copyToRealmOrUpdate(user);

                    if (accInfo.getUsersConnected().where().equalTo("userORCID", user.getUserORCID()).findFirst() == null)
                        accInfo.getUsersConnected().add(user);
                    realm.commitTransaction();
                    realm.close();

                    Message message = discoveryInstance.getDiscoveryHandler().obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("clickEvent", 3);
                    message.setData(bundle);
                    discoveryInstance.getDiscoveryHandler().sendMessage(message);
                    return;
                }

                buffer = new byte[8192];
                packet = new DatagramPacket(buffer, buffer.length);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        contactProfileHandler.sendMessage(new Message());
    }
}
