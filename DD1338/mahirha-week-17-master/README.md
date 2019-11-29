### Deadline:
This work should be completed before the exercise **Friday 15th Feburary**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study the following course literature:

* [Träd](http://www.nada.kth.se/~snilsson/algoritmer/trad/)
    - **Note:** This text refers to the _depth of a tree_. This is more commonly
      referred to as the _height_ of the tree, and we will use the latter
      terminology in this assignment.

### Task 1 - Implement a BST
Implement a Binary Search Tree (BST) in Java. As usual, all public methods
should be well-documented.

The keys are Objects that implement the interface `java.lang.Comparable`
(recall the `Box` class froom week-11?). A generic class with a type-parameter
that matches classes that implement `Comparable` can be written as follows:

```java
class Tree<T extends Comparable<T>>
```

Each node in the tree should be represented by an object that contains two
references, one to the left and one to the right sub-tree. Methods with the
following headers must be implemented. Pay careful attention to the instructions
here!

* `public boolean search(T elem)` -- test for presence of a value.
    - Should be implemented iteratively!
* `public boolean insert(T elem)` -- add value to tree; duplicates are not allowed.
  Return true if the element is not already present (and is thus inserted),
  false otherwise.
    - Should be implemented iteratively!
* `public int size()` -- the number of elements in the tree.
    - Should be implemented to run in `O(1)` time.
* `public int height()` -- the height of the tree. The empty tree and the tree
  with only the root node both have height 0.
    - Should be implemented recursively!
    - The height of the empty tree is
      [often undefined](https://web.archive.org/web/20181013022358/https://xlinux.nist.gov/dads/HTML/height.html),
      but we decide that it is 0 (because we need it to be something). Another
      common choice is -1, to differentiate between the empty tree and the
      root-only tree.
* `public int leaves()` -- the number of leaves in the tree.
    - Should be implemented recursively!
* `public String toString()` -- a string describing the tree.
    - Should be implemented recursively!
    - The string should represent the tree in ascending order, like a sorted
      list. E.g, a tree with elements `1`, `54` and `-3` should be represented
      as `[-3, 1, 54]`.
    - Choose the most appropriate traversal technique out of in-, pre- and
      post-order.

You are of course free to add any number of helper methods that you deem
appropriate, but the public API of the class may not be changed.

> **Assistant's requirement:** You should use `Comparable.compareTo` to navigate
> the tree! You can assume that `compareTo` is consistent with `equals`. That
> is to say, `x.compareTo(y) == 0 <==> x.equals(y)`.

### Task 2 - Time Complexity
Calculate the worst-case time complexity for all operations of the BST and
complete the table below.  As usual, motivate your answers.

| Operation (BST)     | Time Complexity (worst case)    |
| ------------------- | ------------------------------- |
| search              |                                 |
| insert              |                                 |
| size                |                                 |
| height              |                                 |
| leaves              |                                 |
| toString            |                                 |

### Testing
The testing this week is simpler than in the previous weeks. There is only the
one test class, at [src/TreeTest.java](src/TreeTest.java), and you are to
implement the methods with the `fail("Not implemented!")` statements.
