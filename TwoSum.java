import java.util.HashMap;

public class TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers
     * such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use
     * the same element twice. You can return the answer in any order.
     *
     * @example
     * Example 1:
     * Input: nums = [2, 7, 11, 15], target = 9
     * Output: [0, 1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Example 2:
     * Input: nums = [3, 2, 4], target = 6
     * Output: [1, 2]
     *
     * Example 3:
     * Input: nums = [3, 3], target = 6
     * Output: [0, 1]
     *
     * @constraint
     * - 2 <= nums.length <= 10^4
     * - -10^9 <= nums[i] <= 10^9
     * - -10^9 <= target <= 10^9
     * - Only one valid answer exists.
     *
     * @param nums   an array of integers
     * @param target the target sum
     * @return an array of two indices of the two numbers that add up to the target
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                }
            }
        }
        return solution;
    }

    // Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
    public static int[] twoSumEff(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int sub = target - nums[i];
            if(numMap.containsKey(sub)){
                return new int[] {numMap.get(sub), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] exampleOne = {2, 7, 11, 15};
        int targetOne = 9;
        int[] resultOne = twoSumEff(exampleOne, targetOne);
        System.out.println("Example 1 Output: [" + resultOne[0] + ", " + resultOne[1] + "]");

        int[] exampleTwo = {3, 2, 4};
        int targetTwo = 6;
        int[] resultTwo = twoSumEff(exampleTwo, targetTwo);
        System.out.println("Example 2 Output: [" + resultTwo[0] + ", " + resultTwo[1] + "]");

        int[] exampleThree = {3, 3};
        int targetThree = 6;
        int[] resultThree = twoSum(exampleThree, targetThree);
        System.out.println("Example 3 Output: [" + resultThree[0] + ", " + resultThree[1] + "]");
    }
}
