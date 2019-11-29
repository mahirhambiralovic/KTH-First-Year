### Deadline
This work should be completed before the exercise on **Friday 12th October**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study sections:

* **5th ed:** 4.12 -- 4.17
* **6th ed:** 4.12 to 4.15 and 7.1 to 7.4

of _Objects First with Bluej_ be prepared to answer any of the exercises.

Also read up to and including the `Hello world` example in
[Executing without BlueJ - The Java main method](https://gits-15.sys.kth.se/inda-18/extra-reading-material/tree/master/main-method).

### Github Task:
You must complete the following exercises. Note that exercises that have
different numbering in the 6th edition have been put in parenthesis.

- 4.48 - 4.52
- 4.56 - 4.59
- 4.73 - 4.78 (7.13 - 7.18)

You must also complete exercise 4.XX on executing Java code without BlueJ.

Please commit any written answers to the [`docs`](docs) folder, and commit any
Java code developed to the [`src`](src) folder of your KTH Github repo.
Remember to push to KTH Github.

### Auction Project

#### Exercise 4.48
Add a `close` method to the Auction class. This should iterate over the
collection of lots and print out details of all the lots. Use a for-each loop.
Any lot that has had at least one bid for it is considered to be sold, so what
you are looking for is Lot objects whose `highestBid` field is not null. Use a
local variable inside the loop to store the value returned from calls to the
`getHighestBid` method, and then test that variable for the null value.

For lots with a bidder, the details should include the name of the successful
bidder and the value of the winning bid. For lots with no bidder, print a
message that indicates this.

#### Exercise 4.49
Add a `getUnsold` method to the Auction class with the following header:

```java
public ArrayList<Lot> getUnsold()
```

This method should iterate over the `lots` field, storing unsold lots in a new
ArrayList local variable. What you are looking for is Lot objects whose
`highestBid` field is null. At the end of the method, return the list of unsold
lots.

#### Exercise 4.50
Suppose that the Auction class includes a method that makes it possible to
remove a lot from the auction. Assuming that the remaining lots do not have
their `lotNumber` fields changed when a lot is removed, write down what you
think the impact would be on the getLot method.

#### Exercise 4.51
Rewrite `getLot` so that it does not rely on a lot with a particular number
being stored at index (number–1) in the collection. For instance, if lot number
2 has been removed, then lot number 3 will have been moved from index 2 to index
1, and all higher lot numbers will also have been moved by one index position.
You may assume that lots are always stored in increasing order according to
their lot numbers.

#### Exercise 4.52
Add a removeLot method to the Auction class, having the following header:

```java
/**
 * Remove the lot with the given lot number.
 * @param number The number of the lot to be removed.
 * @return The Lot with the given number, or null if
 * there is no such lot.
 */
public Lot removeLot(int number)
```

This method should not assume that a lot with a given number is stored at any
particular location within the collection.

> **Assistant's note:** That is to say, the method should _not_ assume that
> `number - 1` is the index of the `Lot`!

### Stock Manager Project

#### Exercise 4.56
Open the product project and complete the StockManager class through this and
the next few exercises. StockManager uses an ArrayList to store Product items.
Its `addProduct` method already adds a product to the collection, but the
following methods need completing: `delivery`, `findProduct`,
`printProductDetails`, and `numberInStock`.

Each product sold by the company is represented by an instance of the Product
class, which records a product’s ID, name, and how many of that product are
currently in stock. The Product class defines the `increaseQuantity` method to
record increases in the stock level of that product. The `sellOne` method
records that one item of that product has been sold, by reducing the `quantity`
field level by 1. Product has been provided for you, and you should not need to
make any alterations to it.

Start by implementing the `printProductDetails` method to ensure that you are
able to iterate over the collection of products. Just print out the details of
each Product returned, by calling its `toString` method.

#### Exercise 4.57
Implement the `findProduct` method. This should look through the collection for
a product whose `id` field matches the ID argument of this method. If a matching
product is found, it should be returned as the method’s result. If no matching
product is found, return null.

This differs from the `printProductDetails` method in that it will not
necessarily have to examine every product in the collection before a match is
found. For instance, if the first product in the collection matches the product
ID, iteration can finish and that first Product object can be returned. On the
other hand, it is possible that there might be no match in the collection. In
that case, the whole collection will be examined without finding a product to
return. In this case, the null value should be returned.

When looking for a match, you will need to call the `getID` method on a Product.

#### Exercise 4.58
Implement the `numberInStock` method. This should locate a product in the
collection with a matching ID and return the current quantity of that product as
a method result. If no product with a matching ID is found, return zero. This is
relatively simple to implement once the `findProduct` method has been completed.
For instance, `numberInStock` can call the `findProduct` method to do the
searching and then call the `getQuantity` method on the result. Take care over
products that cannot be found, though.

#### Exercise 4.59
Implement the `delivery` method using a similar approach to that used in
`numberInStock`. It should find the product with the given ID in the list of
products and then call its `increaseQuantity` method.

### Log Analyzer Project

#### Exercise 4.73 (7.13 in 6th ed)
Complete the `numberOfAccesses` method, below, to count the total number of
accesses recorded in the log file. Complete it by using a for loop to iterate
over `hourCounts`:

```java
/**
 * Return the number of accesses recorded in the log
 * file.
 */
public int numberOfAccesses() {
	int total = 0;
	// Add the value in each element of hourCounts // to total.
	...
	return total;
}
```

#### Exercise 4.74 (7.14 in 6th ed)
Add your `numberOfAccesses` method to the LogAnalyzer class and check that it
gives the correct result.

Hint: You can simplify your checking by having the analyzer read log files
containing just a few lines of data. That way you will find it easier to
determine whether or not your method gives the correct answer. The LogfileReader
class has a constructor with the following header, to read from a particular
file:

```java
/**
 * Create a LogfileReader that will supply data
 * from a particular log file.
 * @param filename The file of log data.
 */
public LogfileReader(String filename)
```

#### Exercise 4.75, (7.15)
Add a method `busiestHour` to LogAnalyzer that returns the busiest hour. You can
do this by looking through the `hourCounts` array to find the element with the
biggest count.

Hint: Do you need to check every element to see if you have found the busiest
hour? If so, use a for loop or a for-each loop. Which one is better in this
case?

#### Exercise 4.76 (7.16)
Add a method `quietestHour` to LogAnalyzer that returns the number of the least
busy hour. Note: This sounds almost identical to the previous exercise, but
there is a small trap for the unwary here. Be sure to check your method with
some data in which every hour has a non-zero count.

#### Exercise 4.77 (7.17)
Which hour is returned by your `busiestHour` method if more than one hour has
the biggest count?

#### Exercise 4.78 (7.18)
Add a method to LogAnalyzer that finds which two-hour period is the busiest.
Return the value of the first hour of this period.

### Executing without BlueJ: The Java `main` method!
Read to and including the `HelloWorld` example in
[Executing without BlueJ - The Java main method](https://gits-15.sys.kth.se/inda-18/extra-reading-material/tree/master/main-method).

#### Exercise 4.XX
Remember the `isPrime` method from last week (exercise 4.33)? Now, you will
execute it from the main method! Create a new file called `PrimeChecker.java`
containing a class called `PrimeChecker`, and copy your `isPrime` function
from last week into the new class.

Your task is now to write a main method that loops from 1 to and including 25
and checks whether the current number is prime or not. For each number, you
should print:

* `n is a prime number!`, if `isPrime(n)` returns `true`.
* `n is not a prime number :(`, if `isPrime(n)` returns `false`

### Grading Criteria
Each week we will communicate grading criteria through the [issue tracker](../../issues/). Grading criteria set the basic standards for a pass, komp or fail, so it is essential you review them each week. These will change over time as your skills develop, so make sure you read the grading criteria issue carefully and tick off all the requirements.
