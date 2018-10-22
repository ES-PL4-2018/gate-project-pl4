package es.gate;

import java.util.HashMap;

public class HashCompiler {

    public static HashMap compileLogin(boolean loginState, User_Account userInfo){

        HashMap login = new HashMap<>();
        if(loginState){
            login.put("loginResult", "granted");
            login.put("accountInfo", userInfo);
        }else{
            login.put("loginResult", "Username and/or pass invalid");
        }
        return login;
    }

    public static HashMap compileCheckEmail(boolean emailFound){

        HashMap<String, Boolean> checkEmail = new HashMap<>();

        checkEmail.put("checkEmailResult", emailFound);

        return checkEmail;
    }

    public static HashMap compileCheckID(boolean idFound){

        HashMap<String, Boolean> checkID = new HashMap<>();

        checkID.put("checkIDResult", idFound);

        return checkID;
    }

    public static HashMap compileFinishRegister(boolean complete){

        HashMap finishRegister = new HashMap();

        finishRegister.put("registerResult", complete);

        return finishRegister;
    }

    public static HashMap compileWriteAswer(boolean complete){

        HashMap writeAnswer = new HashMap();

        writeAnswer.put("writeResult", complete);

        return writeAnswer;
    }
}
