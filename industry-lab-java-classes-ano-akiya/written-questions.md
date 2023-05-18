# Written Exercises for Industry Lab: Java Classes

### Written Exercise One: Object references

After the following statements are executed, what are the values stored in each variable?

```java
int a = 7;
int b = 1;
int c = a + 2;
a = b;
b = c;
c = c + 1;
```

After the following statements are executed, what are the outputs? The method setFruitName(String) changes the fruit name and the method getFruitName() returns the fruit name of the object. You can find the Fruit class in the given source code for this lab.

```java
Fruit apple = new Fruit("red apple");
Fruit orange = new Fruit("orange");
Fruit greenApple = apple;

System.out.println("The fruit is " + apple.getFruitName());
System.out.println("The fruit is " + orange.getFruitName());
System.out.println("The fruit is " + greenApple.getFruitName());

orange.setFruitName("navel orange");
greenApple.setFruitName("green apple");

System.out.println("The fruit is " + apple.getFruitName());
System.out.println("The fruit is " + orange.getFruitName());
System.out.println("The fruit is " + greenApple.getFruitName());
```