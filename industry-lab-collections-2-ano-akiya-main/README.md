# Industry Lab: More Collections

## Exercise One: Pancakes
The restaurant, **PancakeTopia**, is a very unusual, yet popular restaurant. Every day for lunch, they make a certain number of pancakes at random and put them in a large **stack**. Customers who want some delicious pancake-y goodness for lunch form a large **queue** outside. In turn, the restaurant lets one customer into the restaurant, who sits down at the table and eats as many pancakes as they want from the top of the stack. One that person is done, the next person sits down, and so on, until **PancakeTopia** runs out of either pancakes or customers for the day. Sometimes, customers at the end of the queue might not get fed – but **PancakeTopia** remains in business since their pancakes are the best in the land – the reward is worth the risk!

In this exercise, we’ll complete a program which models a typical lunchtime at PancakeTopia. The nearly-complete application is located in the `ex04` package, and example outputs for the *complete* program (once you’ve made the necessary changes) can be found in the files `PancakeTopia-ExampleOutput-01.txt` and `PancakeTopia-ExampleOutput-02.txt`, which are located directly in the project directory. Here are the steps to go through to complete this exercise.

### Step 1: Understanding
Have a look at the code and see what’s there. Try to get an idea of how everything fits together. Perhaps try to draw some quick UML diagrams to assist you. This is often a good first step when trying to learn any new system.
### Step 2: Getting the customers to form a queue
In the PancakeApp class, you’ll have noticed a method called **createCustomerQueue()** which creates a random number of customers, and should add those customers to a queue. For this step, complete this method. Firstly, initialize the queue variable to something other than **null**. Secondly, call one of **queue**’s methods at the marked location to add the generated customer to that queue. Remember that queues are `First-In-First-Out (FIFO)` – meaning, the first customer to line up will be the first to get served.
Next, in **PancakeShop’s serveLunch()** method, there’s a loop where we want to continually get the customer at the front of the queue. Complete that line by using an appropriate **poll** statement. Remember that we should be de-queuing customers in the same order that we queue them.

### Step 3: Stacking those pancakes
In **PancakeShop’s createPancakes()** method, we are creating a random number of Pancakes. Complete the method so that created pancakes get added to the top of the pancakes stack. Remember that stacks are `Last-In-First-Out (LIFO)` – meaning, the last pancake to be added to the stack will be the first one that’s eaten by a customer.
### Step 4: Eat pancakes!
We now have a queue of customers and a stack of pancakes. It’s time to teach the customers how to eat! This is handled in the **Customer’s eat()** method, which is largely unimplemented at this point. In this method, customers are handed a stack of pancakes and should try to eat as many pancakes from the top of the stack as will fit in their belly. If there’s not enough pancakes for them, they should complain (by throwing a tantrum / **Exception**).
Further details about what the method should do can be seen in the provided comments and by examining the provided example outputs.
