
import java.util.*;

/**
 * LeetCode Problem: Two Sum
 * 
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may 
 * not use the same element twice. You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 */

 class Solution {
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