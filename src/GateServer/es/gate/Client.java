package es.gate;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import es.gate.HashCompiler.*;

public class Client implements Runnable {

    ObjectInputStream in;
    ObjectOutputStream out;
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
            ObjectInputStream readClient = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream writeClient = new ObjectOutputStream(clientSocket.getOutputStream());
            //Auxiliary variables to facilitate code
            int auxInt;
            String auxStr;
            String[] strAr;
            HashMap auxMap = null;


            while (true) {

                auxInt = 0;
                try{
                    auxMap = (HashMap)readClient.readObject();
                }catch(ClassNotFoundException e){
                    //
                }
                  //Reads a message from the client
                System.out.println(auxMap);
                switch ((String)auxMap.get("operation")) {
                    case "login": {
                        String user = (String)auxMap.get("user");
                        String pass = (String)auxMap.get("pass");

                        for (Account acc : accounts) {
                            if (acc.checkLoginInfo(user, pass)) {
                                curUser = acc;
                                writeClient.writeObject(HashCompiler.compileLogin(true, curUser.getAccount()));
                                System.out.println(curUser.getAccount());
                                return;
                            }
                        }
                        writeClient.writeObject(HashCompiler.compileLogin(false, null));
                        break;
                    }
                    case "checkEmail": {
                        String email = (String)auxMap.get("email");
                        boolean emailFound = false;

                        for(Account acc : accounts){
                            if(acc.checkDuplicateEmail(email)){
                                emailFound = true;
                                break;
                            }
                        }
                        writeClient.writeObject(HashCompiler.compileCheckEmail(emailFound));
                        break;
                    }
                    case "checkID": {
                        String id = (String) auxMap.get("id");
                        boolean idFound = false;

                        for (Account acc : accounts) {
                            if (acc.checkDuplicateID(id)) {
                                idFound = true;
                                break;
                            }
                        }
                        writeClient.writeObject(HashCompiler.compileCheckID(idFound));
                        break;
                    }
                    case "register":{
                        User_Account acc = (User_Account)auxMap.get("account");

                        curUser = new Account(acc);
                        accounts.add(curUser);

                        writeClient.writeObject(HashCompiler.compileFinishRegister(true));
                        break;
                    }
                    case "userWrite":{
                        for(Account acc : accounts){
                            if(acc.getAccount().getUserID().equals(auxMap.get("user"))){
                                acc.setAccount((User_Account)auxMap.get("account"));
                                writeClient.writeObject(HashCompiler.compileWriteAswer(true));
                                break;
                            }
                        }
                    }
                    /*
                    case "!checkUser": {
                        for (es.gate.Account acc : accounts) {
                            auxInt = acc.checkDuplicateName(strAr[1]);
                            if (auxInt == 1) {
                                break;
                            }
                        }
                        auxStr = String.format("%d", auxInt);
                        writeClient.writeUTF(auxStr);
                        System.out.println(auxStr);
                        break;
                    }
                    case "!checkEmail": {
                        for (es.gate.Account acc : accounts) {
                            auxInt = acc.checkDuplicateEmail(strAr[1]);
                            if (auxInt == 1) {
                                break;
                            }
                        }
                        auxStr = String.format("%d", auxInt);
                        writeClient.writeUTF(auxStr);
                        System.out.println(auxStr);
                        break;
                    }

                    case "!checkOrcid": {
                        for (es.gate.Account acc : accounts) {
                            auxInt = acc.checkDuplicateORCID(strAr[1]);
                            if (auxInt == 1) {
                                break;
                            }
                        }
                        auxStr = String.format("%d", auxInt);
                        writeClient.writeUTF(auxStr);
                        System.out.println(auxStr);
                        break;
                    }

                    case "!register":{

                        curUser = new es.gate.Account(strAr[1], strAr[2], strAr[3], Long.parseLong(strAr[4]), strAr[5], strAr[6], strAr[7], strAr[8], strAr[9], strAr[10]);

                        accounts.add(curUser);
                        System.out.println("New Registry: " + strAr[1]);
                        writeClient.writeUTF(String.format("1"));
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
                    */
                }
            }

        } catch (IOException e) {
            System.err.println("IOException on read Thread" + e);
            //curClient.setLog(false);
        }
    }
}
