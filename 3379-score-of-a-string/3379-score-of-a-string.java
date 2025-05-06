class Solution {
    public int scoreOfString(String s) {
      int n = s.length();
    int result = 0;
    for (int i = 1; i < n; i++) {
        result += Math.abs(s.charAt(i) - s.charAt(i - 1));
    }
    return result;
    }
}