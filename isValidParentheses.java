import java.util.HashMap;
import java.util.Stack;

public class isValidParentheses {
    /**
     * Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`,
     * determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * 3. Every close bracket has a corresponding open bracket of the same type.
     *
     * @example
     * Example 1:
     * Input: s = "()"
     * Output: true
     *
     * Example 2:
     * Input: s = "()[]{}"
     * Output: true
     *
     * Example 3:
     * Input: s = "(]"
     * Output: false
     *
     * @constraint
     * - 1 <= s.length <= 10^4
     * - s consists of parentheses only '(){}[]'
     *
     * @param s the input string containing brackets
     * @return true if the input string is valid, false otherwise
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        boolean[] expectedOutputs = {true, true, false, false, true};

        for (int i = 0; i < testCases.length; i++) {
            boolean result = isValid(testCases[i]);
            System.out.printf("Input: %s, Expected: %b, Output: %b%n", testCases[i], expectedOutputs[i], result);
            if (result != expectedOutputs[i]) {
                System.out.println("Test case failed!");
            }
        }
    }
}
