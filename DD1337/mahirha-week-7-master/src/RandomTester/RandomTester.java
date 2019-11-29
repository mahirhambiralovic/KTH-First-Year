import java.util.Random;
/**
 * Write a description of class RandomTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomTester
{
    private Random randomizer;

    /**
     * Constructor for objects of class RandomTester
     */
    public RandomTester()
    {
        randomizer = new Random();
    }

    /**
     * Pritns random int
     */
    public void printOneRandom(){
        System.out.println(randomizer.nextInt());
    }
    
    /**
     * Prints many random ints
     */
    public void printMultiRandom(int howMany){
        while(howMany > 0){
            System.out.println(randomizer.nextInt());
            howMany--;
        }
    }

    /**
     * Generates random number 1-6
     */
    public int throwDice(){
        return randomizer.nextInt(5) +1;
    }

    /**
     * Generates random number between parameter min and max values
     */
    public int randomInRange(int min, int max){
        return randomizer.nextInt(max - min) + min;
    }

}
