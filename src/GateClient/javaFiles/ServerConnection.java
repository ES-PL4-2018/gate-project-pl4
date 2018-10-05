/*
###File created at 01/10/2018 2:42
###Created by Alexandre Brito

##Revision v0.1
#1/10/2018 2:42
#Alexandre Brito
#Initial Criation



*/

package es.gate;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection {
    private static final String serverAddress = "192.168.137.1";
    private static final int serverPort = 9001;
    private static ServerConnection ourInstance = new ServerConnection();
    private DataOutputStream writeServer;
    private DataInputStream readServer;
    private Socket cltSocket = null;


    private ServerConnection() {
        try {
            this.cltSocket = new Socket(serverAddress, serverPort);
            this.writeServer = new DataOutputStream(cltSocket.getOutputStream());
            this.readServer = new DataInputStream(cltSocket.getInputStream());
            Log.d("Connection", "done");
        }catch(IOException e){
            //TODO Solve this....
            System.err.println("IO" + e);
        }
    }

    public static ServerConnection getInstance() {
        return ourInstance;
    }

    public String sendMessage(String str){
        try {
            Log.d("Connection", "messageAttempt");
            writeServer.writeUTF(str);
            Log.d("Connection", "messageSent");
            System.out.println(str = readServer.readUTF());
            Log.d("Connection", str);
            return str;
        }catch(IOException e){
            Log.d("IOException", e.toString());
        }
        return null;
    }
}
