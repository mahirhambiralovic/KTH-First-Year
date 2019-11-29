If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in Markdown format :)


#### Exercise S.6
Come up with (but you don't have to implement, just make a note in [`docs`](docs)) one or more further
optimizations that could be made to the algorithm. Also consider if you would
have to alter any of the unit tests before implementing the optimization(s).

> **Assistant's note:** For example, there are several optimizations possible
> on the use of the array, and how it is cached.

## Answer:
- The entire cache could be created from the start, removing the need to update it constantly.
- Testing should include a test if the cache is working properly