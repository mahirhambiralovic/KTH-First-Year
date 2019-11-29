If written answers are required, you can add them to this file. Just copy the
relevant questions from the root of the repo, preferably in
[Markdown](https://guides.github.com/features/mastering-markdown/) format :)

### Task 1 - Debugging Concurrent Programs
In this task, you will be provided with two buggy programs. For each program,
you should:


#### Buggy program 1
[src/bug01.go](src/bug01.go)

1. Explain what is wrong with the code.
Since the channel is unbuffered, the program will pause until the chanel has been emptied and the message recieved.
2. Fix the bug.
3. Explain why your solution fixes the bug.
Since the channel has a buffer, the sender will only block until it has sent a value (assuming there is space in the buffer, which there is). 


#### Buggy program 2
[src/bug02.go](src/bug02.go)
1. Explain what is wrong with the code.
First the main function starts a go routine for printing. This go routine prints all available elements in the channel until it is closed.
Next in the main channel, it fills the channel with values. Print is hence simultaneously printing these values as they are added.
However, as the last value, 11 is added, the main routine closes the channel and ends the program before the print routine has time to print.

2. Fix the bug.
3. Explain why your solution fixes the bug.
By introducing a wait channel, we can signal when the print routine is done. Hence, in the end of the main routine, main will wait for thw "wait"
channel to be closed before closing. The wait channel will be closed by print, once all elements have been printed, creating synchronization.

### Task 2 - Many Senders; Many Receivers
* What happens if you switch the order of the statements
  `wgp.Wait()` and `close(ch)` in the end of the `main` function?
        The channel is closed before the Produce routines have completed
        sending values to ch. Hence, they are trying to send values to a
        closed channel.

* What happens if you move the `close(ch)` from the `main` function
  and instead close the channel in the end of the function
  `Produce`?
    The producer who is first finished will close the channel, likely
    before the other three producers have finished sending their values.

* What happens if you remove the statement `close(ch)` completely?
    Nothing. No one is waiting for the channel to be closed.

* What happens if you increase the number of consumers from 2 to 4?
    The program completes faster (about 30-50% faster) as more routines
    can consume at the same time

* Can you be sure that all strings are printed before the program
  stops?
    Not in its current state, as no part of the program is waiting for
    consume to finish.

Finally, modify the code by adding a new WaitGroup that waits for
all consumers to finish.
    Here, the close(ch) was important so that the consumers could stop once the ch was closed.
