class Solution {
    public int maxProfit(int[] prices, int fee) {
                 int n = prices.length;       
        int dp[][]= new int[n][2];
 
        for( int i=0;i<n;i++)
        {
             for( int j=0;j<2;j++)
             {
                       dp[i][j]=-1;                  
             }
        }
 
        return rec(0, 0 , prices, dp , fee);
    }

    int rec( int i, int buyStatus,  int prices[], int dp[][], int fee)
    {
        if( i==prices.length  )
        {
            return 0;
        }
 
        if( dp[i][buyStatus]!=-1)
        {
             return dp[i][buyStatus];
        }
 
        int ans=0;
 
        if( buyStatus==0 )
        {
            int skip = rec(i+1, 0,  prices, dp, fee);
            int buy =  -prices[i] + rec(i+1,1,  prices, dp, fee);
 
            ans = Math.max( skip, buy);
        }
        else
        {
            int skip = rec(i+1,1, prices, dp, fee);
            int sell = prices[i] - fee + rec(i+1,0 , prices, dp, fee);
 
            ans= Math.max( skip, sell);
        }
        dp[i][buyStatus] = ans;
        return ans;
    }
}