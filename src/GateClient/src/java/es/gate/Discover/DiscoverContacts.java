package es.gate.Discover;

import es.gate.DatabaseClasses.UsersContacts;
import es.gate.User_Account;
import io.realm.Realm;
import io.realm.RealmResults;

import java.io.*;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;

public class DiscoverContacts {

    private MulticastSocket socket;
    private User_Account user;

    public DiscoverContacts() {
    }

    public DiscoverContacts(final User_Account user) {
        this.user = user;
        try {
            socket = new MulticastSocket(Multicast.PORT);
            socket.joinGroup(InetAddress.getByName(Multicast.MULTICAST_ADDRESS));
        } catch (IOException e) {
            System.out.println(e);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    HashMap<String, String> response;
                    try {
                        response = Multicast.receiveMulticast(socket);
                    } catch (Exception e) {
                        System.out.println("Receiving multicast " + e);
                        continue;
                    }
                    try {
                        String dest = response.get("dest");
                        if (dest.equals("all") || dest.equals(user.getUserORCID())) {
                            switch (response.get("type")) {
                                case "contacts_list": {
                                    for (int i = 0; i < Integer.parseInt(response.get("list_length")); i++) {
                                        System.out.println("ORCID: " + response.get("orcid" + i));
                                /*System.out.println("Username: " + response.get("username" + i));
                                System.out.println("lastSeen: " + response.get("lastSeen" + i));
                                System.out.println("lastKnownIP: " + response.get("lastKnownIP" + i));*/
                                    }
                                    System.out.println("---------------------------------");
                                    break;
                                }
                                case "get_contacts":
                                    // Enviar de volta para quem pediu contactos (src)
                                    sendContacts(response.get("src"), Long.parseLong(response.get("orcid")));
                                    break;
                            }

                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }).start();
    }

    public void requestContacts(long userORCID) {
        System.out.println("request contacts: " + userORCID);
        HashMap<String, String> msg = new HashMap<>(100);
        msg.put("src", String.valueOf(user.getUserORCID()));
        msg.put("dest", "all");
        msg.put("type", "get_contacts");
        msg.put("orcid", Long.toString(userORCID));
        try {
            Multicast.sendMulticast(socket, msg);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // synchronized para prints apenas, remover depois
    public synchronized void sendContacts(String dest, long userORCID) throws IOException {
        if (user.getUserORCID() != userORCID) {
            System.out.println("User " + user.getUserORCID() + "\nNot for me");
            return;
        }
        HashMap<String, String> msg = new HashMap<>(100);
        msg.put("src", String.valueOf(userORCID));
        msg.put("dest", dest);
        msg.put("type", "contacts_list");
        msg.put("orcid", Long.toString(userORCID));

        Realm realm = Realm.getDefaultInstance();
        RealmResults<UsersContacts> contacts = realm.where(UsersContacts.class).equalTo("userORCID", user.getUserORCID()).findAll();
        //Print contacts
        String c = "";
        for (UsersContacts uc : contacts) {
            c += uc.getContactORCID() + "\t";
        }
        System.out.println("User " + user.getUserORCID() + "\nContacts: " + contacts.size() + "\n" + c);
        msg.put("list_length", String.valueOf(contacts.size()));
        for (int i = 0; i < contacts.size(); i++) {
            msg.put("orcid" + i, String.valueOf(contacts.get(i).getContactORCID()));

            /*Date temp = contacts.get(i).getLastSeen();
            if (temp != null) {
                String date = temp.getDay() + "/" + temp.getMonth() + "/" + temp.getYear();
                msg.put("lastSeen" + i, date);
            } else {
                msg.put("lastSeen" + i, "never");
            }
            String ip = contacts.get(i).getLastKnownIP();
            if (ip == null) {
                msg.put("lastKnownIP" + i, "unknown");
            } else {
                msg.put("lastKnownIP" + i, ip);
            }*/
        }
        Multicast.sendMulticast(socket, msg);
    }

}