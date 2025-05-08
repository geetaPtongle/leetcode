class Solution {
// Using stack approch 
// Time Complexity: O(n) - One pass over the string
// Space Complexity: O(n) StringBuilder to build result.
    public String removeDuplicates1(String s) {
        StringBuilder substr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!substr.isEmpty() && substr.charAt(substr.length() - 1) == ch) {
                substr.deleteCharAt(substr.length() - 1);
            } else {
                substr.append(ch);
            }
        }
        return substr.toString();
    }

// Using stack approch 
// Time Complexity: O(n) - One pass over the string + stack processing.
// Space Complexity: O(n) - Space for the stack + StringBuilder to build result.
     public String removeDuplicates(String s) {
    Stack<Character> st=new Stack();
         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
        if(!st.isEmpty() && st.peek().equals(ch))
            st.pop();
        else
            st.push(ch);
         }
        StringBuilder result = new StringBuilder();
    for (char c : st) {
        result.append(c);
    }
        return result.toString();
    }
}