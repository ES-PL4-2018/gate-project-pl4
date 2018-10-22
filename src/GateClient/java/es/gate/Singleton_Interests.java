package es.gate;

import java.util.ArrayList;

public class Singleton_Interests {

    private static Singleton_Interests ourInstance;
    private ArrayList<Card_Interests> interests;
    private ArrayList<Card_Interests> selectedInterests = new ArrayList<>();

    private Singleton_Interests() {

        interests = new ArrayList<>();
        interests.add(new Card_Interests("Informatica",
                "Windows", "Linux", "Internet", "C", "Java", "Python", "Inteligência Artificial",
                "Segurança", "Hacking", "Bitcoin"));
        interests.add(new Card_Interests("Matematica",
                "Euler", "Algebra", "pi", "números complexos", "trigonometria", "estatistica",
                "riemann", "leibniz"));
        interests.add(new Card_Interests("Biologia", "ADN", "ARN", "microorganismos", "celula", "genes",
                "darwin", "evoluçao"));
        interests.add(new Card_Interests("Fisica", "materia", "energia", "particulas", "mecanicas quanticas",
                "newton", "einstein", "radiaçao", "gravidade"));
        interests.add(new Card_Interests("Quimica", "atomos", "moleculas", "reações quimicas",
                "mol", "energia", "lavoisier"));
        interests.add(new Card_Interests("Medicina", "doença", "virus", "anatomia", "medicamentos",
                "hospital", "bacteria", "vacina", "cirurgia"));
        interests.add(new Card_Interests("Mecanica", "movimento", "energia cinetica", "motor", "velocidade",
                "atrito", "f=ma", "aceleraçao"));

    }

    public static Singleton_Interests getInstance() {
        if(ourInstance == null){
            ourInstance = new Singleton_Interests();
        }
        return ourInstance;
    }

    public ArrayList<Card_Interests> getInterests() {
        return interests;
    }

    public ArrayList<Card_Interests> getSelectedInterests() {
        return selectedInterests;
    }

    public void setSelectedInterests(ArrayList<Card_Interests> selectedInterests){
        //TODO String to cards
    }

    public void insertInterests(ArrayList<Card_Interests> interests){
        interests.add(new Card_Interests("Informatica",
                "Windows", "Linux", "Internet", "C", "Java", "Python", "Inteligência Artificial",
                "Segurança", "Hacking", "Bitcoin"));
        interests.add(new Card_Interests("Matematica",
                "Euler", "Algebra", "pi", "números complexos", "trigonometria", "estatistica",
                "riemann", "leibniz"));
        interests.add(new Card_Interests("Biologia", "ADN", "ARN", "microorganismos", "celula", "genes",
                "darwin", "evoluçao"));
        interests.add(new Card_Interests("Fisica", "materia", "energia", "particulas", "mecanicas quanticas",
                "newton", "einstein", "radiaçao", "gravidade"));
        interests.add(new Card_Interests("Quimica", "atomos", "moleculas", "reações quimicas",
                "mol", "energia", "lavoisier"));
        interests.add(new Card_Interests("Medicina", "doença", "virus", "anatomia", "medicamentos",
                "hospital", "bacteria", "vacina", "cirurgia"));
        interests.add(new Card_Interests("Mecanica", "movimento", "energia cinetica", "motor", "velocidade",
                "atrito", "f=ma", "aceleraçao"));
    }
}
