package ictgradschool.industry.morepractice.quizmaker;

import ictgradschool.Keyboard;

public class QuizMaker {

    private void start()
    {
        Keyboard input = new Keyboard();
        MultiChoiceQuestion[] question = createQuestions();
        int count = 0;
        for (int i = 0; i < question.length; i++)
        {
            question[i].printQuestion();
            String answer;
            answer = input.readInput();

            if (question[i].isValidAnswer(answer))
            {
                if (question[i].isCorrect(answer))
                {
                    System.out.println("You are correct!");
                    count = count + 1;
                }
                else
                {
                    System.out.println("You are wrong!");
                }
            }
            else
            {
                do {
                    System.out.println("Please enter valid answer");
                    answer = input.readInput();
                }
                while (!question[i].isValidAnswer(answer));
            }
        }

        System.out.println("You answered "+ count + " out of 5 questions correctly!");
    }

    private MultiChoiceQuestion[] createQuestions()
    {
        /*
        int length = 5;
        MultiChoiceQuestion[] IQuestion = new MultiChoiceQuestion[length];
        for (int i = 0; i < length; i++)
        {
            MultiChoiceQuestion choice = new MultiChoiceQuestion("What is 1 + 1?", "A) 0", "B) 2", "C) -7","D) Infinity","B");
            IQuestion[i] = choice;
        }
        */

        int length = 5;
        MultiChoiceQuestion[] IQuestion = new MultiChoiceQuestion[length];
        IQuestion[0] = new MultiChoiceQuestion("What is 1 + 1?", "A) 0", "B) 2", "C) -7","D) Infinity","B");
        IQuestion[1] = new MultiChoiceQuestion("What is 1 + 2?", "A) 0", "B) 3", "C) -7","D) Infinity","B");
        IQuestion[2] = new MultiChoiceQuestion("What is 1 + 3?", "A) 0", "B) 4", "C) -7","D) Infinity","B");
        IQuestion[3] = new MultiChoiceQuestion("What is 1 + 4?", "A) 0", "B) 5", "C) -7","D) Infinity","B");
        IQuestion[4] = new MultiChoiceQuestion("What is 1 + 5?", "A) 0", "B) 6", "C) -7","D) Infinity","B");

        return IQuestion;
    }

    public static void main(String[] args)
    {
        new QuizMaker().start();
    }
}
