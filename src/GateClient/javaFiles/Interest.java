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
        interests.add(new Interest("Matemática",
                "Euler", "Algebra", "pi", "números complexos", "trigonometria", "estatística",
                "riemann", "leibniz"));
        interests.add(new Interest("Biologia", "ADN", "ARN", "microorganismos", "célula", "genes",
                "darwin", "evolução"));
        interests.add(new Interest("Física", "matéria", "energia", "partículas", "mecânicas quânticas",
        "newton", "einstein", "radiação", "gravidade"));
        interests.add(new Interest("Quimíca", "átomos", "moléculas", "reações químicas",
                "mol", "energia", "lavoisier"));
        interests.add(new Interest("Medicina", "doença", "vírus", "anatomia", "medicamentos",
                "hospital", "bactéria", "vacina", "cirurgia"));
        interests.add(new Interest("Mecânica", "movimento", "energia cinética", "motor", "velocidade",
                "atrito", "f=ma", "aceleração"));
    }

    public String getInterest(){
        return interest;
    }

    public ArrayList<String> getWords(){
        return relevantWords;
    }
}

