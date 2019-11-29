### Deadline:
This work should be completed before the exercise on **Friday 25th January**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study the following course literature:

* _Objects first with Java 5th ed (6th ed)_: Chapter 9 (Chapter 11) Improving
  Structure with Inheritance
  - Parenthesized chapter/exercise numbers are for the 6th edition, while those
  without are for the 5th.

### Github Task
* Complete exercises 9.11 -- 9.16 (11.11 - 11.16) ([Task 1](#task-1---inheritance))
* Complete the exercises on the linked list ([Task 2](#task-2---linked-lists)).

Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

### Task 1 - Inheritance

#### Exercise 9.11 (11.11)
Assume that you see the following lines of code:

```java
Device dev = new Printer();
dev.getName();
```

`Printer` is a subclass of `Device`. Which of these classes must have a
definition of method `getName` for this code to compile?

#### Exercise 9.12 (11.12)
In the same situation as in the previous exercise, if both classes have an
implementation of `getName`, which one will be executed?

#### Exercise 9.13 (11.13)
Assume that you write a class `Student` that does not have a declared
superclass. You do not write a `toString` method. Consider the following lines
of code:

```java
Student st = new Student();
String s = st.toString();
```

Will these lines compile? If so, what exactly will happen when you try to
execute?

#### Exercise 9.14 (11.14)
In the same situation as before (class `Student`, no `toString` method), will
the following lines compile? Why?

```java
Student st = new Student();
System.out.println(st);
```

#### Exercise 9.15 (11.15)
Assume that your class `Student` overrides `toString` so that it returns the
student's name. You now have a list of students. Will the following code
compile? If not, why not? If yes, what will it print? Explain in detail what
happens.

```java
for (Object st : myList) {
    System.out.println(st);
}
```

#### Exercise 9.16 (11.16)
Write a few lines of code that result in a situation where a variable `x` has
the static type `T` and the dynamic type `D`.

### Task 2 - Linked Lists
A list, a number of elements ordered in a linear structure, is perhaps the
simplest and most elementary data structure. Java provides several variants of
lists:

* The standard `array` (`int[]` for example) has hardware support, but is
  simple and somewhat limited. In memory, the elements must come one after
  the other in order (by index).

* `ArrayList` is implemented using an array, but has added functionality Just
  like with the `array`, the elements must be ordered in memory (by index).

* `LinkedList` which has largely the same functionality as ArrayList but
  different performance qualities. The elements do not have to come one after
  another in memory.

A singly linked list can be seen as a set of containers (which we will refer to
as _elements_ from now on) with two buckets each:
one that holds the element's value, and one that holds a reference to the
next element. A huge benefit of this is that the elements can be stored in
arbitrary locations in memory (i.e. they don't have to follow each other).

The data structure itself usually only knows where the first element (the
_head_) and the last element (the _tail_) are located, as well as how many
elements are currently in the list. It may look something like this (but
remember that elements are not necessarily ordered _in memory_, the may be
located all over the place).


```
     ----------        ----------        ----------
    |     |    |      |     |    |      |     |    |
--->|  2  |  -------->|  2  |  -------->|  1  |null|
    |     |    |      |     |    |      |     |    |
     ----------        ----------        ----------
```

The elements can be implemented as objects with two instance variables
containing the value of the node and a reference to the next element in the
list:

```java
private static class ListElement<T> {
    public T data;
    public ListElement<T> next;

    public ListElement(T data) {
        this.data = data;
        this.next = null;
    }
}
```
Note that the fields of `ListElement` are `public`, so they are meant to be
accessed directly (e.g. with `elem.data`), and not via getter/setter.

A _doubly_ linked list would also have a reference to the previous element, but
that slightly complicates some operations, so we will stick to a singly linked
list this time around.

##### You are to complete the following tasks:

1. Implement a singly linked list. A code skeleton can be found in the file
   [src/LinkedList.java](src/LinkedList.java). You are not allowed to change the
   API of the class. That is to say, you are not allowed to modify the
   signatures of the public methods in the class `LinkedList`, or add any new
   public methods.  Be sure to read through the method comments thoroughly!

2. Calculate the asymptotic worst-case-time for all public methods in your
   implementation. Express the time as a function of the number of elements `n`
   in the list. Put your answers in [`docs/README.md`](docs/README.md)

### Testing
Testing this week is important, and can be somewhat difficult. It is doubly
recommended here to _implement the tests first_. The majority of the unit tests
attempt to assert one of four invariants:

1. size equals the number of list elements,
2. if size == 0, first == null and last == null,
3. if size > 0, first != null and last != null,
4. if size == 1, first == last,

A 5th invariant, that is difficult to test without exposing too much of the
data structure, can be good to have in mind:

5. last.next == null
