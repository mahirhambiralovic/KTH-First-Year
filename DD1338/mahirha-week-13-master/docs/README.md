If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


#### Exercise 8.12 (10.12)
Assume that we have four classes: `Person`, `Teacher`, `Student`, and
`PhDStudent`. `Teacher` and `Student` are both subclasses of `Person`.
`PhDStudent` is a subclass of `Student`.

a. Which of the following assignments are legal, and why or why not?

```java
Person p1 = new Student(); VALID
Person p2 = new PhDStudent(); VALID
PhDStudent phd1 = new Student(); INVALID
Teacher t1 = new Person(); INVALID
Student s1 = new PhDStudent(); VALID
```

b. Suppose that we have the following legal declarations and assignments:

```java
Person p1 = new Person();
Person p2 = new Person();
PhDStudent phd1 = new PhDStudent();
Teacher t1 = new Teacher();
Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal,
and why or why not?

```java
s1 = p1; INVALID
s1 = p2; INVALID
p1 = s1; VALID
```

#### Exercise 8.14 (10.14)
What has to change in the `NewsFeed` class when another `Post` subclass (for
example, a class `EventPost`) is added? Why?

#### ANSWER: Nothing, because EventPost is a subtype of Post, it polymorph and acts as a Post.


#### Exercise 8.15 (10.15)
Exercise 8.15 Use the documentation of the Java standard class libraries to
find out about the inheritance hierarchy of the collection classes. Draw a
diagram showing the hierarchy.

#### DONE (in img, image taken from https://dzone.com/articles/an-introduction-to-the-java-collections-framework)

#### Exercise 8.16 (10.16)
Go back to the lab-classes project from Chapter 1. Add instructors to the
project (every lab class can have many students and a single instructor). Use
inheritance to avoid code duplication between students and instructors (both
have a name, contact details, etc.).

#### DONE (in src)

---

#### Exercise I.2
Below are two algorithms that calculate x<sup>n</sup>, where x is a real number
and n is a non-negative integer. You are to:

**a.** Argue the correctness of the algorithms using a loop invariant or proof
by induction.

#### ANSWER: 
**expIterative:** <br> 
```java
double expIterative(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        //Invariant: res = 1 * x * x ... (i times, terminates at i = n)
        res *= x;
    }
    return res;
}
```

**expRecursive:**  

```java
double expRecursive(double x, int n) {
    if (n <= 4) {
        return expIterativ(x, n);
    }

    return expRecursive(x, n/2) *
           expRecursive(x, (n + 1)/2);
}
```

We call expRecursive(x,k) R(x,k) for simplicity  
**Base Case:** n = 5:  
R(x, 5) = R(x, 2) * R(x, 3) = x<sup>5</sup> According to base case in recursion    
**Inductive assuption:** R(x, n) = x<sup>n</sup>  (Assume true for a k < n)  
**Proove that:** R(x, k) = x<sup>k</sup> **for any k**
  
 R(x, k) = R(x, k/2) * R(x, (k + 1)/2) =  
{using assumption}  
R(x, k) = x<sup>k/2</sup> * x<sup>(k+1)/2</sup>

1. IF k IS ODD  
k/2 = (k - 1) / 2  
R(x, k) = x<sup>k/2</sup> * x<sup>(k+1)/2</sup> = x<sup>(k-1)/2</sup> * x<sup>(k+1)/2</sup> = x<sup>(k+1)/2</sup> = x<sup>2k/2</sup> = x<sup>k</sup>

2. IF k IS EVEN  
(k + 1)/2 = k/2  
R(x, k) = x<sup>k/2</sup> * x<sup>(k+1)/2</sup> = x<sup>k/2</sup> * x<sup>k/2</sup> = x<sup>2k/2</sup> = x<sup>k</sup>


---

**b.** Calculate the time-complexity as a function of n for both algorithms.
Give the result using Big-O notation.

#### ANSWER:
**expIterative:**  
Iterates over n times. O(n)

**expRecursive:**  
*Master Theorem:* 2T(n/2) + n<sup>0</sup>  
Because a > b<sup>c</sup>, (2 > 2^0) the time complexity is O(n<sup>log<sub>b</sub>a)</sup> = (n<sup>log<sub>2</sub>2)</sup> = n


