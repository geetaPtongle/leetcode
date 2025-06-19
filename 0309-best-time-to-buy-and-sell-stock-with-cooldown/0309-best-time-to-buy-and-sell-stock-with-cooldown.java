class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];

        return rec(0, 0, prices, dp);
    }

    private int rec(int i, int buy, int[] prices, Integer[][] dp) {
        if (i >= prices.length) return 0;

        if (dp[i][buy] != null) return dp[i][buy];

        int ans;
        if (buy == 0) {
            int skip = rec(i + 1, 0, prices, dp);
            int buyStock = -prices[i] + rec(i + 1, 1, prices, dp);
            ans = Math.max(skip, buyStock);
        } else {
            int skip = rec(i + 1, 1, prices, dp);
            int sell = prices[i] + rec(i + 2, 0, prices, dp); // cooldown of 1 day after selling
            ans = Math.max(skip, sell);
        }

        dp[i][buy] = ans;
        return ans;
    }
}
