class Solution {
    public int maxProfit( int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k];
                for( int i=0;i<n;i++)
        {
             for( int j=0;j<2;j++)
             {
                  for( int x=0;x<k;x++)
                  {
                       dp[i][j][x]=-1;
                  }
             }
        }
        return res(0, prices, 0, n, dp, 0, k);
    }

    int res(int i, int[] prices, int txn, int n, int dp[][][], int buy, int k) {
        if (i == n || txn == k) {
            return 0;
        }

        if (dp[i][buy][txn] != -1) {
            return dp[i][buy][txn];
        }

        int ans = 0;
        if (buy == 0) {
            int take = -prices[i] + res(i + 1, prices, txn, n, dp, 1, k);
            int notTake = res(i + 1, prices, txn, n, dp, 0, k);

            ans = Math.max(take, notTake);
        } else {
            int sell = prices[i] + res(i + 1, prices, txn + 1, n, dp, 0, k);
            int notSell = res(i + 1, prices, txn, n, dp, 1, k);
            ans = Math.max(sell, notSell);
        }
        dp[i][buy][txn] = ans;
        return ans;
    }
}