import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionScanner {
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    private File fil;

    public QuestionScanner(ArrayList<String> q, ArrayList<String> a, File f) {
        questions = q;
        answers = a;
        fil = f;
    }

    public void addQA(int count) throws FileNotFoundException {
        Scanner fileReader = new Scanner(fil);
        String text = "";
        for (int i = 1; i <= count; i++) {
            text = fileReader.nextLine();
            questions.add(text);
            text = fileReader.nextLine();
            answers.add(text);
        }
    }
}