class Solution {
 //Approach-1 (Recursion with Memo) : Top Down
//  Time Complexity: O(n) — Linear time, as each number is calculated only once and stored for future use.
// Space Complexity: O(n) —due to the storage required for both the recursion stack and the dp array.
     public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
         return recur(n,dp);
     }
    public int recur(int n, int[] dp) {
      
        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = recur(n - 1, dp) + recur(n - 2, dp);
        return dp[n];

    }

    //Approach-2 (Using Bottom Up DP)
// Time Complexity: O(n)

// Space Complexity: O(n)
    public int climbStairs2(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        if (n == 1 || n == 2)
            return n;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

         for(int i = 3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }

// Approch 3rd : dynamic programming approach using a space-optimized iterative solution
//  time complexity of O(n),
//  space complexity is O(1)
    public int climbStairs3(int n) {
    if (n <= 2) {
        return n;
    }
    
    int prev1 = 2, prev2 = 1; // prev2 is the number of ways for n=1, prev1 for n=2
    int result = 0;
    
    for (int i = 3; i <= n; i++) {
        result = prev1 + prev2;
        prev2 = prev1;
        prev1 = result;
    }
    return result;
}
}