class Solution {
   public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIndex = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // differ by exactly one char, and not same group, and improves subsequence length
                if (check(words[i], words[j]) 
                    && dp[j] + 1 > dp[i] 
                    && groups[i] != groups[j]) {
                    
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // reconstruct the subsequence
        List<String> result = new ArrayList<>();
        for (int at = maxIndex; at != -1; at = prev[at]) {
            result.add(words[at]);
        }
        Collections.reverse(result);
        return result;
    }
    
    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        // ensure exactly one character differs
        return diff == 1;
    }
}