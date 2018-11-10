package es.gate.Discover;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;

public class Multicast {

    protected static String MULTICAST_ADDRESS = "224.0.224.0";
    protected static int PORT = 4321;

    public static void sendMulticast(MulticastSocket socket, HashMap<String, String> message) throws IOException {
        byte[] buffer = Serializer.serialize(message);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(MULTICAST_ADDRESS), PORT);
        socket.send(packet);
    }

    public static HashMap<String, String> receiveMulticast(MulticastSocket socket) throws IOException, ClassNotFoundException {
        byte[] buffer = new byte[1024 * 1024];
        DatagramPacket d = new DatagramPacket(buffer, buffer.length);
        socket.receive(d);
        return (HashMap<String, String>) Serializer.deserialize(d.getData());
    }
}
