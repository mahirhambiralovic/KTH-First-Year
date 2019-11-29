/**
 * Finds primes. 
 * Currently set to numbers 1-25.
 */
public class PrimeChecker{
    public static void main(String[] args){
        PrimeChecker check = new PrimeChecker();
        for(int i = 1; i <= 25; i++){
            if(check.isPrime(i)){
                System.out.print(i);
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
