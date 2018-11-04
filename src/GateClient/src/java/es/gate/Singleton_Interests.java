package es.gate;

import es.gate.Cards.Interests;

import java.util.ArrayList;

public class Singleton_Interests {

    private static Singleton_Interests ourInstance;
    private ArrayList<Interests> interests;
    private ArrayList<Interests> selectedInterests = new ArrayList<>();

    private Singleton_Interests() {

        interests = new ArrayList<>();
        interests.add(new Interests("Informatica",
                "Windows", "Linux", "Internet", "C", "Java", "Python", "Inteligência Artificial",
                "Segurança", "Hacking", "Bitcoin"));
        interests.add(new Interests("Matematica",
                "Euler", "Algebra", "pi", "números complexos", "trigonometria", "estatistica",
                "riemann", "leibniz"));
        interests.add(new Interests("Biologia", "ADN", "ARN", "microorganismos", "celula", "genes",
                "darwin", "evoluçao"));
        interests.add(new Interests("Fisica", "materia", "energia", "particulas", "mecanicas quanticas",
                "newton", "einstein", "radiaçao", "gravidade"));
        interests.add(new Interests("Quimica", "atomos", "moleculas", "reações quimicas",
                "mol", "energia", "lavoisier"));
        interests.add(new Interests("Medicina", "doença", "virus", "anatomia", "medicamentos",
                "hospital", "bacteria", "vacina", "cirurgia"));
        interests.add(new Interests("Mecanica", "movimento", "energia cinetica", "motor", "velocidade",
                "atrito", "f=ma", "aceleraçao"));

    }

    public static Singleton_Interests getInstance() {
        if(ourInstance == null){
            ourInstance = new Singleton_Interests();
        }
        return ourInstance;
    }

    public ArrayList<Interests> getInterests() {
        return interests;
    }

    public ArrayList<Interests> getSelectedInterests() {
        return selectedInterests;
    }

    public void setSelectedInterests(ArrayList<Interests> selectedInterests){
        //TODO String to cards
    }

    public void insertInterests(ArrayList<Interests> interests){
        interests.add(new Interests("Informatica",
                "Windows", "Linux", "Internet", "C", "Java", "Python", "Inteligência Artificial",
                "Segurança", "Hacking", "Bitcoin"));
        interests.add(new Interests("Matematica",
                "Euler", "Algebra", "pi", "números complexos", "trigonometria", "estatistica",
                "riemann", "leibniz"));
        interests.add(new Interests("Biologia", "ADN", "ARN", "microorganismos", "celula", "genes",
                "darwin", "evoluçao"));
        interests.add(new Interests("Fisica", "materia", "energia", "particulas", "mecanicas quanticas",
                "newton", "einstein", "radiaçao", "gravidade"));
        interests.add(new Interests("Quimica", "atomos", "moleculas", "reações quimicas",
                "mol", "energia", "lavoisier"));
        interests.add(new Interests("Medicina", "doença", "virus", "anatomia", "medicamentos",
                "hospital", "bacteria", "vacina", "cirurgia"));
        interests.add(new Interests("Mecanica", "movimento", "energia cinetica", "motor", "velocidade",
                "atrito", "f=ma", "aceleraçao"));
    }
}
