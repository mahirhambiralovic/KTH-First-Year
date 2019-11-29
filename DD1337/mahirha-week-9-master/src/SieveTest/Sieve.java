import java.util.Arrays;
/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author YOUR NAME HERE
 * @version 2017-08-05
 */
public class Sieve {
    private static final int MAX = (int) Math.pow(2, 26);
    private boolean[] primeCache = new boolean[0];

    /**
     * Sanitation check for illegal arguments
     * Under 2 is not a prime
     * Over 2^26 is out of bounds
     * @param number
     */
    private void exceptionIfIllegalArg(int number){
        if(number < 2){
            System.out.println("Illegal argument. Primes cannot be less than 2.");
            throw new IllegalArgumentException();
        }
        else if(number > MAX){
            System.out.println("Illegal argument. Cannot handle numbers larger than 2^26");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check for all primes up to number
     * @param number The primes to check up until
     * @return List of boolean values of all numbers, if prime or not
     */
    private boolean[] sieve(int number){
        // Check if primeCache contains enough primes. If not, update primeCache.
        if(primeCache.length > number){
            return primeCache;
        }
        else {
            boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
            Arrays.fill(prime, true); // assume all numbers are prime
            int sqrt = (int) Math.floor(Math.sqrt(number));
            for (int i = 2; i <= sqrt; i++) {
                if (prime[i]) {
                    for (int j = i * 2; j < prime.length; j += i) {
                        prime[j] = false; // mark multiples of i as not prime
                    }
                }
            }
            primeCache = prime;
            return primeCache;
        }
    }

    /**
     * Check if a number is prime or not!
     *
     * Note that prime[n] denotes the primality of number n.
     *
     * @param   number  An integer value to be checked for primality.
     * @return  true if number is prime, false otherwise.
     */
    public boolean isPrime(int number) {
        exceptionIfIllegalArg(number);
        boolean[] prime = sieve(number);
        return prime[number];
    }
}
