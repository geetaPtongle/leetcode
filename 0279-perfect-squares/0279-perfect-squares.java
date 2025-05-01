class Solution {
    int[] dp;

    public int numSquares1(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    public int solve(int n) {
        if (n == 0)
            return 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            minValue = Math.min(minValue, 1 + solve(n - square));
        }
        dp[n] = minValue;
        return minValue;
    }

       public int numSquares(int n) {
        int[] memo =new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] =0;
        for(int i=1; i<=n; i++){
            for(int j=1; j*j <=i; j++){
                int square=j*j;
                memo[i] = Math.min(memo[i], memo[i -square]+1);
            }
        }
        return memo[n];
       }
}