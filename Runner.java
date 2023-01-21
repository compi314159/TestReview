import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Test name:");
        String testName = input.nextLine();
        System.out.println("\n\t\t\t" + testName + " Review");
        System.out.println("\t\t▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔");
        System.out.println();
        System.out.print("Number of terms:");
        int termCount = input.nextInt();
        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<String> answers = new ArrayList<String>();
        File file1 = new File("C:\\Users\\anamasivayam857\\Downloads\\testReview.txt");
        QuestionScanner q1 = new QuestionScanner(questions, answers, file1);
        q1.addQA(termCount);
        System.out.println("Questions and Answers Logged");
        System.out.println("TESTING TIME!");
        System.out.println("Question Format:");
        System.out.println("1. Short Answer");
        System.out.println("2. Multiple Choice");
        int questionType = 0;
        while ((questionType != 1) && (questionType != 2)) {
            System.out.print("Question format number:");
            questionType = input.nextInt();
        }
        System.out.print("Number of questions on practice test: ");
        int questionCount = input.nextInt();
        Test t1 = new Test(questions, answers);
        int score = 0;
        if (questionType == 1) {
            for (int i = 1; i <= questionCount; i++) {
                System.out.println("Question " + i + ": ");
                int index = (int) (questions.size() * Math.random());
                String questionToDisplay = t1.displayQuestion(index);
                String answerToCheck = t1.getAnswer(index);
                System.out.println(questionToDisplay);
                System.out.println("Answer:");
                String ans = input.nextLine();
                if (ans.equalsIgnoreCase(answerToCheck)) {
                    System.out.println("CORRECT");
                    score++;
                } else {
                    System.out.println("INCORRECT");
                }
            }
        } else if (questionType == 2) {
            System.out.print("Number of answer options: ");
            int choiceCount = input.nextInt();
            while (choiceCount > questions.size()) {
                System.out.print("Invalid entry, please try again: ");
                choiceCount = input.nextInt();
            }
            Test t2;
            for (int i = 1; i <= questionCount; i++) {
                ArrayList<String> questionsCopy = new ArrayList<String>();
                ArrayList<String> answersCopy = new ArrayList<String>();
                QuestionScanner q2 = new QuestionScanner(questionsCopy, answersCopy, file1);
                q2.addQA(termCount);
                t2 = new Test(questionsCopy, answersCopy);
                System.out.println("Question " + i + ": ");
                int index = (int) (questions.size() * Math.random());
                String questionToDisplay = t2.displayQuestion(index);
                String answerToCheck = t2.getAnswer(index);
                System.out.println(questionToDisplay);
                String a = t2.getAnswer(index);
                questionsCopy.remove(index);
                answersCopy.remove(index);
                int correctChoice;
                int answerPosition = ((int) (choiceCount * Math.random())) + 1;
                for (int j = 1; j <= choiceCount; j++) {
                    if (j == answerPosition) {
                        System.out.println(j + ") " + a);
                    } else {
                        int randInt = (int) (questionsCopy.size() * Math.random());
                        System.out.println(j + ") " + t2.getAnswer(randInt));
                        questionsCopy.remove(randInt);
                        answersCopy.remove(randInt);
                    }
                }

                System.out.print("Answer:");
                int ans = input.nextInt();
                if (ans == answerPosition) {
                    System.out.println("CORRECT");
                    score++;
                } else {
                    System.out.println("INCORRECT");
                }
            }
        }
        System.out.println("Score: " + score + "/" + questionCount);
    }
}
//add checker to see if mcq answer is out of bounds
//saq question 1 not working