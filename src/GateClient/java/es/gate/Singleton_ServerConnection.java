package es.gate;

import android.util.Log;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class Singleton_ServerConnection {

    private static final String TAG = "Connection";
    private static Singleton_ServerConnection ourInstance;
    private static final String serverAddress = "192.168.137.1";
    private static final String debuggingAddress = "10.0.2.2";
    private static final String deiAddress = "10.16.1.212";
    private static final String testAddress = "192.84.13.177";
    private static final int serverPort = 42069;
    private ObjectOutputStream writeServer;
    private ObjectInputStream readServer;
    private Socket cltSocket = null;


    private Singleton_ServerConnection() {
        try {
            this.cltSocket = new Socket(serverAddress, serverPort);
            this.writeServer = new ObjectOutputStream(cltSocket.getOutputStream());
            this.readServer = new ObjectInputStream(cltSocket.getInputStream());
            Log.d("Connection", "Start up complete");
        }catch(IOException e){
            //TODO Solve this....
            System.err.println("IO" + e);
        }
    }

    public static synchronized Singleton_ServerConnection getInstance() {

        if(ourInstance == null){
            ourInstance = new Singleton_ServerConnection();
        }
        return ourInstance;
    }

    public HashMap sendMessage(HashMap message){

        if(cltSocket == null || cltSocket.isClosed()){
            openConnection();
        }

        try {
            writeServer.writeObject(message);
            Log.d(TAG, "Message sent");
            try {
                System.out.println(message = (HashMap)readServer.readObject());
            }catch(ClassNotFoundException e){ }
            Log.d(TAG, "Message received");
            return message;
        }catch(IOException e){
            Log.d("IOException", e.toString());
        }
        return null;
    }

    private void openConnection(){
        try {
            this.cltSocket = new Socket(serverAddress, serverPort);
            this.writeServer = new ObjectOutputStream(cltSocket.getOutputStream());
            this.readServer = new ObjectInputStream(cltSocket.getInputStream());
            Log.d("Connection", "Start up complete");
        }catch(IOException e){
            //TODO Solve this....
            System.err.println("IO" + e);
        }
    }
}
