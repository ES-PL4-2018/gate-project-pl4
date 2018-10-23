package es.gate;

public class Account {

    User_Account account;

    public Account(User_Account acc){

        account = acc;
    }

    public boolean checkDuplicateID(String name){
        return this.account.getUserID().equals(name);
    }

    public boolean checkDuplicateEmail(String email){
        return this.account.getUserEmail().equals(email);
    }

    public int checkDuplicateORCID(long ORCID){
        return this.account.getUserORCID() == ORCID ? 1 : 0;
    }

    public boolean checkLoginInfo(String ID, String pass){
        return account.getUserID().equals(ID) && account.getUserPass().equals(pass);
    }

    public User_Account getAccount(){
        return account;
    }

    public void setAccount(User_Account account) {
        this.account = account;
    }

    /*
    public String getName(){
        return String.format("%s %s", account.getFirstName(), account.getLastName());
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
*/
}
