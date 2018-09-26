import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String args[]){

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
