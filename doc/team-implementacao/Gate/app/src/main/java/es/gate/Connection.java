package es.gate;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.Socket;

public class Connection extends AsyncTask<Void, Void, Void> {

    String serverAddress;
    int serverPort;

    public Connection(String addr, int port) {

        serverAddress = addr;
        serverPort = port;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        System.out.println("lalallaallaallalallalalala");
        Socket cltSocket = null;

        try {
            cltSocket = new Socket(serverAddress, serverPort);
            System.out.println("Connection attempted");
        }catch(IOException e){
            System.out.println("IO" + e);
        }

        return null;
    }
}
