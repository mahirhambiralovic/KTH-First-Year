// Stefan Nilsson 2013-03-13

// This program implements an ELIZA-like oracle (en.wikipedia.org/wiki/ELIZA).
package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strings"
	"time"
)

const (
	star   = "Pythia"
	venue  = "Delphi"
	prompt = "> "
)

func main() {
	fmt.Printf("Welcome to %s, the oracle at %s.\n", star, venue)
	fmt.Println("Your questions will be answered in due time.")

	questions := Oracle()
	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print(prompt)
		line, _ := reader.ReadString('\n')
		line = strings.TrimSpace(line)
		if line == "" {
			continue
		}
		fmt.Printf("%s heard: %s\n", star, line)
		questions <- line // The channel doesn't block.
	}
}

// Oracle returns a channel on which you can send your questions to the oracle.
// You may send as many questions as you like on this channel, it never blocks.
// The answers arrive on stdout, but only when the oracle so decides.
// The oracle also prints sporadic prophecies to stdout even without being asked.
func Oracle() chan<- string {
	// TODO: Answer questions.
	questions := make(chan string)
	answers := make(chan string)
	predictions := make(chan string)

	// Load questions, make prophecy and send it to answers channel
	go loadQuesitons(questions, answers)

	// make some random predictions
	go randomProphecy(predictions)

	// Print questions or predictions if they are available
	go func() {
		for {
			select {
			case p := <-answers:
				fmt.Println()
				for _, c := range p {
					fmt.Printf(string(c))
					time.Sleep(30 * time.Millisecond)
				}
				fmt.Printf("\n" + prompt)

			case p := <-predictions:
				fmt.Println()
				for _, c := range p {
					fmt.Printf(string(c))
					time.Sleep(30 * time.Millisecond)
				}
				fmt.Printf("\n" + prompt)
			}
		}
	}()

	return questions
}

// This is the oracle's secret algorithm.
// It waits for a while and then sends a message on the answer channel.
// TODO: make it better.
func prophecy(question string, answer chan<- string) {
	// Keep them waiting. Pythia, the original oracle at Delphi,
	// only gave prophecies on the seventh day of each month.
	time.Sleep(time.Duration(2+rand.Intn(3)) * time.Second)

	// Find the longest word.
	longestWord := ""
	words := strings.Fields(question) // Fields extracts the words into a slice.
	for _, w := range words {
		if len(w) > len(longestWord) {
			longestWord = w
		}
	}

	// Cook up some pointless nonsense.
	nonsense := []string{
		"For that is the reason you must go to war",
		"? Is that all you think of your foes? You are in great peril.",
		"Only if you are prepared for the wost.",
		"This is the reason you must pursue this conquest.",
		"If not for sparta, then for what?",
		"How the hell should I know?",
		"Alas. You have found your answer!",
		"It is not that simple!",
	}
	answer <- longestWord + "... " + nonsense[rand.Intn(len(nonsense))]
}

func init() { // Functions called "init" are executed before the main function.
	// Use new pseudo random numbers every time.
	rand.Seed(time.Now().Unix())
}

func randomProphecy(predictions chan<- string) {
	nonsense := []string{
		"First sacrifice to the warriors who once had their home in this island",
		"He (Pythagoras) taught much else, which he claimed to have learned from Aristoclea at Delphi.",
		"The strength of bulls or lions cannot stop the foe. No, he will not leave off, I say, until he tears the city or the king limb from limb.",
		"Pray to the Winds. They will prove to be mighty allies of Greece.",
		"Sophocles is wise, Euripides is wiser, but of all men Socrates is wisest",
		"Also the dragon (serpent), earthborn, in craftiness coming behind thee.",
		"Sure though thy feet, proud Sparta, have a care",
		"With silver spears you may conquer the world",
	}
	for {
		time.Sleep(time.Duration(10+rand.Intn(10)) * time.Second)
		predictions <- nonsense[rand.Intn(len(nonsense))]
	}
}

func loadQuesitons(quesitons <-chan string, answers chan<- string) {
	for {
		// When question is available, prophecise it and send answer to answers chan
		go prophecy(<-quesitons, answers)
	}
}
