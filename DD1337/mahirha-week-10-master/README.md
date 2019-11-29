Welcome to the first assignment of DD1338!

### Read the course instructions
Before you start working on this assignment, make sure to read the
[DD1338 specific course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions/tree/master/DD1338/README.md)
thorougly.

It may also be a good idea to refresh your memory on the
[general course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions).

### Deadline
This work should be completed before the exercise on **Friday 23rd November**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study all the following pages from the [course text](http://www.nada.kth.se/~snilsson/algoritmer/) (online):

[Hur snabb är datorn?](http://www.nada.kth.se/~snilsson/algoritmer/tid)

[Algoritmer](http://www.nada.kth.se/~snilsson/algoritmer/algoritmer)

### Github Task: List Processor
In this assignment, you will perform basic list processing tasks using both the
primitive array and lists from the Collections hierarchy.  It is important that
you can implement algorithms in either form.  Collectively, we shall refer to
both `int[]` number and `List<Integer>` as "lists of numbers" in this
assignment.

Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

> **Assistant's note:** This week, you've been given the _whole_ reference test
> class. Take advantage of this and run it as you are implementing your
> methods! You can find it in
> `[src/ListProcessorTest.java](src/ListProcessorTest.java)`

#### Setup
- Create a Java class called `ListProcessor`
- `ListProcessor` should contain all of the following methods specified in the
  below exercises.
- You must use the method signatures provided (as usual)
- Methods should be appropriately documented with Javadoc
- You may also include a main method if desired

#### Exercise 1: Populating Lists
Implement methods with the following headers:

```java
public int[] arraySequence(int from, int to)
```

and

```java
public List<Integer> listSequence(int from, int to)`
```

These methods should return populated lists with integer values in the range
from the lower bound `from` (inclusive) until the upper bound `to` (exclusive).

e.g. `arraySequence(0, 5);` should return the following array `[0,1,2,3,4]`

**Special cases:**
1. If `from == to`, an empty list should be returned.

2. If `to < from`, an `IllegalArgumentException` should be thrown.

#### Exercise 2: Shuffling Lists
Implement methods with the following headers:

```java
public int[] shuffled(int[] numbers)
```

and

```java
public List<Integer> shuffled(List<Integer> numbers)
```

These methods should return a shuffled list of numbers, by randomly swapping
elements to randomise the ordering.

> **Assistant's requirement:** You are not allowed to use
> `Collections.shuffle()`, and the argument list should _not_ be mutated.
> That is to say, you must make a local copy of the argument.

> **Assistant's note:** These two methods, as well as the pairs in exercise 3
> and 4 are _overloaded_. In short, the compiler can distinguish between two
> methods with the same name based on the _type(s)_ of the parameter(s) it is passed.
> Overloading should be used sparingly as it can affect readability, but in
> this case, it is reasonable to say that the programmer should know whether
> he/she is shuffling a list or an array, so naming the methods `shuffleArray`
> and `shuffleList` instead adds no extra information. Note that you cannot
> overload by _return type_, as overloading works only by looking at different
> signatures. For the official definition (with examples), please see
> [Overloading Methods section at the bottom of this page](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html#overloading-methods).

#### Exercise 3: Summing Lists Iteratively
Implement methods with the following headers:

```java
public int sumIterative(int[] numbers)
```

and

```java
public int sumIterative(List<Integer> numbers)
```

These methods should return the sum of a list of numbers using iteration.

**Special cases:**
1. The sum of an empty list should be 0.

> **Assistant's requirement:** Again, the argument should _not_ be mutated.

#### Exercise 4: Summing Lists Recursively
Implement methods with the following headers:

```java
public int sumRecursive(int[] numbers)
```

and

```java
public int sumRecursive(List<Integer> numbers)
```

These methods should do exactly the same thing as the ones in Exercise 3, but using
recursion instead of iteration. There are several strategies that you may use
here. You may also create private helper methods if required. Finally, there
are some useful methods in `java.util.Arrays` and `java.util.ArrayList` that may
help depending on your strategy.

> **Assistant's requirement:** Again, the argument should _not_ be mutated.

### Testing
For this week's tests, you have been provided with a fully implemented test
class at [`ListProcessorTest.java`](src/ListProcessorTest.java). This
is the actual reference test class that the assistants use to verify your code,
meaning that if your code passes the tests, it's considered good enough in
terms of functionality! For more information on how the unit tests are structured,
refer to the [DD1338 specific course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions/tree/master/DD1338/README.md).

### Grading Criteria
Each week we will communicate grading criteria through the [issue tracker](../../issues/). Grading criteria set the basic standards for a pass, komp or fail, so it is essential you review them each week. These will change over time as your skills develop, so make sure you read the grading criteria issue carefully and tick off all the requirements.
