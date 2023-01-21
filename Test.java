import java.util.ArrayList;
public class Test
{
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    public Test(ArrayList<String> q, ArrayList<String> a)
    {
        questions = q;
        answers = a;
    }
    public String displayQuestion(int ind)
    {
        return(questions.get(ind));
    }
    public String getAnswer(int ind)
    {
        return(answers.get(ind));
    }
}
