import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.*;
import java.util.ArrayList;

public class Server {

    public static void main(String args[]){

        ArrayList<Account> accountsList = new ArrayList<>();

        try {
            DataInputStream in;
            DataOutputStream out;
            int serverPort = 9001;
            ServerSocket serverSocket = new ServerSocket(serverPort);

            while(true){
                new Client(serverSocket.accept(), accountsList);
                System.out.println("New Client");
            }
        }catch(IOException e){
            //TODO
        }

    }
}
