class Solution {
//Tabulation Approach
// Time Complexity: O(N2)
// Reason: There are a total of N states and inside each state a loop of size N(apparently) is running.

// Space Complexity: O(N)
// Reason: O(N) is for the dp array we have used.   
 public int minCut(String str) {
        int n = str.length();
        int[] dp1 = new int[n + 1];
        dp1[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(str,i, j )) {
                    int cost = 1 + dp1[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp1[i] = minCost;
        }
        return dp1[0] - 1;
    }



//Without memoization Time Complexity: Exponential
// Time Complexity: O(N2)
// Reason: There are a total of N states and inside each state, a loop of size N(apparently) is running.

// Space Complexity: O(N) + Auxiliary stack space O(N)
// Reason: The first O(N) is for the dp array of size N.

    // public int minCut1(String s) {
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return helper(s, 0, dp) -1;
    // }

    // public int helper(String s, int index, int[] dp){
    //    if(s.length() == index) return 0;
    //    if(dp[index] != -1) return dp[index];
    //    int min = Integer.MAX_VALUE;
    //     for(int i=index; i< s.length(); i++){
    //         if(isPalindrome(s, index, i)){
    //              int cost = 1 + helper( s, i + 1);
    //              min =Math.min(cost, min);
    //         }
    //     }
    //     return dp[index] = min;
 
    // }

     public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

   
}