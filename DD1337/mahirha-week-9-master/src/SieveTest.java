import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 * Test class the Sieve class.
 *
 * @author YOUR NAME HERE
 * @version 2017-08-21
 */
public class SieveTest {
    public static void main(String[] args){
        SieveTest test = new SieveTest();
        test.isPrimeFalseWhenNumberIsComposite();
        test.isPrimeTrueWhenNumberIsPrime();
        test.isPrimeTrueWhenNumberIsTwo();
        test.isPrimeWorksWhenPassedIncrementingValues();
    }
    private Sieve sieve;

    @Before
    public void setUp() {
        sieve = new Sieve();
    }
    private static final int MAX = (int) Math.pow(2, 26);

    @Test
    public void isPrimeTrueWhenNumberIsTwo() {
        assertTrue(sieve.isPrime(2));
    }

    @Test
    public void isPrimeTrueWhenNumberIsPrime() {
        boolean threeIsPrime = sieve.isPrime(3);
        boolean ninetySevenIsPrime = sieve.isPrime(97);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean fiveIsPrime = sieve.isPrime(5);

        assertTrue(threeIsPrime);
        assertTrue(ninetySevenIsPrime);
        assertTrue(sevenIsPrime);
        assertTrue(fiveIsPrime);
    }

    @Test
    public void isPrimeFalseWhenNumberIsComposite() {
        boolean fourIsPrime = sieve.isPrime(4);
        boolean nineHundredThreeIsPrime = sieve.isPrime(903);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean thirtyFiveIsPrime = sieve.isPrime(35);

        assertFalse(fourIsPrime);
        assertFalse(nineHundredThreeIsPrime);
        assertFalse(sixIsPrime);
        assertFalse(thirtyFiveIsPrime);
    }

    @Test
    public void isPrimeWorksWhenPassedIncrementingValues() {
        boolean twoIsPrime = sieve.isPrime(2);
        boolean threeIsPrime = sieve.isPrime(3);
        boolean fourIsPrime = sieve.isPrime(4);
        boolean fiveIsPrime = sieve.isPrime(5);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean eightIsPrime = sieve.isPrime(8);
        boolean nineIsPrime = sieve.isPrime(9);

        assertTrue(twoIsPrime);
        assertTrue(threeIsPrime);
        assertFalse(fourIsPrime);
        assertTrue(fiveIsPrime);
        assertFalse(sixIsPrime);
        assertTrue(sevenIsPrime);
        assertFalse(eightIsPrime);
        assertFalse(nineIsPrime);
    }

    @Test
    public void isPrimeExceptionWhenNumberIsOne() {
        try {
            sieve.isPrime(1);
            fail("Expected exception for 1");
        } catch (Exception e) {
            // Some Exception thrown, all good
        }
    }

    @Test
    public void isPrimeExceptionWhenNumberIsMinusTen(){
        try{
            sieve.isPrime(-10);
            fail("Expected exception for negative");
        }
        catch(Exception e){
            // Some Exception thrown, all good
        }
    }

    @Test
    public void isPrimeFalseWhenNumberIs2Pow26(){
        assertFalse(sieve.isPrime(MAX));
    }

    @Test
    public void isPrimeThrowsWhenNumberIs2Pow26Plus1(){
        try{
            sieve.isPrime((MAX +1));
            fail("Expected exception for number is too large");
        }
        catch(Exception e){
            // Some exception thrown, all good
        }
    }

    @Test
    public void isPrimeExceptionWhenNumberIs2Pow28(){
        try{
            sieve.isPrime((int) (int) Math.pow(2, 28));
            fail("Expected exception for number is too large");
        }
        catch(Exception e){
            // Some exception thrown, all good
        }
    }

}
