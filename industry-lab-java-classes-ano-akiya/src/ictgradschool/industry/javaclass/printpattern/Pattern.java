package ictgradschool.industry.javaclass.printpattern;

public class Pattern {
    int number;
    char cha;
    public Pattern(int number, char cha)
    {
        this.number = number;
        this.cha = cha;
    }
    public String toString()
    {
        String output ="";
        for (int i = 0; i < number; i ++) {
            output = output + cha;
        }
        return output;
    }

    public int setNumberOfCharacters(int num)
    {
        number = num;
        return number;
    }
    public int getNumberOfCharacters()
    {
        return number;
    }

}
