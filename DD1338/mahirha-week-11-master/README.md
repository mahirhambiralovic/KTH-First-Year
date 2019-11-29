### Deadline
This work should be completed before the exercise on **Friday 30th November**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study all the following pages from the
[course text](http://www.nada.kth.se/~snilsson/algoritmer/) (online):

- [Hur snabb är datorn?](http://www.nada.kth.se/~snilsson/algoritmer/tid)
- [Algoritmer](http://www.nada.kth.se/~snilsson/algoritmer/algoritmer)

### Github Task: Search & Sort
In this assignment, you will investigate how to compare objects, implement a
typical sorting algorithm, and implement a binary search algorithm.  As usual,
we will practice using both arrays and collections in Java, and you should
reflect on the benefits and costs of each approach.  It may assist you to
create helper methods that create lists of `Box` objects when testing, e.g.
`Box[] generateArrayOfBoxes(int n)` and `List<Box> generateListOfBoxes(int n)`.

Please commit any Java code developed to the [`src`](src) folder and any
written answers to the [`docs`](docs) folder.

#### Requirements
- You must use the same method names as specified below. The test classes will
  not compile otherwise.
- Methods should be appropriately documented and tested (see the testing section)
- You may also include a main method if desired

It is recommended that you have a look at the [Testing](#testing) section
before starting to implement the methods!

#### Exercise 1: Comparable Box
A `Box` class has been provided for you in [`src/Box.java`](src/Box.java). Make
yourself familiar with the source code, then expand upon this class so that it
implements the
[`Comparable<Box>`](http://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)
interface. You must override the `compareTo` method so that instances of `Box`
can be compared by their `volume`. Information on Object Ordering and
Comparable can be found
[here](https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html).

You have been provided with a test class for `Box` at [`src/BoxTest.java`] that
asserts that `Comparable` is correctly implemented. Make sure that it passes
before moving on to other tasks.

> **Assistant's note:** The motivation for using the `Comparable<Box>`
> interface here is simple but perhaps not obvious. The benefit of using it is
> that we can implement generic comparison based algorithms (such as serach and
> sort) that don't actually know what they are comparing by. For the sake of
> keeping complexity down, you will only be implementing algorithms
> specifically for the `Box` class here, but with a small change to the method
> signatures, one could make the algorithms work for _any_ class `T` that
> implements `Comparable<T>` (ask your assistant if you are curious). An
> implication, and huge benefit, of the search/sort not having anything to do
> with the comparison is that if we decide that we want to compare by for
> example height alone, we only need to change `compareTo`!

#### Exercise 2: Sorting
Create a Java class called `BoxProcessor`. This class will contain your methods
for sorting / searching collections of `Box` objects.

* Choose either the Selection sort or Insertion sort algorithm, as shown below
* In `BoxProcessor` class, implement two versions of the algorithm, using
  arrays and collections, e.g. No matter which algorithm you choose, the headers
  should be the following:
    * `public void sort(Box[] array)`
    * `public void sort(List<Box> list)`
* Expected behaviour: list of Box objects will be sorted by increasing volume
* You _must_ use `Box.compareTo(Box)` for _all_ comparison operations.

> **Assistant's note:** Notice how the return type is `void`? This gives away
> the fact that these methods sort _in place_. That is to say, they are
> supposed to _mutate_ the argument array/list, instead of returning a copy.

```python
Insertion Sort (A)
------------------
1   for i = 1 to A.length - 1
2       j = i
3       while j > 0 and A[j-1] > A[j]
4           temp = A[j]
5           A[j] = A[j-1]
6           A[j-1] = temp
7           j = j - 1
```
To help you understand how it works, here is a (horribly slow, blame
[Wikipedia](https://en.wikipedia.org/wiki/Insertion_sort)) visualization of
insertion sort:

![Insertion sort gif](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

```python
Selection Sort (A)
------------------
1   for i = 0 to A.length - 1
2       min = i
3       for j = i + 1 to A.length - 1
4           if A[j] < A[min]
5               # minimum element found
6               min = j
7       temp = A[i]
8       A[i] = A[min]
9       A[min] = temp
```
To help you understand how it works, here is a (pretty neat, thank
[Wikipedia](https://en.wikipedia.org/wiki/Selection_sort)) visualization of
selection sort:

![Selection sort gif](https://upload.wikimedia.org/wikipedia/commons/9/94/Selection-Sort-Animation.gif)

#### Exercise 3: Sequential Search
Now you will create an iterative sequential search algorithm that **searches
for a Box that is comparably equal to a specified Box**. This will be a 'brute
force' approach that simply iterates through all elements.

* In `BoxProcessor` class, implement two versions, using both collections and
  arrays, with the following headers:
    * `public int sequentialSearch(Box[] array, Box box)`
    * `public int sequentialSearch(List<Box> list, Box box)`
* Expected behaviour: return index of the first `Box` that has the same volume
  as `box`, or -1 if no such `Box` is present.
* You _must_ use `Box.compareTo(Box)` for _all_ comparison operations.

#### Exercise 4: Binary Search
If you assume that the input array/list is sorted, you can use the binary
search algorithm to improve search performance. Create a recursive (or
iterative) version of the binary search algorithm that **searches for a
Box that is comparably equal to a specified Box**.

* In your `BoxProcessor` class, implement two versions, using both collections
  and arrays, with the following headers:
    * `public int binarySearch(Box[] array, Box box)`
    * `public int binarySearch(List<Box> list, Box box)`
* When testing, be sure to always use sorted lists/arrays as input.
* Expected behaviour: return index of _any_ `Box` that has the same volume
  as `box`, or -1 if no such `Box` is present.
* You _must_ use `Box.compareTo(Box)` for _all_ comparison operations.

### Testing
For this week's testing, you've been provided with two test classes.
[`BoxTest.java`](src/BoxTest.java), which you do not have to do any more work on,
is just there to make sure that you correctly implement `Comparable<Box>`.
Make sure to run it before you make your final push.

The second test class, and the one you should work on, is
[`BoxProcessorTest.java`](src/BoxProcessorTest.java). You have been given most
test implementations but not all. You should implement all of the test methods
that consist of this single fail statement:

```java
fail("Not implemented");
```

> **Assistant's note:** It is in your own best interests to take the testing
> seriously, as if you properly implement the test class and then pass all of
> the tests, you can be confident that you will not get komplettering on the
> functionality of your code (style issues may still be cause for
> komplettering).

### Grading Criteria
Each week we will communicate grading criteria through the [issue tracker](../../issues/). Grading criteria set the basic standards for a pass, komp or fail, so it is essential you review them each week. These will change over time as your skills develop, so make sure you read the grading criteria issue carefully and tick off all the requirements.
