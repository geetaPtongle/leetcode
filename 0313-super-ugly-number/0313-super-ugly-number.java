class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        int[] index = new int[primes.length];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
             dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                 dp[i] = Math.min(dp[i], dp[index[j]] * primes[j]);
            }

            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }

        return (int) dp[n - 1]; 
    }
}
