package es.gate;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client implements Runnable {

    Socket clientSocket;
    ArrayList<Account> accounts;

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

            HashMap auxMap = null;
            try {
                auxMap = (HashMap) readClient.readObject();
            } catch (ClassNotFoundException e) {
                //
            }
            //Reads a message from the client
            System.out.println(auxMap);
            switch ((String) auxMap.get("operation")) {
                case "login": {
                    String user = (String) auxMap.get("user");
                    String pass = (String) auxMap.get("pass");

                    for (Account acc : accounts) {
                        if (acc.checkLoginInfo(user, pass)) {
                            writeClient.writeObject(HashCompiler.compileLogin(true, acc.getAccount()));
                            System.out.println(acc.getAccount());
                            return;
                        }
                    }
                    writeClient.writeObject(HashCompiler.compileLogin(false, null));
                    break;
                }
                case "checkEmail": {
                    String email = (String) auxMap.get("email");
                    boolean emailFound = false;

                    for (Account acc : accounts) {
                        if (acc.checkDuplicateEmail(email)) {
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
                case "register": {
                    User_Account acc = (User_Account) auxMap.get("account");

                    accounts.add(new Account(acc));

                    writeClient.writeObject(HashCompiler.compileFinishRegister(true));
                    break;
                }
                case "userWrite": {
                    for (Account acc : accounts) {
                        if (acc.getAccount().getUserID().equals(auxMap.get("user"))) {
                            acc.setAccount((User_Account) auxMap.get("account"));
                            writeClient.writeObject(HashCompiler.compileWriteAswer(true));
                            break;
                        }
                    }
                }
            }


        } catch (IOException e) {
            System.err.println("IOException on read Thread" + e);
        }
    }
}
