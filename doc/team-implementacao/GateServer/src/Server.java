import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args[]){

        try {
            DataInputStream in;
            DataOutputStream out;
            int serverPort = 9001;
            ServerSocket serverSocket = new ServerSocket(serverPort);

            while(true){
                //Socket clientSocket = serverSocket.accept();
                new Cliente(serverSocket.accept());
                System.out.println("New Client");

            }
        }catch(IOException e){
            //TODO
        }

    }
}

class Cliente implements Runnable{

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;

    public Cliente(Socket cltSocket){
        clientSocket = cltSocket;
        System.out.println("New Client");

    }

    public void run(){


    }

}