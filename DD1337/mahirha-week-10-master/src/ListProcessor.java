
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * A list processor which can populate, shuffle and sum lists.
 * 
 * @author Mahir Hambiralovic
 * @version 2018-11-21
 */

public class ListProcessor{
    public static void main(String[] args) {
        ListProcessor lp = new ListProcessor();
        //Failtest
        lp.arraySequence(-2, 3);
        lp.listSequence(1, 10);

    }

    /**
     * Populates an array populated with values from to.
     * @param from Starting value
     * @param to Up to, not including value
     */
    public int[] arraySequence(int from, int to){
        int[] array;
        int size = to - from;
        // Sanity check
        if(size < 0){
            throw new IllegalArgumentException();
        }
        array = new int[size]; 
        for(int i = 0; i < size; i++){
            array[i] = from + i;
        }
        return array;
    }


    /**
     * Populates an List populated with values from to.
     * @param from Starting value
     * @param to Up to, not including value
     */    
    public List<Integer> listSequence(int from, int to){
        List<Integer> list = new ArrayList<Integer>();
        int size = to - from;
        // Sanity check
        if(size < 0){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < size; i++){
            list.add(from + i);
        }
        return list;
    }

    /**
     * Shuffles an Array of numbers
     * @param numbers An array of ints
     */
    public int[] shuffled(int[] numbers){
        int length = numbers.length;
        int[] copy = numbers.clone();
        // Check for empty array
        if(length != 0){
            Random rnd = new Random();
            
            for(int i = 0; i < length; i++){
                // Find positions and values
                int x1 = copy[i];
                int j = rnd.nextInt(length);
                int x2 = copy[j];

                // Swap
                copy[i] = x2;
                copy[j] = x1;
            }
        }
        return copy;
    }

    /**
     * Shuffles an ArrayList of numbers
     * @param numbers An ArrayList of ints
     */
    public List<Integer> shuffled(List<Integer> numbers){
        int length = numbers.size();
        List<Integer> copy = new ArrayList<Integer>(numbers);
        // Check for empty arraylist
        if(length != 0){
            Random rnd = new Random();
            for(int i = 0; i < length; i++){
                // Find positions and values
                int x1 = copy.get(i);
                int j = rnd.nextInt(length);
                int x2 = copy.get(j);

                // Swap
                copy.set(i, x2);
                copy.set(j, x1);
            }
        }
        return copy;
    }

    /**
     * Iteratively sums all ints in an Array
     * @param numbers An Array of ints
     */
    public int sumIterative(int[] numbers){
        int sum = 0;
        for(int i : numbers){
            sum += i;
        }
        return sum;
    }

    /**
     * Iteratively sums all ints in an ArrayList
     * @param numbers An ArrayList of ints
     */
    public int sumIterative(List<Integer> numbers){
        int sum = 0;
        for(int i : numbers){
            sum += i;
        }
        return sum;
    }

    /**
     * Recursively sums all ints in an Array
     * @param numbers An Array of ints
     */
    public int sumRecursive(int[] numbers){
        if(numbers.length > 0){return helperASumRecursive(numbers, 0);}
        else{return 0;}
    }

    private int helperASumRecursive(int[] numbers, int position){
        // Base case
        if(position == numbers.length -1){
            return numbers[position];
        }
        // Recursive case
        else{
            return numbers[position] + (helperASumRecursive(numbers, position +1));
        }
    }

    /**
     * Recursively sums all ints in an ArrayList
     * @param numbers An ArrayList of ints
     */
    public int sumRecursive(List<Integer> numbers){
        if(numbers.size() > 0){return helperLSumRecursive(numbers, 0);}
        else{return 0;}
    }

    private int helperLSumRecursive(List<Integer> numbers, int position){
        // Base case
        if(position == numbers.size() -1){
            return numbers.get(position);
        }
        // Recursive case
        else{
            return numbers.get(position) + (helperLSumRecursive(numbers, position +1));
        }
    }
}