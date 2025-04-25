class Solution {
    Integer[] memo;
    int [] dp;
    public int numDecodings(String s) {
        // memo = new Integer[s.length() + 1];
        // Arrays.fill(memo, -1);
        // return solve(0, s);

        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        dp = new int[n + 1];

        dp[0] = 1;  // Base case for empty string
        dp[1]= (s.charAt(0)!='0')?1:0;;  // Base case for the first character

        for (int i = 2; i <= n; i++) {
             char chi = s.charAt(i-1);
            char chim1 = s.charAt(i-2);
            String st = s.substring(i-2, i);

            if(chi != '0') {
                dp[i] = dp[i-1];
            }

            if(chim1 != '0' && Integer.parseInt(st) <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }

    public int solve(int index, String s) {
        if (index == s.length())
            return 1;
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != -1)
            return memo[index];
        int pick1 = solve(index + 1, s);
        int pick2 = 0;
        if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            pick2 = solve(index + 2, s);
        }
        memo[index] = pick1 + pick2;
        return memo[index];
    }


     
}
