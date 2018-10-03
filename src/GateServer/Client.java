import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable {

    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    ArrayList<Account> accounts;
    Account curUser = null;

    public Client(Socket cltSocket, ArrayList<Account> acc) {
        clientSocket = cltSocket;
        accounts = acc;
        System.out.println("New User");
        new Thread(this).start();
    }

    public void run() {

        try {
            DataInputStream readClient = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream writeClient = new DataOutputStream(clientSocket.getOutputStream());
            //Auxiliary variables to facilitate code
            int auxInt;
            String auxStr;
            String[] strAr;


            while (true) {

                auxInt = 0;

                auxStr = readClient.readUTF();  //Reads a message from the client
                System.out.println(auxStr);
                strAr = auxStr.split("&");    //Client messages come formatted with info separated by "&"
                switch (strAr[0]) {
                    case "!login": {
                        for (Account acc : accounts) {
                            if (acc.checkLoginInfo(strAr[1], strAr[2])) {
                                writeClient.writeUTF("1");
                                curUser = acc;
                                break;
                            }
                        }
                    }
                    case "!checkUser": {
                        for (Account acc : accounts) {
                            auxInt = acc.checkDuplicateName(strAr[1]);
                            if (auxInt == 0) {
                                break;
                            }
                        }
                        auxStr = String.format("%d", auxInt);
                        writeClient.writeUTF(auxStr);
                        System.out.println(auxStr);
                        break;
                    }
                    case "!checkEmail": {
                        for (Account acc : accounts) {
                            auxInt = acc.checkDuplicateEmail(strAr[1]);
                            if (auxInt == 0) {
                                break;
                            }
                        }
                        auxStr = String.format("%d", auxInt);
                        writeClient.writeUTF(auxStr);
                        System.out.println(auxStr);
                        break;
                    }

                    case "!checkOrcid": {
                        for (Account acc : accounts) {
                            auxInt = acc.checkDuplicateORCID(strAr[1]);
                            if (auxInt == 0) {
                                break;
                            }
                        }
                        auxStr = String.format("%d", auxInt);
                        writeClient.writeUTF(auxStr);
                        System.out.println(auxStr);
                        break;
                    }

                    case "!register":{

                        curUser = new Account(strAr[1], strAr[2], strAr[3], Long.parseLong(strAr[4]), strAr[5], strAr[6], strAr[7], strAr[8], strAr[9], strAr[10]);

                        accounts.add(curUser);

                        System.out.println("New Registry: " + strAr[1]);
                        break;
                    }

                    case "!getFeedInfo":{

                        if(curUser == null){
                            auxStr = String.format("%s", "Test User");
                        }else{
                            auxStr = curUser.getName();
                        }
                        writeClient.writeUTF(auxStr);
                        break;
                    }

                    case "!getProfileInfo": {
                        if(curUser == null){
                            auxStr = String.format("%s&%s&%s&%s&%s", "Test User", "Test Inst", "Test Unit", "Test Date", "Test Interests");
                        }else{
                            auxStr = curUser.getProfileInfo();
                        }
                        writeClient.writeUTF(auxStr);
                        break;
                    }
                    case "!setInfo":{

                        if(curUser == null)
                            break;
                        switch (strAr[1]){
                            case "Inst":{
                                curUser.setInstitution(strAr[2]);
                                break;
                            }

                            case "Unit":{
                                curUser.setResearchUnits(strAr[2]);
                                break;
                            }

                            case "Date":{
                                curUser.setBirthDate(strAr[2]);
                                break;
                            }

                            case "Inter": {
                                curUser.setThemesInterest(strAr[2]);
                                break;
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("IOException on read Thread" + e);
            //curClient.setLog(false);
        }
    }
}
