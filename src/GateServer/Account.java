import java.util.ArrayList;

public class Account {

    private String userID;
    private String userPass;
    private String userEmail;
    private long userORCID;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String institution;
    private String researchUnits;
    private ArrayList<String> themesInterest;




    public Account(String ID, String pass, String email, long ORCID, String fName, String lName, String bDate, String inst, String units, String themes){

        userID = ID;
        userPass = pass;
        userEmail = email;
        userORCID = ORCID;
        firstName = fName;
        lastName = lName;
        birthDate = bDate;
        institution = inst;
        researchUnits = units;
        themesInterest = new ArrayList<>();

        String strAux[] =  themes.split("$");

        for(String str : strAux)
            themesInterest.add(str);
    }

    public int checkDuplicateInfo(String ID, String Email, long ORCID){
        if(userORCID == ORCID)
            return 1;
        if(userEmail.equals(Email))
            return 2;
        if(userID.equals(ID))
            return 3;
        return 0;
    }

    public int checkDuplicateName(String name){
        return this.userID.equals(name) ? 0 : 1;
    }

    public int checkDuplicateEmail(String email){
        return this.userEmail.equals(email) ? 0 : 1;
    }

    public int checkDuplicateORCID(String email){
        return this.userEmail.equals(email) ? 0 : 1;
    }

    public boolean checkLoginInfo(String ID, String pass){
        return userID.equals(ID) && userPass.equals(pass);
    }

    public String getName(){
        return String.format("%s %s", firstName, lastName);
    }

    public String getProfileInfo(){

        return String.format("%s&%s&%s&%s&%s", getName(), institution, researchUnits, birthDate, getInterests());
    }

    public String getInterests(){

        String inter = "";

        for(String str : themesInterest){
            inter = inter.concat(str + ", ");
        }
        return inter;
    }

    public void setInstitution(String str){
        institution = str;
    }

    public void setResearchUnits(String str){
        researchUnits = str;
    }

    public void setBirthDate(String str){
        birthDate = str;
    }

    public void setThemesInterest(String str){
        //TODO HAha
    }

}
