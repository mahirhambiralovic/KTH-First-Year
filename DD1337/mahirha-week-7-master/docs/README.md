If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


### RandomTester

#### Exercise 5.14 (6.14)
Write some code (in BlueJ) to test the generation of random numbers. To do
this, create a new class called RandomTester. In class RandomTester, implement
two methods: `printOneRandom` (which prints out one random number) and
`printMultiRandom(int howMany)` (which has a parameter to specify how many
numbers you want, and then prints out the appropriate number of random
numbers).

--- DONE



#### Exercise 5.16 (6.16)
Write a method in your RandomTester class called `throwDice` that returns a
random number between 1 and 6 (inclusive).

--- DONE



#### Exercise 5.18 (6.18)
Extend your `getResponse` method so that it uses an ArrayList to store an
arbitrary number of responses and randomly returns one of them.

> **Assistant's note:** Your task is to write a method called `getResponse`
> that randomly returns a string from an `ArrayList` of strings. This is really
> all you need to know, but you can look at 5/6.17 for context.

--- DONE



#### Exercise 5.20 (6.20)
Add a method `randInRangeMinMax` to your RandomTester class that takes two
parameters, min and max, and generates a random number in the range min to max
(inclusive). Rewrite the body of the method you wrote for the previous exercise
so that it now calls this new method to generate its result. Note that it
should not be necessary to use a loop in this method.

--- DONE



### Autoboxing and wrapper classes

#### Exercies 5.XX
**a:** Rewrite the following statement to utilize autoboxing:

```java
Integer wrapped = new Integer(2);
```

### ANSWER
```java
int n = 2;
ArrayList <Interger> list = new ArrayList<>();
list.add(n)
```



**b:** Write a statement that unboxes the `wrapped` variable into a primitive
`int` variable called `unwrapped`.

### ANSWER
```java
ArrayList <Interger> list = new ArrayList<>();
list.add(2);
int unwrapped = list.get(0);
```



### Scribble Demo

#### Exercise 5.57 (6.62)
In class DrawDemo, create a new method named `drawTriangle`. This method should
create a pen (as in the drawSquare method) and then draw a green triangle.

--- DONE


#### Exercise 5.58 (6.63)
Write a method `drawPentagon` that draws a pentagon.

--- DONE



#### Exercise 5.59 (6.64)
Write a method `drawPolygon(int n)` that draws a regular polygon with n sides
(thus, n=3 draws a triangle, n=4 draws a square, etc.).

--- DONE



#### Exercise 5.60 (6.65)
Write a method called `spiral` that draws a spiral (see Figure 5.6).

--- DONE



### Bouncing Balls

#### Exercise 5.62 (6.68)
Change the method `bounce` in class BallDemo to let the user choose how many
balls should be bouncing.

--- DONE



#### Exercise 5.64 (6.70)
Change the `bounce` method to place the balls randomly anywhere in the top half
of the screen.

--- DONE



#### Exercise 5.65 (6.71)
Write a new method named `boxBounce`. This method draws a rectangle (the “box”)
on screen and one or more balls inside the box. For the balls, do not use
BouncingBall, but create a new class BoxBall that moves around inside the box,
bouncing off the walls of the box so that the ball always stays inside. The
initial position and speed of the ball should be random. The boxBounce method
should have a parameter that specifies how many balls are in the box.

--- DONE



#### Exercise 5.66 (6.72)
Give the balls in boxBounce random colors.

--- DONE



### Star Wars

#### Exercise 5.71 (6.87)
There is a rumor circulating on the Internet that George Lucas (the creator of
the Star Wars movies) uses a formula to create the names for the characters in
his stories (Jar Jar Binks, ObiWan Kenobi, etc.). The formula—allegedly—is
this:

```
Your Star Wars first name:
1 Take the first three letters of your last name.
2 Add to that the first two letters of your first name.

Your Star Wars last name:
1 Take the first two letters of your mother’s maiden name.
2 Add to this the first three letters of the name of the town or city where you were born.
```

And now your task: Create a new BlueJ project named star-wars. In it create a
class named NameGenerator. This class should have a method named
generateStarWarsName that generates a Star Wars name, following the method
described above. You will need to find out about a method of the String class
that generates a substring.

--- DONE