class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        int[] index = new int[primes.length];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                next = Math.min(next, dp[index[j]] * primes[j]);
            }

            dp[i] = next;

            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }

        return (int) dp[n - 1]; 
    }
}
