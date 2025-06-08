class Solution {
    public int longestValidParentheses1(String s) {
        int r = 0, l = 0, i = 0;
        int max = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(')
                l += 1;
            else
                r += 1;
            if (l == r)
                max = Math.max(max, l + r);
            else if (r > l)
                l = r = 0;
            i += 1;
        }
        l = 0;
        r = 0;
        i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '(')
                l += 1;
            else
                r += 1;

            if (l == r)
                max = Math.max(max, l + r);
            else if (l > r)
                l = r = 0;
            i -= 1;
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Sentinel value for base of the valid substring
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Try to match with a previous '('

                if (stack.isEmpty()) {
                    stack.push(i); // Reset base index
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}