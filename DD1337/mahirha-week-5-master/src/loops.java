public class Loops
{
    // print multiples of five between 10 and 95
    public void multiplesOfFive() {
        int x = 10;
        while(x <= 95) {
            System.out.println(x);
            x += 5;
        }

    }

    // print sum of numbers 1 through 10
    public void printSum() {
        int sum = 0;
        int i = 1;
        while(i <= 10) {
            sum += i;
            i++;
            System.out.println(sum);
        }
    }

    // print sum of numbers between parameters a and b
    public void sum(int a, int b) {
        int sumdiff = 0;

        // if b < a, swap the numbers around
        if(b < a) {
            int temp = a;
            a = b;
            b = temp;
        }

        // add the difference, subtracting one step at a time until numbers are the same
        while (a > b){
            sumdiff += a - b;
            a--;
        }
        System.out.println(sumdiff);
    }

    public boolean isPrime(int n) {
        int i = 2;
        // Check for 1
        if (n > 1){
            // Loop up to sqrt of n
            while(intValue(sqrt(n)) > i) {
                if(n % i == 0) {
                    return false;
                }
                i++;
            }
            return true;
        }
        else{
            return false;
        }
    }
}