class Solution {
    public String removeDuplicates(String s) {
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
}