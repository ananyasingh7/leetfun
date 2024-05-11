public class IsPalindrome {

    /**
     * A palindrome is a number that reads the same backward as forward. For example, 121 is a palindrome, but 123 is not.
     *
     * @example
     * Example 1:
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     *
     * Example 2:
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     *
     * Example 3:
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     *
     * @constraint
     * -2^31 <= x <= 2^31 - 1
     *
     * @param x the integer to check for palindrome
     * @return true if x is a palindrome, false otherwise
     *
     * @followup Could you solve it without converting the integer to a string?
     */

    public static boolean isPalindrome(int x) {
        String conversion = String.valueOf(x);
        int length = conversion.length();
        char[] xChrs = conversion.toCharArray();
        if(conversion.toCharArray()[0] != conversion.toCharArray()[length-1]){
            return false;
        } else {
            for(int i = 1; i<xChrs.length/2; i++) {
                for(int j = xChrs.length-2; j>xChrs.length/2; j--){
                    if(xChrs[i] != xChrs[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // better/optimal O(n) solution to above code
    public static boolean isPalindromeBetter(int x) {
        if (x<0 || (x % 10 == 0 && x != 0))
            return false;

        String conversion = String.valueOf(x);
        int length = conversion.length();

        for(int i = 0; i<length; i++){
            if (conversion.charAt(i) != conversion.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }

    // @followup Could you solve it without converting the integer to a string?
    public static boolean isPalindromeEff(int x) {
        if (x<0 || (x % 10 == 0 && x != 0))
            return false;

        int originalNum = x;
        int reversedNum = 0;

        while (x > 0) {
            int digit = x % 10;
            reversedNum = reversedNum * 10 + digit;
            x /= 10;
        }

        return originalNum == reversedNum;
    }

    public static void main(String[] args) {
        int[] testCases = {121, -121, 10, 12321, 0, -101, 1000030001};
        boolean[] expectedOutputs = {true, false, false, true, true, false, false};

        for (int i = 0; i < testCases.length; i++) {
            boolean result = isPalindromeBetter(testCases[i]);
            System.out.printf("Input: %d, Expected: %b, Output: %b%n", testCases[i], expectedOutputs[i], result);
            if (result != expectedOutputs[i]) {
                System.out.println("Test case failed!");
            }
        }
    }
}
