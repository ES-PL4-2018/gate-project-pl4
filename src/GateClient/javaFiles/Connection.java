package es.gate;

import java.io.IOException;
import java.net.Socket;

public class Connection implements Runnable{

    private String serverAddress;
    private int serverPort;
    private Socket cltSocket = null;

    public Connection(String addr, int port) {

        serverAddress = addr;
        serverPort = port;
        new Thread(this).start();
    }


    public void run(){

        try {
            cltSocket = new Socket(serverAddress, serverPort);
            System.out.println("Connection attempted");


        }catch(IOException e){
            System.out.println("IO" + e);
        }

    }
}
