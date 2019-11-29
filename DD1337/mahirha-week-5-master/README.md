### Deadline
This work should be completed before **Friday 5th October**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-18/course-instructions#assignments).

### Homework
Study sections 4.1 to 4.11 from the course textbook (5th or 6th ed) and be
prepared to answer any of the exercises.

### Github Task:
You must complete the following exercises from the course text. Exercise texts
are copied here for your convenience and variations in exercise numbering
between the 4th, 5th and 6th editions are noted.

**Important:** There are several versions of the `MusicOrganizer` project that
is used in this week's assignment. See the below listing of the excercises for
which version to use where. The projects have already been added to your repos
under `code/music-organizer-vx`, please work with them in those folders!

- 4.14 -- 4.16 `music-organizer-v1`
- 4.24, 4.26 & 4.27 `music-organizer-v3`
- 4.30 -- 4.33
- 4.43 -- 4.45 `music-organizer-v5`

Also note that `music-organizer-v3/v5` in this repository have been slightly
modified from the versions found in the
[BlueJ projects repository](https://gits-15.sys.kth.se/inda-18/bluej-projects/tree/master/chapter04/)

The [audio files](src/audio) have been compressed to a glorious 8kbps to save us
some space. If they hurt your ears too much, you can find better quality versions
[here](https://gits-15.sys.kth.se/inda-18/bluej-projects/tree/master/chapter04/audio).

Please commit any written answers to the [`docs`](docs) folder, and commit any
Java code developed to the [`src`](src) folder of your KTH Github repo.
Remember to push to KTH Github.

#### Exercise 4.14
Add a method called `checkIndex` to the `MusicOrganizer` class. It takes a
single integer parameter and checks whether it is a valid index for the current
state of the collection. To be valid, the parameter must lie in the range `0`
to `size()–1`.

If the parameter is not valid, then it should print an error message saying
what the valid range is. If the index is valid, then it prints nothing. Test
your method on the object bench with both valid and invalid parameters. Does
your method still work when you check an index if the collection is empty?

#### Exercise 4.15
Write an alternative version of `checkIndex` called `validIndex`. It takes an
integer parameter and returns a boolean result. It does not print anything, but
returns true if the parameter’s value is a valid index for the current state of
the collection and false otherwise. Test your method on the object bench with
both valid and invalid parameters. Test the empty case too.

#### Exercise 4.16
Rewrite both the `listFile` and `removeFile` methods in `MusicOrganizer` so
that they use your `validIndex` method to check their parameter, instead of the
current boolean expression. They should only call `get` or `remove` on the
ArrayList if validIndex returns true.

#### Exercise 4.24
The for-each loop does not use an explicit integer variable to access
successive elements of the list. Thus, if we want to include the index of each
file name in the listing, then we would have to declare our own local integer
variable (position, say) so that we can write in the body of the loop something
like:

```java
System.out.println(position + ": " + filename);
```

See if you can complete a version of `listAllFiles` to do this. Hint: You will
need a local variable declaration of position in the method, as well as a
statement to update its value by one inside the for-each loop. One of the
things this exercise illustrates is that the for-each loop is not really
intended to be used with a separate index variable.

#### Exercise 4.26
In `listMatching`, can you find a way to print a message, once the for-each
loop has finished, if no file names matched the search string? Hint: Use a
boolean local variable.

#### Exercise 4.27
Write a method in your version of the project that plays samples of all the
tracks by a particular artist, one after the other. The `listMatching` method
illustrates the basic structure you need for this method. Make sure that you
choose an artist with more than one file. Use the `playAndWait` method of the
`MusicPlayer`, rather than the `startPlaying` method; otherwise, you will end
up playing all the matching tracks at the same time. The `playAndWait` method
plays the beginning of a track (about 15 seconds) and then returns.

#### Exercise 4.30
> **Assistant's requirement:** Exercises **4.30-4.33** should be submitted in a
> class called `Loops` in a file called `Loops.java`.

Write a while loop (for example, in a method called `multiplesOfFive`) that
prints out all multiples of 5 between 10 and 95.

> **Assistant's requirement:** The method _must_ be called `multiplesOfFive`.

#### Exercise 4.31
Write a while loop to sum the values 1 to 10 and print the sum once the loop
has finished.

> **Assistant's requirement:** The method should be called `printSum`.

#### Exercise 4.32
Write a method called `sum` with a while loop that adds up all numbers between
two numbers `a` and `b`. The values for `a` and `b` can be passed to the sum
method as parameters.

> **Assistant's requirement:** The method signature should be `sum(int, int)`,
and the result should be _returned_.

#### Exercise 4.33
Write a method `isPrime(int n)` that returns true if the parameter `n` is a
prime number, and false if it is not. To implement the method, you can write a
while loop that divides `n` by all numbers between `2` and `(n–1)` and tests
whether the division yields a whole number. You can write this test by using
the modulo operator (`%`) to check whether the integer division leaves a
remainder of `0` (see the discussion of the modulo operator in Section 3.8.3).

#### Exercise 4.43
The following exercises present a challenge because they involve using some
things that we have not covered explicitly. Nevertheless, you should be able to
make a reasonable attempt at them if you have a comfortable grasp of the
material covered so far. They involve adding something that most music players
have: a “shuffle,” or “random-play,” feature.

The java.util package contains the `Random` class whose `nextInt` method will
generate a positive random integer within a limited range. Write a method in
the `MusicOrganizer` class to select a single random track from its list and
play it.

Hint: You will need to import `Random` and create a `Random` object, either
directly in the new method or in the constructor and stored in a field. You
will need to find the API documentation for the `Random` class and check its
methods to choose the correct version of nextInt. Alternatively, we cover the
`Random` class in the next chapter.

#### Exercise 4.44
Consider how you might play multiple tracks in a random order. Would you want
to make sure that all tracks are played equally or prefer favorite tracks? How
might a “play count” field in the Track class help with this task? Discuss the
various options.

#### Exercise 4.45
Write a method to play every track in the track list exactly once in random
order.

Hint: One way to do this would be to shuffle the order of the tracks in the
list or, perhaps better, a copy of the list—and then play through from start to
finish. Another way would be to make a copy of the list and then repeatedly
choose a random track from the list, play it, and remove it from the list until
the list is empty. Try to implement one of these approaches. If you try the
first, how easy is it to shuffle the list so that it is genuinely in a new
random order? Are there any library methods that could help with this?

> **Assistant's note** Remember that simply assigning a reference of a
> `List` is **not** the same as copying. The easiest way to actually copy
> a list is to use a _copy constructor_.
>
> ```java
> // assume that we a have string list called someList
> // then, this is NOT how to copy it
> List<String> thisIsNotACopy = someList;
>
> // But this will
> List<String> thisIsACopy = new ArrayList<String>(someList);
> ```

### Grading Criteria
Each week we will communicate grading criteria through the [issue tracker](../../issues/). Grading criteria set the basic standards for a pass, komp or fail, so it is essential you review them each week. These will change over time as your skills develop, so make sure you read the grading criteria issue carefully and tick off all the requirements.
