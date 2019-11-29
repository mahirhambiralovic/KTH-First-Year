/**
 * Finds primes. 
 * Currently set to numbers 1-25.
 */
public class PrimeChecker{
    public static void main(String[] args){
        PrimeChecker check = new PrimeChecker();

        // Make sure 1 is covered first ;)
        System.out.println("1 is not a prime number :(");
        // Loop over 2-25 and print if prime
        for(int i = 2; i <= 25; i++){
            if(check.isPrime(i)){
                System.out.println(i + " is a prime number!");
            }
            else{
                System.out.println(i + " is not a prime number :(");
            }
        }
    }


    public boolean isPrime(int n) {
        int i = 2;
        while(n > i) {
            if(n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
