package ictgradschool.industry.morepractice.quizmaker;

public interface IQuestion {

    public void printQuestion();

    public Boolean isValidAnswer(String userAnswer);

    public Boolean isCorrect(String userAnswer);
}
