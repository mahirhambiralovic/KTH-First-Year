### Deadline:
This work should be completed before the exercise **Friday 22nd Feburary**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study the following course literature:

* [Java packages](https://gits-15.sys.kth.se/inda-18/extra-reading-material/blob/master/java-packages/README.md)
* [Graphs](http://www.nada.kth.se/~snilsson/algoritmer/grafer/)
* [Executing without BlueJ - The Java main method (includes part on command line arguments)](https://gits-15.sys.kth.se/inda-18/extra-reading-material/blob/master/main-method/README.md)

### Task 1 - Implement HashGraph
Review the code that has been provided in the Graph project. Start by reading
the `Graph` interface code and then move onto the `MatrixGraph` implementation
and other related classes. Once you are familiar with the code, create a second
implementation of the `Graph` interface using the `HashGraph` class provided.
This class should make use of proximity lists, which can be implemented using
hash tables. There is some skeleton code provided to get you started with
`HashGraph`, and there is a corresponding `HashGraphTest` to test your
implementation.

n.b. You should not modify the code in `Graph`, `VertextIterator` or
`VertexAction`

> **Assistant's note:** `MatrixGraph` and `HashGraph` implement the same
> interface, and should thus provide the same functionality to the outside
> (implementation is of course different). If at any time you are unsure of
> exactly what a method should do, have a look at the corresponding
> implementation in `MatrixGraph`.

### Task 2 - Components of Random Graphs
Write a program called `RandomGraphGenerator` that:

1. Generates a graph of `n` nodes, and then randomly assign `n` edges to the
   nodes
2. Calculates the number of components in the graph using DFS
3. Calculates the largest component

You may use what is given in
[`GraphAlgorithms.java`](src/se/kth/graph/GraphAlgorithms.java) to implement the
functionality. Study the `printComponents()` method carefully, what you need to
implement for points 2 and 3 is not much different from that.

`n` should be taken as a command line argument. A sample trace of output is
given below:

```bash
$ java se.kth.graph.RandomGraphGenerator 1000

For a graph with 1000 nodes and 1000 randomly assigned edges:
* Number of components: XX
* Largest component: YY
```

To handle command line arguments (e.g. n being 1000 in my trace), the following
literature may help:

* [Executing without BlueJ - The Java main method (includes part on command line arguments)](https://gits-15.sys.kth.se/inda-18/extra-reading-material/blob/master/main-method/README.md)
* [Command Line Arguments (Oracle documentation)](https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html)

IDEs usually provide command line arguments with run configurations. To find
out how to do it for your specific IDE, googling _"<IDE\_NAME> command line
arguments"_ should be sufficient to set you on the right track.

> **Assistant's requirement:** Note that the application should _not_ be
> interactive. That is to say, you should not prompt the user for the arguments
> and read them with something like the `Scanner` class, but rather take the
> arguments directly when the program starts. See the linked reading material
> above.

### Task 3 - Time Cost Analysis
Modify the program in `Task 2` to measure the running time of `MatrixGraph` and
`HashGraph` for different sizes of `n`. The program should be called with up to
2 command line arguments in the following way:

```
$ java se.kth.graph.RandomGraphGenerator <n> <graph_type>
```
Where `n` is a positive integer and `graph_type` is either `matrix` or `hash`.
It is up to you to decide if the program can be called with fewer arguments (and
then use default values) as well, but providing these two must work. A sample
trace of output is given below:

```bash
$ java se.kth.graph.RandomGraphGenerator 1000 matrix

For a proximity matrix graph with 1000 nodes and 1000 randomly assigned edges:
* Number of components: XX
* Largest component: YY
* Running time: ZZ ns
```

Complete the following table of time costs for different values of `n`, for
both implementations. If you have done the task correctly, this should simply
be a matter of running the `RandomGraphGenerator` 4 times for each
implementation and copying the output.

| Size (n)   | MatrixGraph | HashGraph |
| ---------- | ----------- | --------- |
| 100        |             |           |
| 400        |             |           |
| 1600       |             |           |
| 6400       |             |           |

You should report time in nanoseconds using `System.nanoTime()`, for example:

```bash
// setup: build graph
long t0 = System.nanoTime();
// experiment: analyse components of graph
long t1 = System.nanoTime();
long timecost = t1 - t0;
```

You may also want to repeat the tests using a loop and determine the average
`timecost` for a more accurate result.

**Based on the results you have found from empirical analysis, which
implementation was faster? Explain why this is the case using time complexity.**

### Testing
This week, you are in luck. As there is much to do in terms of production
code, the whole test suite has been given to you up front.

* `GraphTest` is an abstract test class for the `Graph` interface.
* `MatrixGraphTest` tests the `MatrixGraph` implementation.
* `HashGraphTest` tests the `HashGraph` implementation (that's the one you are
  interested in, run it as you go along!)
