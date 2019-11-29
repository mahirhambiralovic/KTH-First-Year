If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

**Exercise 2.44**
Give the class two constructors. One should take a single parameter that specifies the price, and the other should take no parameter and set the price to be a default value of your choosing. Test your implementation by creating machines via the two different constructors.

**Answer** Found in src.

**Exercise 2.45**
Implement a method empty, that simulates the effect of removing all money from the machine. This method should have a void return type, and its body should simply set the total field to zero. Does this method need to take any parameters? Test your method by creating a machine, inserting some money, printing some tickets, checking the total, and then emptying the machine. Is the empty method a mutator or an accessor?

**Answer:** Found in src. The method does not need any parameter, as we are simply resetting a variable to zero, every time it is called. The method is a mutator, as it changes the value of a variable.

**Exercise 2.58**
Why does the following version of refundBalance not give the same results as the original?

public int refundBalance()
{
balance = 0;
return balance;
}
What tests can you run to demonstrate that it does not?

**Answer:** This method does not record what the balance was previous to emptying it, and hence cannot return it. The previous method had a local variable, storing the money to be refunded, and returned that. Returning the balance, as in the method above, does not give us much use, as the balance will always be 0 after calling. You can test it by calling it and seeing that the refund will == 0.

**Exercise 2.59**
What happens if you try to compile the TicketMachine class with the following version of refundBalance?

public int refundBalance()
{
return balance;
balance = 0;
}
What do you know about return statements that helps to explain why this version does not compile?

**Answer:** The method is trying to return a value before the method is completed and hence does not compile (the lines of code following it will not be read).

**Exercise 2.60**
What is wrong with the following version of the constructor of TicketMachine?

public TicketMachine(int cost)
{
int price = cost;
balance = 0;
total = 0;
}
Try out this version in the better-ticket-machine project. Does this version compile? Create an object and then inspect its fields. Do you notice something wrong about the value of the price field in the inspector with this version? Can you explain why this is?

**Answer:** This version declares the variable price again, but locally. Since price is preceeded with "int", it makes it a declaration, followed by an assignment, rather than only an assignment. Hence, the value that is stored in price is deleted after the method is finished.

**Exercise 2.61**
Add a new method, emptyMachine, that is designed to simulate emptying the machine of money. It should reset total to be zero but also return the value that was stored in total before it was reset.

**Answer:** Found in src.
