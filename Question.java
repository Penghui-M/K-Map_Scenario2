import java.util.*;
import java.io.*;


public class Question {
    private List<String> questions = new ArrayList<String>();
    private List<String> answers = new ArrayList<String>();

    public Question() {
        // Read the questions from the file
        try {
            BufferedReader br = new BufferedReader(new FileReader("./questions/questions.csv"));

            // skips the first line
            br.readLine();

            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                questions.add(values[0]);
                answers.add(values[1]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void addQuestion(String question, String answer) {
        questions.add(question);
        answers.add(answer);
    }

    public void removeQuestion(int index) {
        questions.remove(index);
        answers.remove(index);
    }

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./questions/questions.csv"));
            bw.write("QUESTION,ANSWER");
            for (int i = 0; i < questions.size(); i++) {
                bw.write(questions.get(i) + "," + answers.get(i));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}


