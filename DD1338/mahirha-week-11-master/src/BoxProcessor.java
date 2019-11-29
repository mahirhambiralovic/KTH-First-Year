import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class BoxProcessor{

    public static void main(String[] args) {

    }
    /**
     * Insertion orts an array of Box (mutates array)
     * @param array array to be mutated
     */
    public void sort(Box[] array){
        for(int i = 1; i <= array.length - 1; i ++){
           int j = i;
           while(j > 0 && array[j].compareTo(array[j-1]) < 0){
               Box temp = array[j];
               array[j] = array[j-1];
               array[j-1] = temp;
               j = j - 1;
            }
        }
    }

    /**
     * Insertion sorts an list of Box (mutates list)
     * @param list list to be mutated
     */
    public void sort(List<Box> list){
        for(int i = 1; i <= list.size() - 1; i ++){
           int j = i;
           while(j > 0 && list.get(j).compareTo(list.get(j-1)) < 0){
               Box temp = list.get(j);
               list.set(j, list.get(j-1));
               list.set(j-1, temp);
               j = j - 1;
            }
        }
    }

    /**
     * Sequential search for key
     * @param array array to be searched
     * @param box key
     * @return index of key (or -1 for not found)
     */
    public int sequentialSearch(Box[] array, Box box){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(box)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Sequential search for key
     * @param list array to be searched
     * @param box key
     * @return index of key (or -1 for not found)
     */
    public int sequentialSearch(List<Box> list, Box box){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(box)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches through an array for a specific box (array must be sorted)
     * @param array a sorted array of boxes
     * @param box key
     * @return index of key
     */
    public int binarySearch(Box[] array, Box box){ return helperBinarySearch(array, box, 0, array.length); }

    private int helperBinarySearch(Box[] array, Box box, int lower, int upper){
        if(lower > upper || upper == 0){
            return -1;
        }
        else {
            int mid = (lower + upper)/2;
            if(box.compareTo(array[mid]) == 0){
                return mid;
            }
            // If box is larger than mid value, check right
            else if(box.compareTo(array[mid]) > 0){
                return helperBinarySearch(array, box, mid +1, upper);
            }
            // If box is smaller than mid value, check left
            else {
                return helperBinarySearch(array, box, lower, mid -1);
            }
        }
    }

    /**
     * Searches through an list for a specific box (list must be sorted)
     * @param array a sorted array of boxes
     * @param box key
     * @return index of key
     */
    public int binarySearch(List<Box> list, Box box){
        return helperBinarySearch(list, box, 0, list.size());
    }

    private int helperBinarySearch(List<Box> list, Box box, int lower, int upper){
        if(lower > upper || upper == 0){
            return -1;
        }
        else {
            int mid = (lower + upper)/2;
            if(box.compareTo(list.get(mid)) == 0){
                return mid;
            }
            // If box is larger than mid value, check right
            else if(box.compareTo(list.get(mid)) > 0){
                return helperBinarySearch(list, box, mid +1, upper);
            }
            // If box is smaller than mid value, check left
            else {
                return helperBinarySearch(list, box, lower, mid -1);
            }
        }
    }
}