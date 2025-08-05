/**
 * MERGE SORTED ARRAY
 * LeetCode Problem #88
 * Difficulty: EASY
 *
 * PROBLEM DESCRIPTION:
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 
 * respectively.
 *
 * GOAL: Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * IMPORTANT: The final sorted array should NOT be returned by the function, 
 * but instead be stored inside the array nums1. To accommodate this, nums1 has 
 * a length of m + n, where:
 *    - The first m elements denote the elements that should be merged
 *    - The last n elements are set to 0 and should be ignored
 *    - nums2 has a length of n
 *
 * EXAMPLES:
 *
 * Example 1:
 * Input:  nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * 
 * Explanation: 
 *    Arrays we're merging: [1,2,3] and [2,5,6]
 *    Result: [1,2,2,3,5,6] (elements from nums1 are underlined)
 *
 * Example 2:
 * Input:  nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * 
 * Explanation: 
 *    Arrays we're merging: [1] and []
 *    Result: [1]
 *
 * Example 3:
 * Input:  nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * 
 * Explanation: 
 *    Arrays we're merging: [] and [1]
 *    Result: [1]
 *    Note: m = 0 means no elements in nums1. The 0 is just placeholder space.
 *
 * CONSTRAINTS:
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1 <= m + n <= 200
 * - -10^9 <= nums1[i], nums2[j] <= 10^9
 *
 * FOLLOW UP CHALLENGE:
 * Can you come up with an algorithm that runs in O(m + n) time complexity?
 * 
 * Hint: Think about starting from the end of both arrays and working backwards!
 *
 * SOLUTION APPROACHES:
 * 1. Naive: Merge, then sort -> O((m+n)log(m+n))
 * 2. Better: Two pointers from start with extra space -> O(m+n) time, O(m) space
 * 3. Optimal: Two pointers from end, in-place -> O(m+n) time, O(1) space
 */


import java.io.*;
import java.util.*;

public class MergeSortedArray {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j=n-1;
        int k = m+n-1;
        while (i>=0 && j>=0){
            if(nums1[i] > nums2[j]) {
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
        return nums1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}