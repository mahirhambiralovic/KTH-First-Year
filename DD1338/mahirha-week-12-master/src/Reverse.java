import java.util.List;
import java.util.ArrayList;
/**
 * A class for reversing List and array types.
 *
 * @author PUT YOUR NAME HERE
 * @version 2017-08-09
 */
public class Reverse {

    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */
    public int[] reversed(int[] array) {
        int counter = 0;

        int[] copy = array.clone();
        int len = copy.length;
        counter += 2;

        // Runs through half array and switches i'th element with len -i -1
        for(int i = 0; i < len/2; i++){
            int temp = copy[i];
            copy[i] = copy[len -i -1];
            copy[len -i -1] = temp;
            counter += 3;
        }
        return copy;
    }

    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */
    public List<Integer> reversed(List<Integer> list) {
        int counter = 0;

        List<Integer> copy = new ArrayList<Integer>(list);
        int len = copy.size();
        counter += 2;

        // Runs through half array and switches i'th element with len -i -1
        for(int i = 0; i < len/2; i++){
            int temp = copy.get(i);
            copy.set(i, copy.get(len -i -1));
            copy.set(len -i -1, temp);
            counter += 3;
        }
        return copy;
    }
}
