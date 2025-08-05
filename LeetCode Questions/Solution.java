
import java.util.*;

/**
 * ═══════════════════════════════════════════════════════════════════════════════════
 *                              🎯 LEETCODE: TWO SUM PROBLEM
 * ═══════════════════════════════════════════════════════════════════════════════════
 * 
 * 📝 Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 * 
 * 🎯 Key Requirements:
 * • Each input has exactly one solution
 * • Cannot use the same element twice
 * • Return answer in any order
 * 
 * 💡 Examples:
 * ┌─────────────────────────────────────────────────────────────────────────────────┐
 * │ Example 1:                                                                      │
 * │ Input:  nums = [2, 7, 11, 15], target = 9                                      │
 * │ Output: [0, 1]                                                                  │
 * │ Reason: nums[0] + nums[1] = 2 + 7 = 9                                          │
 * │                                                                                 │
 * │ Example 2:                                                                      │
 * │ Input:  nums = [3, 2, 4], target = 6                                           │
 * │ Output: [1, 2]                                                                  │
 * │ Reason: nums[1] + nums[2] = 2 + 4 = 6                                          │
 * │                                                                                 │
 * │ Example 3:                                                                      │
 * │ Input:  nums = [3, 3], target = 6                                              │
 * │ Output: [0, 1]                                                                  │
 * │ Reason: nums[0] + nums[1] = 3 + 3 = 6                                          │
 * └─────────────────────────────────────────────────────────────────────────────────┘
 * 
 * 📊 Constraints:
 * • 2 ≤ nums.length ≤ 10⁴
 * • -10⁹ ≤ nums[i] ≤ 10⁹
 * • -10⁹ ≤ target ≤ 10⁹
 * • Only one valid answer exists
 * 
 * 🚀 Algorithm: HashMap Approach (Optimal)
 * • Time Complexity:  O(n) - Single pass through array
 * • Space Complexity: O(n) - HashMap storage for visited elements
 * 
 * @author Krishna Goud P
 * @version 1.0
 * @since 2025
 */
public class Solution {
   public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            numMap.put(nums[i], i);
        }

        // According to the problem, there is always one solution.
        throw new IllegalArgumentException("No two sum solution");
    }

    // Optional main method to test
    public static void main(String[] args) {
        int[] result = twoSum(new int[] {2, 7, 11, 15}, 9);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}


/*Example Walkthrough:
Let's trace through nums = [2, 7, 11, 15], target = 9:

i=0, nums[0]=2:

complement = 9 - 2 = 7
HashMap is empty, so 7 not found
Store: numMap = {2: 0}
i=1, nums[1]=7:

complement = 9 - 7 = 2
HashMap contains 2 at index 0
Found solution! Return [0, 1]
Time Complexity: O(n) - Single pass through array
Space Complexity: O(n) - HashMap storage
This approach is much more efficient than the brute force O(n²) solution because it uses the HashMap for O(1) lookup time instead of nested loops. */