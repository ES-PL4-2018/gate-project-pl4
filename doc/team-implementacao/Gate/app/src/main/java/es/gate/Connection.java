package es.gate;

import java.io.IOException;
import java.net.Socket;

public class Connection implements Runnable{

    Thread t;
    public Connection(){
        t = new Thread(this);
        t.start();
    }

    public void run(){
        int socketPort = 9001;
        String socketHost = "localhost";
        try{
            Socket socket = new Socket(socketHost, socketPort);
            System.out.println("Connection attempted");
        }catch(IOException e){
            //TODO
            System.out.println("rip");

        }
    }


}
