import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber {
    /**
     * Given a **non-empty** array of integers `nums`, every element appears *twice* except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * @example
     * Example 1:
     * Input: nums = [2,2,1]
     * Output: 1
     *
     * Example 2:
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     *
     * Example 3:
     * Input: nums = [1]
     * Output: 1
     *
     * @constraint
     * - 1 <= nums.length <= 3 * 10^4
     * - -3 * 10^4 <= nums[i] <= 3 * 10^4
     * - Each element in the array appears twice except for one element which appears only once.
     *
     * @param nums a non-empty array of integers
     * @return the single element that appears only once
     */
    public static int bruteForceSingleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.putIfAbsent(i, 0);
        }
        for(int i: nums) {
            int val = map.get(i) + 1;
            map.put(i, val);
        }
        for(int i: nums){
            int val = map.get(i);
            if(val == 1){
                return i;
            }
        }
        return -1;
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testCases = {{2, 2, 1}, {4, 1, 2, 1, 2}, {1}};
        int[] expectedOutputs = {1, 4, 1};

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int result = singleNumber(nums);
            System.out.printf("Input: %s, Expected Output: %d, Output: %d%n",
                    Arrays.toString(nums), expectedOutputs[i], result);
            if (result != expectedOutputs[i]) {
                System.out.println("Test case failed!");
            }
        }
    }
}
