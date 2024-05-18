import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    /**
     * Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only **once**. The **relative order** of the elements should be kept the **same**. Then return _the number of unique elements in_ `nums`.
     *
     * Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:
     *
     * - Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially. The remaining elements of `nums` are not important as well as the size of `nums`.
     * - Return `k`.
     *
     * **Custom Judge:**
     *
     * The judge will test your solution with the following code:
     *
     * ```
     * int[] nums = [...]; // Input array
     * int[] expectedNums = [...]; // The expected answer with correct length
     *
     * int k = removeDuplicates(nums); // Calls your implementation
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * ```
     *
     * If all assertions pass, then your solution will be **accepted**.
     *
     * @example
     * Example 1:
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * Example 2:
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * @constraint
     * - 1 <= nums.length <= 3 * 10^4
     * - -100 <= nums[i] <= 100
     * - nums is sorted in **non-decreasing** order.
     *
     * @param nums an integer array sorted in non-decreasing order
     * @return the number of unique elements in `nums`
     */
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[uniqueIndex]){
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex+1;
    }

    public static void main(String[] args) {
        int[][] testCases = {{1, 1, 2}, {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}};
        int[] expectedOutputs = {2, 5};
        int[][] expectedNums = {{1, 2}, {0, 1, 2, 3, 4}};

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int k = removeDuplicates(nums);
            System.out.printf("Input: %s, Expected Output: %d, Expected nums: %s%n",
                    Arrays.toString(testCases[i]), expectedOutputs[i], Arrays.toString(expectedNums[i]));

            if (k != expectedOutputs[i]) {
                System.out.println("Test case failed! Expected output: " + expectedOutputs[i] + ", but got: " + k);
            } else {
                boolean match = true;
                for (int j = 0; j < k; j++) {
                    if (nums[j] != expectedNums[i][j]) {
                        match = false;
                        break;
                    }
                }
                if (!match) {
                    System.out.println("Test case failed! Expected nums: " + Arrays.toString(expectedNums[i]) + ", but got: " + Arrays.toString(Arrays.copyOf(nums, k)));
                }
            }
        }
    }
}

/*
* PREWORK:
* nums = [0,0,1,1,1,2,2,3,3,4]

uniqueCounter = 0;
index = 1;
[0,0,1,1,1,2,2,3,3,4]
nums[1] == nums[0]
skip

uniqueCounter = 0;
index = 2;
[0,0,1,1,1,2,2,3,3,4]
nums[2] != nums[1]
uniqueCounter = 1;
nums[uniqueCounter] = nums[i] -> nums[1] = nums[2]
[0,1,1,1,1,2,2,3,3,4]

uniqueCounter = 1;
index = 3;
[0,1,1,1,1,2,2,3,3,4]
nums[3] == nums[1]
skip

uniqueCounter = 1;
index = 4;
[0,1,1,1,1,2,2,3,3,4]
nums[4] == nums[1]
skip

uniqueCounter = 1;
index = 5;
[0,1,1,1,1,2,2,3,3,4]
nums[5] != nums[1]
uniqueCounter = 2;
nums[uniqueCounter] = nums[i] -> nums[2] = nums[5]
[0,1,2,1,1,2,2,3,3,4]

... CONTINUES

* */
