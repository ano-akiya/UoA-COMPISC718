package ictgradschool.industry.introtojava.variables;

/**
 *  This exercise is used to practice basic variables
 *
 *  Run this program to view the output in the console then
 *  complete the steps outline in the 'Variables' lab exercise
 *
 * */

public class Variables {

    public void start(){

        // TODO: When you first open this class, try running it and check to see that you can see the output in the console

        // TODO Step 1) add an age after the '=' operator to assign a value to the variable then run the code to test it
        int age = 0;
        // The System.out... statement outputs the age combined with the String literal "The age is "
        System.out.println("The age is " + age);

        // TODO Step 2) Create a second int variable called monthsSinceBirthday and assign a number of months between 1-11
        int monthsSinceBirthday = 10;
        // TODO Step 3) Create a 'System.out...' statement to output the monthsSinceBirthday variable with an appropriate message
        System.out.println("The  months since birthday is " + monthsSinceBirthday);
        // TODO  Step 4) Follow the instructions in the lab to calculate the value of the 'daysOnEarth' variable
        int daysOnEarth = 0;
        for (int month = 1; month <= monthsSinceBirthday; month ++)
        {
            if (month % 2 != 0)
            {
                daysOnEarth = daysOnEarth + 31;
            }
            else
            {
                if (month == 2)
                {
                    daysOnEarth = daysOnEarth + 28;
                }
                else if (month == 8)
                {
                    daysOnEarth = daysOnEarth + 31;
                }
                else
                {
                    daysOnEarth = daysOnEarth + 30;
                }
            }

        }
        System.out.println("The days on Earth is " + daysOnEarth);

    }

    public static void main(String[] args) {

        Variables variables = new Variables();
        variables.start();

    }

}
