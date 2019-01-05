package es.gate;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {

    public static void main(String args[]){
        ArrayList<Account> accountsList = new ArrayList<>();

        try {
            int serverPort = 42069;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server running");
            while(true){
                new Client(serverSocket.accept(), accountsList);
                System.out.println("New es.gate.Client");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}