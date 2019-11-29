### Deadline:
This work should be completed before the exercise on **Friday 1st February**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study the following course literature:

* _Objects First with Java, 5th ed:_ Chapter 10: Further Abstraction Techniques

or

* _Objects First with Java, 6th ed:_ Chapter 12 Further Abstraction Techniques

and

* [Tutorial on Regular Expressions](http://www.vogella.com/tutorials/JavaRegularExpressions/article.html), Lars Vogel

### Task 1 - Create a Stack Interface
A stack is an abstract data type (in Java "collection") that usually supports
at least the 5 methods outlined below. Note that `T` is a generic type
parameter.

* `void push(T elem)` Adds the element to the top of the stack.

* `T pop()` Removes and returns the top element in the stack, that is the element
  that was last added to the stack. **Throws an
  [EmptyStackException (you need to import this, see the docs!)](https://docs.oracle.com/javase/9/docs/api/java/util/EmptyStackException.html)
  if the stack is empty!**


* `T top()` Returns the top element in the stack without removing it. **Throws
  an [EmptyStackException (you need to import this, see the docs!)](https://docs.oracle.com/javase/9/docs/api/java/util/EmptyStackException.html)
  if the stack is empty!**

* `int size()` Returns the number of elements in the stack.

* `boolean isEmpty()` Returns true if the stack is empty.

Notice how these methods form a subset of the `LinkedList` methods that you
implemented last week? A stack is essentially just that: a linked list with
some features cut (functionally, that is, for efficiency reasons a stack is
often implemented similarly to an `ArrayList`).

The two most iconic methods, that you will later come to associate with stacks,
are `push` and `pop`. They constitute the basic _LIFO_ (Last In First Out)
behavior of the stack, which is illustrated in the image below:
![push and pop](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png)

**Your task** is to describe this abstract data type in Java by writing an
interface named Stack, using the exact 5 headers given above. Don't forget the
documentation, it's extra important in an interface, where there's no program
code.

> **Assistant's requirement:** The interface must use generics!

> **Assistant's note:** All members of an interface in Java are implicitly
> `public` (unless explicitly declared otherwise). It is therefore standard
> practice to _leave out_ the visibility, so we did not simply forget about it
> in the method headers!

### Task 2 - Create an implementation of Stack
Write a class that implements the `Stack` interface. Testing is crucial when
implementing something like this, it may be a good idea to skip ahead to the
[testing section](#testing) and implement the tests first!

As mentioned in [Task 1](#task-1---create-a-stack-interface), a stack is in
terms of functionality essentially a simplified linked list. You should copy
your `LinkedList` implementation from last week (i.e. copy the file
`LinkedList.java`), and rewrite the class declaration to implement your `Stack`
interface. Then implement the methods required by said interface. Note that
`LinkedList`, if fully completed, should have _all_ of the required
functionality already, so it is simply a matter of adding some new public
methods that call other, already implemented methods.  Having one concrete
class implement several interfaces is a common pattern in Java. It has the
upside that code duplication is much reduced, as many interfaces share a lot of
functionality. The downside is, however, that the API of that single concrete
class may become quite polluted.

> **Assistant's requirement:** All methods defined by the `Stack` interface
> must be O(1) in the worst case!

> **Assistant's note:** The methods in `LinkedList` that need to work for the
> `Stack` methods to work properly are `addFirst`, `removeFirst`, `getFirst`,
> `size` and `isEmpty`. If you have yet to make these work well, it is strongly
> recommended that you go back to the previous assignment and finish up before
> starting to implement the `Stack` interface. **You are of course allowed to
> implement the `Stack` from scratch, but the class should still be called
> `LinkedList`.**

### Task 3 - Evaluation of postfix expressions
A stack is a very useful data type that, among other things, is used to
implement method calls in programming languages. This week's assignment is not
to implement a whole language however, but it does involve similar concepts.
One of those concepts is _parsing_, which is the act of taking a sequence of
symbols and figuring out what they mean.

You will write a program that can calculate arithmetic expressions written in
postfix notation. Postfix is simple way to write arithmetic expressions that
doesn't require parentheses nor priority-rules. The valid digits are `0-9`, and
operators are `-/*+`. Here are some examples of expressions written in the
usual infix-notation and postfix respectively:

|Infix Expression                 |Postfix Expression
|---------------------------------|---------------------
|`0 + 1`                          |`0 1 +`
|`(2 + -3) * 4`                   |`2 -3 + 4 *`
|`(5 - 6) * (7 + 8)`              |`5 6 - 7 8 + *`
|`((9 + 10) * 11 - 12) / 13`      |`9 10 + 11 * 12 - 13 /`
|`14 * (15 - (16 + 17))`          |`14 15 16 17 + - *`

Postfix-expressions are easy to compute with a stack. The algorithm can be
described as follows:

1. Parse the expression symbol by symbol from left to right.
2. As soon as you see an operand, push it to the stack.
3. As soon as you see an operator, pop two operands from the stack, apply the
   operator to them, and push the result of the operation to the stack.

If that did not immediately click with you, it may be a good idea to go back
to the examples and try to calculate the postfix expressions with pen and paper
(using the algorithm of course). Below is an example of calculating `2 -3 + 4
*`. The leftmost column shows the symbol currently being parsed, the middle
column the result (according to step 2 or 3 of the algorithm), and the rightmost
column the stack (_after_ the result has been pushed).

| Symbol being parsed  | Result of operation   | Stack     |
| -------------------- | --------------------- | -------   |
| `2`                  | `2`                   | `{2}`     |
| `-3`                 | `-3`                  | `{2, -3}` |
| `+`                  | `2 + -3 = -1`         | `{-1}`    |
| `4`                  | `4`                   | `{-1, 4}` |
| `*`                  | `4 * -1 = -4`         | `{-4}`    |

When the whole expression has been processed, there should be a single element
left on the stack, which is the result.

Work from the skeleton [src/Postfix.java](src/Postfix.java) and implement the
methods. The two helper-methods `isOperator` and `isInteger` should be
implemented using regular expressions (regex). You should also use the `Stack`
that you implemented in the previous exercise!

> **Assistant's requirement:** You must use regular expressions to determine
> whether a symbol is an operator or an operand.

> **Assistant's note:** [RegexOne](https://regexone.com/lesson/introduction_abcs)
> is a fairly good interactive regex tutorial. You may also test your regex
> expressions at [regex101](https://regex101.com/) (note however that the
> specific flavor of regex used by Java is not available, but the default choice
> `php` engine should work well enough).

### Testing
#### Stack
In the testing this week, you will be using what you learned about inheritance
last week to make testing different implementations of the `Stack` interface
painless. Well, you will only be testing one implementation, but the technique
demonstrated here is well worth knowing. Read the following carefully, because
it is potentially a bit difficult to wrap your head around.

* [`StackTest.java`](src/StackTest.java) is an _abstract test class_. This is
  where all of the tests asserting the behavior of the `Stack` interface go.
  Since this test class is abstract, it cannot be instantiated (and thus, it
  cannot be run as a test class). **You should implement the test methods
  with the `fail("Not implemented")` statement!**
* For each implementation of `Stack`, one may simply extend `StackTest` with an
  implementing test class. The only method that should be overridden is
  `StackTest.getIntegerStack`, which should simply return an instance of a
  class that implements `Stack<Integer>`. See the `setUp` method in
  `StackTest` and try to understand how this works.
* In your case, you should extend `StackTest` with a test class called
  `LinkedListTest`.
* **LinkedListTest** is the class that you should run with JUnit! If it
  correctly extends `StackTest`, it will inherit its tests. This is why we have
  an abstract test class for the `Stack` interface: for every implementation of
  `Stack`, we can simply extend `StackTest` with another test class, without
  having to reimplement the same tests!

To summarize, you should implement the unimplemented tests in `StackTest`, and
extend the class with your own test class `LinkedListTest`.

> **Assistant's note:** If you copy `LinkedListTest.java` from last week (which
> is totally reasonable), you _must_ add a call to `super.setUp();` as the
> first line in `LinkedListTest.setUp`. Otherwise, `StackTest.setUp` won't run
> (as `LinkedListTest.setUp` overrides it) and you will get strange failures.

#### Postfix
You have been given the whole test class for the `Postfix` class (found at
[src/PostfixTest.java](src/PostfixTest.java)). Make sure your implementation
passes these tests.
