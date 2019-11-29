import java.util.Random;
import java.util.ArrayList;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class Responder
{
    private Random randomizer;
    private ArrayList<String> responseList;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return "That sounds interesting. Tell me more...";
    }

    /**
     * Generate a random "yes" or "no" response and return it.
     */
    public String getResponse(){
        randomizer = new Random();
        responseList = new ArrayList<String>("That sounds interesting. Tell me more...", "Have you tried rebooting?",
                                        "Have you tried praying to Jesus?", "I'm going to forward you to my collegue Satan? \n Hi, this is Lucifer", 
                                        "Well why don't you try writing your own program? Not so easy? Thought so. Now stop whining.");

        // Generate random number in arrayList responseList
        return responseList.get(randomizer.nextInt(4));
        }
}
