# Industry Lab: Control Flow

Note: there are also some written exercises available for this lab [here](written-questions.md). It is suggested that you start with the practical exercises in this lab. You may use the written exercises to revise the concepts in the lab after you have spent some time working on the practical exercises.

## Exercise: Grade calculator

Using the skeleton code found in the `GradeCalculator` class in `src.ictgradschool.industry.controlflow.gradecalculator`:

### Step 1)

Use conditional statements (if/else if or switch) within the `getLetterGrade()` method to get determine the letter grade based on the percentage that the user inputs. 

You can choose how you structure your conditional control flow but make sure that it meets the requirements:

- 85% - 100% = A
- 70% - 84% = B
- 50% - 69% = C
- 0% - 49% = D

Make sure to edit the code within the `getLetterGrade()` method so that it returns the required character. 

### Step 2)

Notice that currently the code will allow the user to input any number and the user could enter a number that is much larger than 100 or smaller than 0.

Modify the code within `getPercentageScore()` so that if the user enters a number less than 0 or greater than 100 the prompt repeats itself and asks the user to enter the number again. You should use some sort of loop for this.

You may want to look at the example that uses a loop to repeat a prompt. 

You will probably find it difficult to make it work for edge cases like the user entering alphabetical characters; this is because the program will crash when the user enters a character that cannot be parsed to a double. Do not worry about accounting for this case as we will cover exception handling in future lectures. 

## Exercise: Guessing game using a while loop

Write a program so that the user can play the game of guessing a number between 1 and 100. Use the following pseudocode to write the code:

* Generate a random number between 1 and 100 and store in a variable named `goal`
* Declare a variable named `guess`
* Initialise `guess` to 0
* While the user’s guess is not correct (i.e. `while (guess != goal)`):
  * Ask the user to enter their guess
  * Store the guess in the `guess` variable
  * If the guess is greater than the goal, print `"Too high, try again"`
  * Else if the guess is less than the goal, print `"Too low, try again"`
  * Else print the message `"Perfect!!"`
* Print `"Goodbye"`

Here is an example of the output of the game:

```text
Enter your guess (1 – 100): 50
Too low, try again
Enter your guess (1 – 100): 75
Too high, try again
Enter your guess (1 – 100): 70
Perfect!
Goodbye
```

The skeleton code is found in: `ictgradschool.industry.controlflow.guessing.GuessingGame.java`

## Exercise: CodeRunner Exercises

Complete the skeleton code found in `ictgradschool.industry.controlflow.coderunner.CodeRunner.java` to answer the following questions.

You can test your answers by running the unit tests supplied in the `TestCodeRunner` class, in the `test` folder. You can right-click this class and choose "Run TestCodeRunner". IntelliJ will give you a summary of which tests pass and fail, which should help you debug your code.

1. Complete the method `areSameName()` such that:
   
   a. When given two names that match exactly, outputs `"Same name"` , otherwise
   
   b. When given two names that have the same first character (case sensitive), outputs `"Same first letter"`, otherwise
   
   c. Output `"No match"`
   
   **Hint:** remember you can nest and/or chain conditional flow structures together.

2. Complete the method `isALeapYear()` such that:
   
   a. If the given year is exactly divisible by 4 return true, unless
   
   b. The given year is also exactly divisible by 100 but not exactly divisible by 400, in which case return false, otherwise
   
   c. Return false
   
   **Hint:** if you’re struggling look up leap year on Wikipedia and look for ‘algorithm’.

3. Complete the method `reverseString()` that outputs the given string in reverse order. You may assume the string is non-empty.

4. Complete the method `isPrime()` that outputs true if the given integer is a prime number, false otherwise. As a reminder, a prime number has only two exact divisors, 1 and itself. 1 is not prime. Hint: the largest potential divisor for a number `X` is `X / 2`. Also, return early. Bonus points – assuming you take the naive approach to solving this question, can you tell me what a potential drawback of your technique is?

5. Complete the method `isStringPalindrome()` which determines if the given string is a palindrome.  Whitespace and case should be ignored. Assume all strings are non-null and non-empty.
   
   **Hint:** Your answer to a previous question in this exercise should be of great help in answering this question (but DO NOT copy / paste code - call the method)! Also investigate the `String` class's `toLowerCase()` method for helping you to ignore case, and its `replaceAll()` method for helping you to ignore whitespace.

6. Complete the method `printPrimeNumbers()` that return a String containing a space separated list of all of the prime numbers starting at 2 and all the way up to and including the given integer. If no prime numbers are found, return `"No prime number found"`.
   
   **Hint:** Again, your answer to a previous question in this exercise can be used in your answer to this question (but DO NOT copy / paste code - call the method).

7. Complete the method `simpleMultiplicationTable()` that, given an integer, outputs a table showing the multiplication table (rows and columns) starting at 1 and up to and including that number. Any 'cell' in the table should display the result of multiplying that row number by that column number. So for an input of 2, I’d expect the method to output a table 2 columns wide and 2 rows tall like so:
   
   ```text
   1 2
   2 4
   ```
   
   Then an input of 3 would result in a 3x3 table like so:
   
   ```text
   1 2 3
   2 4 6
   3 6 9
   ```
   
   **Hint:** remember, you can nest loops too! Also, `"\n"` is the special character for new line.

## Exercise: The game of rock, paper and scissors

This application allows the user to play the game, "Rock Paper Scissors". This game is played as follows: in each round the player choose either Rock, Paper or Scissors, and the computer randomly chooses either Rock, Paper or Scissors. The winner of that round depends on the items chosen by the computer and the player. If the same item is chosen, the result is a tie. If the two chosen items are rock and scissors, then the rock wins, because a rock smashes scissors. If scissors and paper are chosen, the scissors win, because scissors cut paper. If paper and rock are chosen, the paper wins, because paper covers rock.

Here is an example of the output of the application:

```text
Hi! What is your name? Yu-Cheng

1. Rock
2. Scissors
3. Paper
4. Quit
Enter choice: 1

Yu-Cheng chose rock.
Computer chose scissors.
Yu-Cheng wins because rock smashes scissors.

1. Rock
2. Scissors
3. Paper
4. Quit
Enter choice: 2

Yu-Cheng chose scissors.
Computer chose scissors.
No one wins.

1. Rock
2. Scissors
3. Paper
4. Quit
Enter choice: 3

Yu-Cheng chose paper.
Computer chose scissors.
The computer wins because scissors cut paper.

1. Rock
2. Scissors
3. Paper
4. Quit
Enter choice: 4

Goodbye Yu-Cheng. Thanks for playing :)
```

When testing the user choice or the computer choice, you must use the symbolic constants that have been declared at the top of the program. E.g. 
`public static final int ROCK = 1;`

You will need to implement the following methods:

1. **displayPlayerChoice() method**
   
    The `displayPlayerChoice()` method has one String parameter and one int parameter. Complete the method so that it prints one line of output. The first part of the output is obtained from the String parameter. The second part depends on the second int parameter (which you should compare with the global constants). Depending on what value the user has entered, the second part of the output will be either: `" chose scissors"`, `" chose rock"`, or `" chose paper"`.

2. **userWins() method**
   
    The `userWins()` method has two int parameters and returns a boolean. The first int parameter is the user’s choice and the second int parameter is the computer’s choice. The method returns true if the user choice beats the computer choice, otherwise the method returns false.

3. **getResultString() method**
   
    The `getResultString()` method has two int parameters and returns a String. There are four possible Strings which can be returned by this method:
   
   ```java
   final String PAPER_WINS = "paper covers rock";
   final String ROCK_WINS = "rock smashes scissors";
   final String SCISSORS_WINS = "scissors cut paper";
   final String TIE = " you chose the same as the computer";
   ```
   
    The String which is returned depends on the values of the two int parameters. If the two parameter values are equal then the method returns `TIE`.

4. **start() method**
   
    The `start()` method calls the previous methods for running the application. You will also need to implement the following to complete the application:
   
   * Printing the prompt and reading the input from the user for the name
   * Printing the prompt and reading the input from the user for the choice of rock, scissors, paper, or quit
   * While the user is playing, display the player choice, determine who wins, and display the results
   * Printing a message to display the goodbye message when the user chooses to quit the application

The skeleton code is found in: `ictgradschool.industry.controlflow.rockpaperscissors.RockPaperScissors.java`

## Challenge Exercise: Advanced CodeRunner Exercises

This exercise is extension material for you to work on once you've completed all other lab exercises. If you don't get round to it during the lab, that's OK - this question is more difficult than what you would expect to see in a test. In that case, it's a good idea to come back to it later on in the course, once you're more comfortable with the course content.

**Note:** Support from tutors / instructors on these questions is extremely limited, as their focus will be on assisting students with the preceding exercises.

For this exercise, complete the code in `ictgradschool.industry.controlflow.coderunner.AdvancedCodeRunner.java` to answer the following questions. You may unit test your code by running `TestAdvancedCodeRunner`:

1. Complete the method `reverseInt()` that takes an integer and outputs the integer that has the number in reverse order. If given a negative integer, the number should be the reversed digits with the negative sign staying at the front, i.e. `reverseInt(-45) => -54`. Do **not** use String conversion or methods – there is a mathematics answer for this one.
   
   **Hint:** You can find the value in the rightmost digit of a number (the 'ones' place) by using number modulo 10, and you’ll need to loop through the input number.

2. Complete the method `isIntPalindrome()` which determines if the digits of the given integer are palindromic, i.e. it reads the same backwards as forwards. Any leading negative signs should be ignored for the purposes of this exercise. Your answer should involve calling the `reverseInt()` method you wrote in step 1.

3. Complete the method `convertIntToColTitle()` that converts an integer to an excel column letter; column 1 being `"A"`, column 2 is `"B"`, column 26 is `"Z"`, column 27 is `"AA"`, column 28 is `"AB"`, etc. This time you also need to include some sanity checking to ensure the integer passed in is valid (must be greater than 0) and if not, output the string `"Input is invalid"`.
   
   **Hint:** you can cast a char to an int and vice-versa, e.g. `(int)'A'` results in `65` and `(char)90 `results in `'Z'`.
