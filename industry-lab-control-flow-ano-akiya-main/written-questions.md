# Written Questions for Industry Lab: Control Flow

## Exercise One: if statements on paper
Do the following **on paper**!
1. Write a Java `if` statement that prints out `"Healthy weight"` if the value of the variable, bmi, is between 19 and 25 (inclusive).
2. Write a line of Java code which declares a boolean variable named `hasFinished` with an initial value of `false`. Then, write some Java code which calls the `printResults()` method if the boolean variable `hasFinished` is true. You may assume that the `printResults()` method has been implemented elsewhere.

## Exercise Two: boolean expressions on paper
Do the following **on paper**!
1. Write a Java  boolean expression which tests whether the value of the char variable, `userResponse`, is equal to either `'y'` or `'Y'`.
2. Write a Java boolean expression which tests whether the value of the int variable, amount, is odd (i.e. not evenly divisible by 2).
3. Write a Java boolean expression which tests whether the String variable, `firstName`, begins with the letter `'A'` or `'a'`.
4. Write a Java boolean expression which tests whether the String variable, `singer`, is equal to `"Taylor Swift"`.  (Hint: remember that Strings are objects, not primitive types.)
5. Write a Java boolean expression which tests whether the value of the int variable `yearBorn`, is greater than 1978 but is not equal to 2013.

## Exercise Three: if … else if statements on paper
Do the following **on paper**!

Complete the `getGender()` method below so that it assigns the correct value to the `gender` variable according to the code passed in as a char parameter.

The gender will be determined as follows:
* If  code is equal to `'F'` or `'f'` the method should assign `"Female"` to `gender`
* else if the code is equal to `'M'`  or `'m'`, then the method should assign `"Male"` to `gender`
* else the method should assign `"Unknown"` to the `gender` variable.

```java
private String getGender (char code) {
   String gender;
   // TODO write your code here
 
   return gender;
}
```

## Exercise Four: while loops on paper
What is the output produced by the following code fragment? Do this exercise **on paper**!
```java
int number = 5;
while (number < 15) {	
    System.out.print (3 * number + " ");
    number += 4;
}
System.out.println();
System.out.println("Number is now: " + number);
```

## Exercise Five: for loops on paper
Do the following **on paper**!

Using a for loop, complete the `printRowOfAmpersands()` method so that it prints a row of ampersands (&).  The number of ampersands it should print is passed via the int parameter, `howMany`.

For example, when called by: `printRowAmpersands(5)`;
The method prints: `&&&&&`

```java
private void printRowOfAmpersands (int howMany) {
    // Write your code here
    
    System.out.println();
}
```

## Exercise Six: Converting a while loop into a for loop
Do the following **on paper**!

Translate the following **while** loop into a **for** loop.

```java
int i = 0;
while (i < 7) { 
    System.out.print(2 * i + 3);
    i++;
}
```