package ictgradschool.industry.javaclass.printpattern;

public class PrintPatternProgram {

    public void start() {
        
        printPatternOne();
        printPatternTwo();
        
    }
    private void printPatternOne() {
        System.out.println("First Pattern");

        // TODO Uncomment this code once you've created the Pattern class.

        Pattern top = new Pattern(15, '*');
        
        Pattern sideOfFirstLine = new Pattern(7, '#');
        Pattern sideOfLine = new Pattern(7, '~');
        Pattern middle = new Pattern(1, '.');
        
        System.out.println(top);
        System.out.println(sideOfFirstLine.toString() + middle.toString() + sideOfFirstLine.toString());

        for (int i = 0; i < 6; i++) {
            middle.setNumberOfCharacters(middle.getNumberOfCharacters() + 1);
            System.out.println(sideOfLine.toString() + middle.toString() + sideOfLine.toString());
        }

        System.out.println();
    }
    
    private void printPatternTwo() {
        System.out.println("Second Pattern");
        // You complete the code to produce the second pattern
        Pattern first_line = new Pattern(36, '@');
        System.out.println(first_line);

        Pattern equal = new Pattern(12, '=');
        Pattern dop = new Pattern(12, '.');
        System.out.println(equal.toString() + dop.toString() + equal.toString());

        Pattern and_line = new Pattern(13, '&');
        dop.setNumberOfCharacters(10);
        for (int i = 0; i < 6; i ++)
        {
            System.out.println(and_line.toString() + dop.toString() + and_line.toString());
            and_line.setNumberOfCharacters(and_line.getNumberOfCharacters() + 1);
            dop.setNumberOfCharacters(dop.getNumberOfCharacters() - 2);
        }

    }

    public static void main(String[] args) {
        PrintPatternProgram ppp = new PrintPatternProgram();
        ppp.start();
    }
}
