# Industry Lab: Arrays
Note: there are also some written exercises available for this lab in the `written-questions.md` document [here](written-questions.md). It is suggested that you start with the practical exercises in this lab. You may use the written exercises to revise the concepts in the lab after you have spent some time working on the practical exercises.

## Exercise One: Array Practice
Open the `ArrayPractice` class `ictgradschool.industry.arrays.ArrayPractice`.

Within the `ArrayPractice` class, there are two incomplete methods:

- `getSumOfPositiveIntegers` is a method that should take an int array as an argument and return the sum of all positive integers in the array
- `getLongestString` in a method that should take a String array as an argument and return the longest String in the array

The `TODO` comments indicate where you should add your code to complete this exercise.

You should complete the contents of these methods and check if you can run them and view the result.

The `ArrayPractice` class contains all method calls, `System.out...` statements and variables required to test the code when you have completed the contents of the methods. When you have completed the contents of the methods, you can run the class to test your code.  

Make sure to look at the `GetLowestInt` example ( `industry-lab-arrays.src.example.basicexamples.GetLowestInt` ) as it is fairly similar in structure to the way you would solve these problems. 

Hint: These are some of the basic steps for completing the `getSumOfPositiveIntegers` method, these are the general steps involved:

- Inside the `getSumOfPositiveIntegers`, create a new variable that can store the sum of all positive integers
- Loop through the `integerArray` parameter
- Inside of the loop, check if each integer is positive
- If an integer is positive, add it to the total
- Outside of the loop, return the sum you calculated

This general pattern of steps can be repeated for the `getLongestString` method even though some specific details will vary.

## Exercise Two: Basic Array Programming Exercises
Complete all methods in `ictgradschool.industry.arrays.BasicArrayProgramming.java`. Instructions for what each method does is written in the comments in the file, as are example inputs and outputs.

You can test your answers by running the unit tests supplied in the `TestProgrammingExercises` class, in the `test` folder. You can right-click this class and choose "Run TestCodeRunner". IntelliJ will give you a summary of which tests pass and fail, which should help you debug your code.


## Challenge Exercise Three: Advanced Array Programming Exercises
This exercise is extension material for you to work on once you've completed all other lab exercises. If you don't get round to it during the lab, that's OK - this question is more difficult than what you would expect to see in a test. In that case, it's a good idea to come back to it later on in the course, once you're more comfortable with the course content - but these exercises are still really valuable to complete.

**Note:** Support from tutors / instructors on these questions is extremely limited, as their focus will be on assisting students with the preceding exercises.

Complete all methods in `ictgradschool.industry.arrays.AdvancedArrayProgramming.java`. Instructions for what each method does is written in the comments in the file, as are example inputs and outputs.

You can test your answers by running the unit tests supplied in the `TestAdvancedProgrammingExercises` class, in the `test` folder. You can right-click this class and choose "Run TestCodeRunner". IntelliJ will give you a summary of which tests pass and fail, which should help you debug your code.