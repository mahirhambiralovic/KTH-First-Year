### Deadline
This work should be completed before the exercise on **Friday 28th September**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study all of chapter 3 of _Objects First with Java_ (5th or 6th ed) and be
prepared to discuss any of the exercises.

### Github Task:
Please complete the exercises listed below:

- 3.1--3.3
- 3.9--3.12
- 3.21
- 3.26--3.27
- 3.30
- 3.31

Please commit any written answers to the [`docs`](docs) folder, and commit any
Java code developed to the [`src`](src) folder of your KTH Github repo.
Remember to push to KTH Github.

#### Exercise 3.1
Think again about the lab-classes project that we discussed in Chapter 1 and
Chapter 2. Imagine that we create a `LabClass` object and three `Student`
objects. We then enroll all three students in that lab. Try to draw a class
diagram and an object diagram for that situation. Identify and explain the
differences between them.

#### Exercise 3.2
At what time(s) can a class diagram change? How is it changed?

#### Exercise 3.3
At what time(s) can an object diagram change? How is it changed?

#### Exercise 3.9
Which of the following expressions return true?

```
! (4 < 5)
! false
(2 > 2) ││ ((4 == 4) && (1 < 0))
(2 > 2) ││ (4 == 4) && (1 < 0)
(34 != 33) && ! false
```

After writing your answers on paper, open the Code Pad in BlueJ and try it out.
Check your answers.

> **Assistant's note:** While you can easily get the correct answers for this
> exercise by simply using the code pad, trying to work out how each expression
> is evaluated beforehand is a good mental exercise!

#### Exercise 3.10
Write an expression using boolean variables `a` and `b` that evaluates to true
when `a` and `b` are either both true or both false.

#### Exercise 3.11
Write an expression using boolean variables `a` and `b` that evaluates to true
when only one of `a` and `b` is true, and that is false if `a` and `b` are both
false or both true. (This is also called an exclusive or.)

> **Assistant's requirement:** Any sane programmer would use the XOR operator
> (`^`) for this, and present the solution  `a^b`. However, this is an exercise
> in boolean logic using AND, NOT and OR, so you are not allowed to be a sane
> programmer for _this particular exercise_!

#### Exercise 3.12
Consider the expression `(a && b)`. Write an equivalent expression (one that
evaluates to true at exactly the same values for `a` and `b`) without using the
`&&` operator.

#### Exercise 3.21
Rewrite the `increment` method without the modulo operator, using an if
statement. Which solution is better?

#### Exercise 3.26
Write the signature of a constructor that matches the following object creation
instruction:

```java
new Editor("readme.txt", –1)
```

> **Assistant's note:** Refresh your knowledge of the method signature by
> having a look at the assistant's note on exercise 1.33 from week 1!

#### Exercise 3.27
Write Java statements that define a variable named `window` of type
`Rectangle`, and then create a rectangle object and assign it to that variable.
The rectangle constructor has two `int` parameters.

> **Assistant's note:** Please note that the Rectangle class has already been
> provided to you.

#### Exercise 3.30
Given a variable `Printer p1`; which currently holds a reference to a printer
object, and two methods inside the Printer class with the headers

```java
public void print(String filename, boolean doubleSided)
public int getStatus(int delay)
```

write two possible calls to each of these methods.

> **Assistant's note:** That makes _four_ method calls in total!

#### Exercise 3.31
Change the clock from a 24-hour clock to a 12-hour clock. Be careful: This is
not as easy as it might at first seem. In a 12-hour clock, the hours after
midnight and after noon are not shown as 00:30, but as 12:30. Thus, the minute
display shows values from 0 to 59, while the hour display shows values from 1
to 12!

### Grading Criteria
Each week we will communicate grading criteria through the [issue tracker](../../issues/). Grading criteria set the basic standards for a pass, komp or fail, so it is essential you review them each week. These will change over time as your skills develop, so make sure you read the grading criteria issue carefully and tick off all the requirements.
