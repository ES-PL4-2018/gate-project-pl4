package es.gate.Discover;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import es.gate.DatabaseClasses.AccountInformation;
import es.gate.DatabaseClasses.UsersDiscovered;
import io.realm.Realm;


public class Heartbeat {

    private static final String TAG = "Discover";
    private String MULTICAST_IP = "226.0.0.1";
    private int PORT = 6667;
    private int INTERVAL = 1000; //intervalo de tempo em ms
    private boolean enabled = true;
    private AccountInformation userAccount; //User info
    private Realm realm;

    Heartbeat(){
        this.realm = Realm.getDefaultInstance();
        this.userAccount = realm.where(AccountInformation.class).findFirst();
        new Thread(new SendPacket()).start();
        new Thread(new ReceivePacket()).start();
    }


    public void toggleHeartbeat(){
        enabled = !enabled;
    }

    class SendPacket implements Runnable{

        @Override
        public void run() {
            MulticastSocket socket;
            InetAddress group;
            byte[] buffer;
            DatagramPacket packet;
            Map<String, Object> map;

            try{
                socket = new MulticastSocket(PORT);
                group = InetAddress.getByName(MULTICAST_IP);
                socket.joinGroup(group);
                map = new HashMap<>();

                map.put("type", "search");
                buffer = Serializer.serialize(map);
                packet = new DatagramPacket(buffer, buffer.length, group, PORT);

                while (enabled){
                    socket.send(packet);
                    Thread.sleep(INTERVAL);
                }

            } catch (Exception e) {
                if (e instanceof InterruptedException){
                    Log.e(TAG, "Stopped discover heartbeat");
                }
                else e.printStackTrace();
            }
        }
    }

    class ReceivePacket implements Runnable{

        @SuppressWarnings("unchecked")
        @Override
        public void run() {
            MulticastSocket socket;
            InetAddress group;
            byte[] buffer;
            DatagramPacket packet;
            Map<String, Object> map;

            try{
                socket = new MulticastSocket(PORT);
                group = InetAddress.getByName(MULTICAST_IP);
                socket.joinGroup(group);
                buffer = new byte[8192];
                packet = new DatagramPacket(buffer, buffer.length);

                while (enabled){
                    socket.receive(packet);
                    map = (Map<String, Object>) Serializer.deserialize(packet.getData());

                    //Check if heartbeat
                    if (((String)map.get("type")).matches("search")){
                        //Send our data back
                        map = new HashMap<>();
                        map.put("userIp", InetAddress.getLocalHost().getHostAddress());
                        map.put("userOrcid", userAccount.getUserORCID());
                        map.put("userName", userAccount.getUserName());
                        map.put("type", "discover");

                        buffer = Serializer.serialize(map);
                        packet = new DatagramPacket(buffer, buffer.length, group, PORT);

                        MulticastSocket out = new MulticastSocket(PORT);
                        out.joinGroup(group);
                        out.send(packet);
                    }

                    //Check if someone sent their data
                    else if (((String)map.get("type")).matches("discover")){
                        // TODO check if user already exists
                        //Create a new UsersDiscovered object
                        //Write to realm
                        realm.beginTransaction();
                        UsersDiscovered user = realm.createObject(UsersDiscovered.class);
                        user.setLastKnownIP((String)map.get("userIp"));
                        user.setUserORCID((long)map.get("userOrcid"));
                        user.setUserName((String)map.get("userName"));
                        user.setLastSeen(new Date());
                        realm.commitTransaction();

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
