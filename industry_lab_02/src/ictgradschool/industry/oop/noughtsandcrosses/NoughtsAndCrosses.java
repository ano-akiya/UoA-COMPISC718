package ictgradschool.industry.oop.noughtsandcrosses;

/**
 * Write a program to extract 3 rows of 6 characters from a String of 18 characters.
 * The program should print out the 3 rows, followed by the left diagonal of the 3 rows.
 * The String method substring() can be used to extract the required characters.
 */
public class NoughtsAndCrosses {
    /**
     * Runs an example output.
     */
    private void start() {
        String letters = "X X O O X O X O X ";

        String row1 = getRow(letters, 1);

        String row2 = getRow(letters, 2);

        String row3 = getRow(letters, 3);

        printRows(row1, row2, row3);

        String leftDiagonal = getLeftDiagonal(row1, row2, row3);

        printDiagonal(leftDiagonal);
    }

    /**
     * TODO Implement this
     */
    public String getRow(String letters, int row)
    {
        String needed_char = letters.substring((row - 1) * 6 , row * 6);
        return needed_char;
    }

    /**
     * TODO Implement this
     */
    public void printRows(String row1, String row2, String row3)
    {
        System.out.println("Row1 is : " + row1);
        System.out.println("Row2 is : " + row2);
        System.out.println("Row3 is : " + row3);
    }

    /**
     * TODO Implement this
     */
    public String getLeftDiagonal(String row1, String row2, String row3)
    {
        String first = String.valueOf(row1.charAt(0));
        String second = String.valueOf(row2.charAt(2));
        String third = String.valueOf(row3.charAt(4));
        String diagonal;
        diagonal = first.concat(second);
        diagonal = diagonal.concat(third);
        return diagonal;
    }

    /**
     * TODO Implement this
     */
    public void printDiagonal(String leftDiagonal)
    {
        System.out.println("Left Diagonal is: " + leftDiagonal);
    }

    /**
     * Program entry point. Do not edit.
     */
    public static void main(String[] args) {
        NoughtsAndCrosses ex = new NoughtsAndCrosses();
        ex.start();
    }
}
