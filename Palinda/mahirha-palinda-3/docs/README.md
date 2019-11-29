### Task 1 - Matching Behaviour

Take a look at the program [matching.go](src/matching.go). Explain what happens and why it happens if you make the following changes. Try first to reason about it, and then test your hypothesis by changing and running the program.

  * What happens if you remove the `go-command` from the `Seek` call in the `main` function?

  **Answer:** The random order of send and receive will disappear and the messages will be sent and received in the sequential order that the array has been filled with. Hence Anna sends to Bob, Cody to Dave and Eva is empty-handed. - Turns out I was right.

  * What happens if you switch the declaration `wg := new(sync.WaitGroup`) to `var wg sync.WaitGroup` and the parameter `wg *sync.WaitGroup` to `wg sync.WaitGroup`?

  **Answer:** Changing to var wg sync.Waitgroup changes the way wg behaves when passed into a function. When passing wg that is created by make it sends a reference to functions, but with var it sends a copy (value). When Seek then tries to modify it, it is not modifying anything. When running, I noticed that Seek does not even accept a wg created with make, if the parameter is not specified as a pointer. However, when removing the pointer from the parameter and declaring with var - as suggested in the questions - we reach a deadlock. This I assume is because the wg.Done() in seek is done in a copy of wg, not the original wg in main, making main wait at wg.Wait() forever.

  * What happens if you remove the buffer on the channel match?

  **Answer:** The channel will immediately block when the first Seek routine passes the first name to it. The next Seek routine making it to the select statement will happily take its value. This will repeat once again. However, once the last routine in line passes in its name to the channel, no one is there to receive it (poor routine :( ), so it will get stuck on the line where it is passing match <- name, never making it to wg.Done(), making main wait at wg.Wait() forever. Deadlock. - Seems like I was right :)

  * What happens if you remove the default-case from the case-statement in the `main` function?

  **Answer:** I don't think the program will be affected right now, the case will be fulfilled since the last name is passed into the channel before wg.Wait() and that case will always happen. However, if we were to have an even number off people, I assume we would have deadlock. This because select will be waiting for something to be received from the channel forever. - Which seems to be correct.

Hint: Think about the order of the instructions and what happens with arrays of different lengths.


### Task 2 - Fractal Images

The file [julia.go](src/julia.go) contains a program that creates images and writes them to file. The program is pretty slow. Your assignment is to divide the computations so that they run in parallel on all available CPUs. Use the ideas from the example in the [efficient parallel computation](http://yourbasic.org/golang/efficient-parallel-computation/) section of the course literature.

You can also make changes to the program, such as using different functions and other colourings.

How many CPUs does you program use? How much faster is your parallel version?

**Answer:** I have made it so that each column is rendered as a separate go routine. As my cpu has two cores, it should be using them both. As I can see that my runtime decreases by about 30-40%, hence almost cut in half, when going from GOMAXPROCS(1) to GOMAXPROCS(2) and no real improvement after that.

### Task 3 - MapReduce

|Variant       | Runtime (ms) |
| ------------ | ------------:|
| singleworker |          12.97ms |
| mapreduce    |          6.83 |
