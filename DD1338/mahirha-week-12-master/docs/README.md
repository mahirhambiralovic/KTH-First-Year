If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

#### Exercise 1


| Size / complexity | log n | n       | n log n | n^2  | n^3  | 2^n     | n!       |
|-------------------|-------|---------|---------|------|------|---------|----------|
| 1                 | 0     | 1       | 0       | 1    | 1    | 2       | 1        |
| 10                | 3.32  | 10      | 33,2    | 100  | 1000 | 1024    | 3,62e7   |
| 100               | 6,64  | 100     | 664     | 1e4  | 1e6  | 1,27e30 | 9,33e157 |
| 1000              | 9,97  | 1000    | 9,96e4  | 1e6  | 1e9  | inf     | inf      |
| 10000             | 13,3  | 10000   | 1,33e6  | 1e8  | 1e12 | inf     | inf      |
| 100000            | 16,6  | 100000  | 1,66e7  | 1e10 | 1e15 | inf     | inf      |
| 1000000           | 20,0  | 1000000 | 1,99e8  | 1e12 | 1e18 | inf     | inf      |


#### Exercise 2

| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         |          |          | &#x221e; |          |          |
| n             |          |          | 3.6e12   |          |          |
| n log n       |          |          | 9.8e10   |          |          |
| n<sup>2</sup> |          |          | 1.8e6    |          |          |
| n<sup>3</sup> |          |          | 15326    |          |          |
| 2<sup>n</sup> |          |          | 41       |          |          |
| n!            |          |          | 15       |          |          |

NOT DONE. DID EXTRA ASSIGNMENT INSTEAD.

#### Exercise 3

a) f5 > f2 > f1 > f3 > f4

b) 
n (n + 1) / 2 = O(n<sup>3</sup>) == true,
n (n + 1) / 2 = O(n<sup>2</sup>) == true,
n (n + 1) / 2 = Ω(n) == true

#### Exercise 4

Loop1(n) : O(n),
Loop2(n) : O(n),
Loop3(n) : O(n<sup>2</sup>), 
Loop4(n) : O(n<sup>2</sup>),
Loop5(n) : O(n<sup>3</sup>),


### Exercise 5
Answer:
(n+1)<sup>3</sup> = n<sup>3</sup> + 3n<sup>2</sup> + 3n + 1 = O(n<sup>3</sup>) because there exists a constant c such that
n<sup>3</sup> + 3n<sup>2</sup> + 3n + 1 &le; c * g(n). C could in this case be 9, as 9n<sup>3</sup> satisfies the inequality for all n &ge; 1.

#### Exercise 7
DID EXTRA ASSIGNMENT