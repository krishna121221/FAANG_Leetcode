/**
 * ===============================================================================
 *                           ARRAY REVERSAL CHALLENGE
 * ===============================================================================
 * 
 * PROBLEM DESCRIPTION:
 * ------------------------------------------------------------------------------
 * An array is a data structure that stores elements of the same type in a 
 * contiguous block of memory. In an array of size n, each memory location has 
 * some unique index i (where 0 <= i < n), that can be referenced as array[i].
 *
 * TASK: 
 * Your task is to reverse an array of integers.
 *
 * NOTE: 
 * If you've already solved our C++ domain's Arrays Introduction challenge, 
 * you may want to skip this.
 *
 * EXAMPLE:
 * ------------------------------------------------------------------------------
 * Input:  [1, 4, 3, 2]
 * Output: [2, 3, 4, 1]
 *
 * FUNCTION DESCRIPTION:
 * ------------------------------------------------------------------------------
 * Complete the function with the following parameter(s):
 * 
 * @param arr: the array to reverse
 * @return: the reversed array
 *
 * INPUT FORMAT:
 * ------------------------------------------------------------------------------
 * • The first line contains an integer n, the number of integers in the array.
 * • The second line contains n space-separated integers that make up the array.
 *
 * ===============================================================================
 */
import java.util.*;

public class ReverseListTest {
    
    public static List<Integer> reverseArray(List<Integer> a) {
        // Create a copy to avoid modifying the original list
        List<Integer> newarr = new ArrayList<>(a);
        Collections.reverse(newarr);
        return newarr;
    }
    
    public static void main(String[] args) {
        // Test case 1
        List<Integer> input1 = Arrays.asList(1, 4, 3, 2);
        List<Integer> result1 = reverseArray(input1);
        System.out.println("Input:  " + input1);
        System.out.println("Output: " + result1);
        
        // Test case 2
        List<Integer> input2 = Arrays.asList(5, 10, 15, 20, 25);
        List<Integer> result2 = reverseArray(input2);
        System.out.println("\nInput:  " + input2);
        System.out.println("Output: " + result2);
        
    }
}
