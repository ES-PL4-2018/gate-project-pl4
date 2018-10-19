package es.gate;

import java.util.ArrayList;

public class Interest {

    private ArrayList<String> relevantWords;
    private String interest;

    Interest(String interest, String... words){
        this.interest = interest;
        this.relevantWords = new ArrayList<>();
        for (String s : words){
            relevantWords.add(s);
        }
    }

    public static void main(String[] args) {
        ArrayList<Interest> interests = new ArrayList<>();
        interests.add(new Interest("Informática",
                "Windows", "Linux", "Internet", "C", "Java", "Python", "Inteligência Artificial",
                "Segurança", "Hacking", "Bitcoin"));
        interests.add(new Interest("Matemática"));
        interests.add(new Interest("Biologia"));
        interests.add(new Interest("Física"));
        interests.add(new Interest("Quimíca"));
        interests.add(new Interest("Medicina"));
        interests.add(new Interest("Mecânica"));
    }

    public String getInterest(){
        return interest;
    }

    public ArrayList<String> getWords(){
        return relevantWords;
    }
}

