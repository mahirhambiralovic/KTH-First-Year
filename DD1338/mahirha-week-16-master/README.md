### Deadline:
This work should be completed before the exercise on **Friday 8th February**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study the following course literature:

* [Hash Tables](http://www.nada.kth.se/~snilsson/algoritmer/hashtabell/)

### Task 1 - Implement a hash table
Hash tables are built into Java in the form of the classes `HashMap`,
`Hashtable` (which is almost identical to `HashMap`) and `HashSet`, together
with the methods `equals` and `hashCode` in the `Object` class. To use these
efficiently one has to understand how a hash table works.  That's what we'll
learn in this assignment.

You will implement a hash table that functions as a _set_ (so, `HashSet`), that
is to say, it can hold only unique values. The interface is described below
(and available in [`Set.java`](src/Set.java)).

```java
/**
 * An interface describing a generic set. Duplicates are not allowed.
 *
 * @author Simon Larsén
 * @version 2018-01-15
 */
public interface Set<T> {

    /**
     * Adds the given element to the set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to add to the set.
     * @return true if the set did not contain the element, otherwise false.
     */
    boolean add(T elem);

    /**
     * Removes the given element from the dictionary, if it is present.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to remove from the set.
     * @return true if the set contained the element, false otherwise.
     */
    boolean remove(T elem);

    /**
     * Check if an element is in the Set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to look for.
     * @return true if the element is in the set, false otherwise.
     */
    boolean contains(T elem);

    /**
     * Returns the number of elements in this set.
     *
     * Complexity: O(1) expected time.
     *
     * @return The amount of elements in this set.
     */
    int size();
}
```
The next section will give you some pointers on how to implement the `Set`
interface.

#### Practicalities
This assignment has some unexpected complications because arrays and generics
work pretty poorly together in Java. There are two (reasonably good) solutions
to this problem, and these are outlined in the next two subsections. Whichever
option you pick, **the following requirements are placed on your
implementation**:

* To implement your hash method, use the `hashCode` method of the stored
  object. Every object in java has the `hashCode` method, as it is defined in
  `Object`, and every class extends `Object`.
* Your implementation must handle hash collisions. That is to say it should be
  possible to store two objects that are not equal, but have the same hash.
* Your implementation **does not** have to resize dynamically (i.e. the amount
  of buckets may be constant).
* **Work from the code skeleton in [src/HashSet.java](src/HashSet.java).**

##### Option 1
Option 1 is to avoid arrays and use an `ArrayList` instead. Then
you can declare and create the hash table in the following way:

```java
ArrayList<LinkedList<T>> table = new ArrayList<>();
```

##### Option 2
If you'd rather use arrays, for efficiency-reasons, some more unexpected issues
pop up. You can't actually create an array of generic lists in a type-safe
fashion in Java. The following, seemingly natural code:

```java
new LinkedList<T>[size];
```

doesn't work. [HashSet.java](src/HashSet.java) is a skeleton that shows how you
can get around this.

### Task 2 - Time Complexities for Data Structures
Calculate the worst-case time complexity for the operations (Find, Insert and Remove) in the following:

* Unsorted Array
* Sorted Array
* Unsorted Singly Linked List
* Sorted Singly Linked List

Calculate the average and worst case time complexity for the operations (Find, Insert and Remove):

* Hash Table (You can assume that the number of elements is equal to the size of the table)

Let n be the number of elements and present the solution in a table as shown
below. As usual you should **motivate your answers**.

| Operation   | Unsorted Array   | Sorted Array   | Unsorted SLL   | Sorted SLL   | Hash table (Average) | Hash table (Worst)  |
| ----------- | ---------------- | -------------- | -------------- | ------------ | ----------------     | ------------------- |
| Find        |                  |                |                |              |                      |                     |
| Insert      |                  |                |                |              |                      |                     |
| Remove      |                  |                |                |              |                      |                     |

> **Assistant's note:** When it comes to arrays and linked lists, the average
> and worst case time complexities for these operations are the same, so it is
> not interesting to calculate both.

### Task 3 - Dynamic Tables
The `ArrayList` in Java is a convenient wrapper to make the primitive arrays
more flexible.  However, arrays are fixed in size at the point of creation,
i.e. they have a certain `capacity`. This means there is a cost involved if we
grow beyond the intial capacity by adding more elements than can be stored.
But, the API for `Arraylist` states, "*The add operation runs in amortized
constant time*".

Consider an `Arraylist` that grows from it's initial size of zero with a
sequence of calls to `add(E e)`, to a size of 20 elements.

```java
ArrayList list = new ArrayList();

// Adding elements
for(int i = 0; i<20; i++) {
    list.add(new Object());
}
```

Answer the following:

1. What is the initial capacity of an `ArrayList`'s internal array?
2. At what size does the internal array grow, and by how much?
3. Explain what really happens by the term "grow" in this context?
4. What is the capacity of the internal array once 20 elements have been added?
5. If objects were removed, would the size of the internal array change also?
6. What is the worst, average, and best-case time complexity of the `add(E e)`
   method of `Arraylist`?

To answer these questions, you should read the source code for
[ArrayList](https://zgrepcode.com/java/openjdk/9/java.base/java/util/arraylist.java)
and/or use a debugger (or perhaps BlueJ's built-in Object Inspector might help).

### Testing
Just like in week 15, this week's testing makes use of inheritance to keep the
tests neatly organized. This time around, the fact that a hash-based set bears
some special traits in terms of hash collisions, the extending test class also
includes tests of its own. Notable about this week is:

* The abstract test class [SetTest](src/SetTest.java) contains tests that assert
  the general behavior of a set. Remember that an abstract class cannot be
  instantiated, and thus, `SetTest` cannot be run with JUnit.
* A few of the tests make use of streams. You don't have to use streams if you
  don't want to, it is fine to write loops instead. The first test method in
  `SetTest` explains what the stream does, and how to write it as a loop.
* The extending test class [HashSetTest](src/HashSetTest.java) (which _can_ be
  run!) asserts some particular behavior of a hash-based set, namely when
  there are hash collisions. There is a helper class included at the very bottom
  of the test class, which has the same hash for every instance, but instances
  equal only themselves. Running `HashSetTest` will result in both the tests in
  `HashSetTest` and the superclass `SetTest` being executed.
* Take a good look at the `setUp` method of `HashSetTest`. It overrides the
  `setUp` method of `SetTest`, but also calls it, so that the setup from the
  base class is not lost (in which case, the base tests would break).
* The `is` matcher does the exact same thing as the `equalTo` matcher (when
  used with an object or primitive), and is used because the author thought
  that `is(false)` sounded better than `equalTo(false)`.

As usual, you are to implement the test methods with a `fail("Not implemented")`
statement! Note that **both `SetTest` and `HashSetTest` have unimplemented
tests!**
