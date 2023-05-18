package ictgradschool.industry.morepractice.quizmaker;

import java.util.Locale;

public class MultiChoiceQuestion implements IQuestion{

    private String question = "";
    String[] posibleAnswers = new String[4];
    private String correctAnswer;
    public MultiChoiceQuestion(String question,String MCQ_one,String MCQ_two,String MCQ_three,String MCQ_four,String correctAnswer)
    {
        this.question = question;
        this.posibleAnswers[0] = MCQ_one;
        this.posibleAnswers[1] = MCQ_two;
        this.posibleAnswers[2] = MCQ_three;
        this.posibleAnswers[3] = MCQ_four;

        this.correctAnswer = correctAnswer;
    }
    public void printQuestion()
    {
        System.out.println(question);
        for (int i = 0; i < 4; i++)
        {
            System.out.println(posibleAnswers[i]);
        }
    }

    public Boolean isValidAnswer(String answer)
    {
        if ((answer.toLowerCase()).equals("a")
        || (answer.toLowerCase()).equals("b")
        ||(answer.toLowerCase()).equals("c")
        ||(answer.toLowerCase()).equals("d"))
        {
            return true;
        }
        else
            return false;
    }

    public Boolean isCorrect(String valid_answer)
    {
        if ((valid_answer.toLowerCase()).equals((correctAnswer.toLowerCase())))
        {
            return true;
        }
        else
            return false;
    }
}
