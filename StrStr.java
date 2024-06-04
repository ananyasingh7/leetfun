import java.util.HashMap;

public class StrStr {
    /**
     * Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`,
     * or `-1` if `needle` is not part of `haystack`.
     *
     * @example
     * Example 1:
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     *
     * Example 2:
     * Input: haystack = "leetcode", needle = "leeto"
     * Output: -1
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     *
     * @constraint
     * - 1 <= haystack.length, needle.length <= 10^4
     * - haystack and needle consist of only lowercase English characters.
     *
     * @param haystack the string to search in
     * @param needle the string to find
     * @return the index of the first occurrence of `needle` in `haystack`, or -1 if not found
     */

    // brute force approach
    public static int strStr(String haystack, String needle) {
        /*
        Time Complexity: O((n-m+1) * m) where n is the length of the haystack string and m is the length of the needle string
        Space Complexity: O(1) - constant space complexity.
         */
        int lengthOfNeedle = needle.length();
        int lengthOfHackstack = haystack.length();

        for(int i = 0; i<lengthOfHackstack; i++){
            if(i+lengthOfNeedle < lengthOfHackstack+1){
                if(haystack.substring(i,i+lengthOfNeedle).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    /*
    The second approach is generally more efficient because it avoids creating new substrings in each iteration, which could lead to additional memory allocation and copying overhead.
     */

    // Sliding Window
    public static int strStrOptimized(String haystack, String needle){
        int lengthOfNeedle = needle.length();
        int lengthOfHackstack = haystack.length();
        if(lengthOfNeedle > lengthOfHackstack) {
            return -1;
        }
        for(int i = 0; i<lengthOfHackstack; i++){
            int j;
            for(j = 0; j < lengthOfNeedle && i + j < lengthOfHackstack; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == lengthOfNeedle){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"sadbutsad", "sad"},
                {"leetcode", "leeto"},
                {"hello", "ll"},
                {"aaaaa", "bba"}
        };
        int[] expectedOutputs = {0, -1, 2, -1};

        for (int i = 0; i < testCases.length; i++) {
            String haystack = testCases[i][0];
            String needle = testCases[i][1];
            int result = strStrOptimized(haystack, needle);
            System.out.printf("Input: haystack = \"%s\", needle = \"%s\", Expected Output: %d, Output: %d%n",
                    haystack, needle, expectedOutputs[i], result);
            if (result != expectedOutputs[i]) {
                System.out.println("Test case failed!");
            }
        }
    }
}
