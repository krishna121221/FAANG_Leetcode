
import java.util.*;

/**
 * ===============================================================================
 *                              TWO SUM PROBLEM - LEETCODE #1
 * ===============================================================================
 * 
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 * 
 * Key Requirements:
 * • Each input has exactly one solution
 * • Cannot use the same element twice
 * • Return answer in any order
 * 
 * Examples:
 * ┌─────────────────────────────────────────────────────────────────────────────┐
 * │ Example 1:                                                                  │
 * │ Input:  nums = [2, 7, 11, 15], target = 9                                  │
 * │ Output: [0, 1]                                                              │
 * │ Reason: nums[0] + nums[1] = 2 + 7 = 9                                      │
 * │                                                                             │
 * │ Example 2:                                                                  │
 * │ Input:  nums = [3, 2, 4], target = 6                                       │
 * │ Output: [1, 2]                                                              │
 * │ Reason: nums[1] + nums[2] = 2 + 4 = 6                                      │
 * │                                                                             │
 * │ Example 3:                                                                  │
 * │ Input:  nums = [3, 3], target = 6                                          │
 * │ Output: [0, 1]                                                              │
 * │ Reason: nums[0] + nums[1] = 3 + 3 = 6                                      │
 * └─────────────────────────────────────────────────────────────────────────────┘
 * 
 * Constraints:
 * • 2 ≤ nums.length ≤ 10^4
 * • -10^9 ≤ nums[i] ≤ 10^9
 * • -10^9 ≤ target ≤ 10^9
 * • Only one valid answer exists
 * 
 * Algorithm: HashMap Approach (Optimal)
 * • Time Complexity:  O(n) - Single pass through array
 * • Space Complexity: O(n) - HashMap storage for visited elements
 * 
 * @author Krishna Goud P
 * @version 1.0
 * @since 2025
 */
class TwoSumSolution {
    /**
     * Finds two numbers in array that add up to target value
     * 
     * Strategy: Use HashMap to store visited numbers and their indices.
     * For each element, check if its complement (target - element) exists in the map.
     * 
     * @param nums   Array of integers to search through
     * @param target The target sum we're looking for
     * @return       Array containing indices of the two numbers [index1, index2]
     * @throws IllegalArgumentException if no valid solution exists
     */
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store: number -> its index in the array
        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        // Iterate through array once
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentNumber = nums[currentIndex];
            int complement = target - currentNumber;

            // Check if complement exists in our map
            if (numToIndexMap.containsKey(complement)) {
                // Found the pair! Return indices
                return new int[]{numToIndexMap.get(complement), currentIndex};
            }

            // Store current number and its index for future lookups
            numToIndexMap.put(currentNumber, currentIndex);
        }

        // This should never happen according to problem constraints
        throw new IllegalArgumentException("No valid two sum solution found!");
    }

    /**
     * Test Suite - Demonstrates the solution with various test cases
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("                TWO SUM SOLUTION DEMO                        ");
        System.out.println("===============================================================");
        
        // Test Case 1: Basic example
        testTwoSum(new int[]{2, 7, 11, 15}, 9, "Test Case 1");
        
        // Test Case 2: Different order
        testTwoSum(new int[]{3, 2, 4}, 6, "Test Case 2");
        
        // Test Case 3: Duplicate numbers
        testTwoSum(new int[]{3, 3}, 6, "Test Case 3");
        
        // Test Case 4: Negative numbers
        testTwoSum(new int[]{-1, -2, -3, -4, -5}, -8, "Test Case 4");
        
        // Test Case 5: Mixed positive/negative
        testTwoSum(new int[]{-3, 4, 3, 90}, 0, "Test Case 5");
        
        System.out.println("===============================================================");
        System.out.println("                ALL TESTS COMPLETED!                         ");
        System.out.println("===============================================================");
    }
    
    /**
     * Helper method to test and display results for a single test case
     * 
     * @param nums     Input array
     * @param target   Target sum
     * @param testName Name of the test case
     */
    private static void testTwoSum(int[] nums, int target, String testName) {
        try {
            int[] result = twoSum(nums, target);
            System.out.println("\n" + testName + ":");
            System.out.println("Input:  nums = " + Arrays.toString(nums) + ", target = " + target);
            System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
            System.out.println("Verification: nums[" + result[0] + "] + nums[" + result[1] + "] = " 
                             + nums[result[0]] + " + " + nums[result[1]] + " = " 
                             + (nums[result[0]] + nums[result[1]]));
        } catch (Exception e) {
            System.out.println("\n" + testName + ": ERROR - " + e.getMessage());
        }
    }
}

/**
 * ===============================================================================
 *                        ALGORITHM ANALYSIS & WALKTHROUGH
 * ===============================================================================
 * 
 * Step-by-Step Example: nums = [2, 7, 11, 15], target = 9
 * 
 * Iteration 1 (i=0):
 * ┌─────────────────────────────────────────────────────────────────────────────┐
 * │ • currentNumber = 2                                                         │
 * │ • complement = 9 - 2 = 7                                                   │
 * │ • HashMap is empty, so 7 not found                                         │
 * │ • Store: numToIndexMap = {2: 0}                                            │
 * └─────────────────────────────────────────────────────────────────────────────┘
 * 
 * Iteration 2 (i=1):
 * ┌─────────────────────────────────────────────────────────────────────────────┐
 * │ • currentNumber = 7                                                         │
 * │ • complement = 9 - 7 = 2                                                   │
 * │ • HashMap contains 2 at index 0                                            │
 * │ • SOLUTION FOUND! Return [0, 1]                                            │
 * └─────────────────────────────────────────────────────────────────────────────┘
 * 
 * Performance Analysis:
 * • Time Complexity:  O(n) - Single pass through array
 * • Space Complexity: O(n) - HashMap storage in worst case
 * • This is optimal compared to brute force O(n²) approach
 * 
 * Alternative Approaches:
 * 1. Brute Force: O(n²) time, O(1) space - Check all pairs
 * 2. Two Pointers: O(n log n) time, O(1) space - Sort first, then use pointers
 * 3. HashMap (Current): O(n) time, O(n) space - Optimal for this problem
 * 
 * Key Insights:
 * • HashMap allows O(1) average lookup time
 * • We build the map as we go, avoiding duplicate work
 * • Early termination when solution is found
 * • Handles negative numbers and duplicates correctly
 * 
 * Related Problems:
 * • Three Sum (LeetCode 15)
 * • Four Sum (LeetCode 18)
 * • Two Sum II - Input array is sorted (LeetCode 167)
 * • Two Sum III - Data structure design (LeetCode 170)
 * 
 * ===============================================================================
 */