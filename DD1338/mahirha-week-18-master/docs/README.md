If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


| Size (n)   | MatrixGraph | HashGraph |
| ---------- | ----------- | --------- |
| 100        |97 641 058 ns|100 045 076 ns|
| 400        |94 110 312 ns|110 453 147 ns|
| 1600       |116 887 410 ns|195 777 006 ns|
| 6400       |216 433 255 ns|709 299 932 ns|

**Based on the results you have found from empirical analysis, which
implementation was faster? Explain why this is the case using time complexity.**

As n grows larger, MatrixGraph seems to be superior in search time. The analysis is based on a DFS algorithm. The DFS
is dependent on the neighbors method, giving the VertexIterator. MatrixIterator finds Next() by checking if connections are != 0
which is instant time for access. If most elements are empty, then this takes no time. HashGraph, however, must do a hash
for each searched key, to check if it exists. This calculation is O(V<sup>2</sup>), no matter how many elements exist, as we have to
perform the calculation for all connections that exist, or don't exist.