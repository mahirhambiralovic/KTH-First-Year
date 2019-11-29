If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


#### Exercise 4.44
Consider how you might play multiple tracks in a random order. Would you want
to make sure that all tracks are played equally or prefer favorite tracks? How
might a “play count” field in the Track class help with this task? Discuss the
various options.


#### Answer:
By storing the number of times each track has been play, we could create an algorithm that makes sure that all tracks are played somewhat equally, or that our favorites are played more often (e.g. by some distribution or law such as 2x the least played)

E.g. for *equal distribution* we can select a random index to play, however excluding those tracks that have been played 20% more than the least played (min).

