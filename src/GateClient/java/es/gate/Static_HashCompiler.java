package es.gate;

        import java.util.HashMap;

public class Static_HashCompiler {

    public static HashMap compileLogin(String name, String pass){

        HashMap<String, String> login = new HashMap<>();

        login.put("operation", "login");
        login.put("user", name);
        login.put("pass", pass);

        return login;
    }

    public static HashMap compileRegisterChoice(String type, String info, User_Account acc){

        HashMap registerChoice = new HashMap();

        registerChoice.put("comType", type);
        registerChoice.put("info", info);
        registerChoice.put("acc", acc);

        return registerChoice;
    }

    public static HashMap compileCheckEmail(String email){

        HashMap<String, String> checkEmail = new HashMap<>();

        checkEmail.put("operation", "checkEmail");
        checkEmail.put("email", email);

        return checkEmail;
    }

    public static HashMap compileCheckID(String id){

        HashMap<String, String> checkID = new HashMap<>();

        checkID.put("operation", "checkID");
        checkID.put("id", id);

        return checkID;
    }

    public static HashMap compileFinishRegister(User_Account acc){

        HashMap finishRegister = new HashMap();

        finishRegister.put("operation", "register");
        finishRegister.put("account", acc);

        return finishRegister;
    }

    public static HashMap compileUserWrite(User_Account acc){

        HashMap userWrite = new HashMap();

        userWrite.put("operation", "userWrite");
        userWrite.put("account", acc);
        userWrite.put("user", acc.getUserID());

        return userWrite;

    }

}
