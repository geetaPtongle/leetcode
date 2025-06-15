class Solution {
        int rec(int i, int j,int matrix[][] , int n, int m , int prev ,int dp[][])
    {
           if(i<0 || j<0 || i==n || j==m || matrix[i][j]<=prev)
               return 0;
 
        if(dp[i][j]!=-1)
            return dp[i][j];
 
           int up= rec(i-1,j,matrix,n,m,matrix[i][j], dp);
           int down= rec(i+1,j,matrix,n,m,matrix[i][j],dp);
           int left= rec(i,j-1,matrix,n,m,matrix[i][j],dp);
          int right=  rec(i,j+1,matrix,n,m,matrix[i][j],dp);
 
        int ans= Math.max(left,Math.max(right,Math.max(up,down))) + 1;
        dp[i][j]= ans;
        return dp[i][j];
 
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
 
        int mx=0;
        int dp[][]= new int[201][201];
        for( int i=0;i<201;i++)
        {
             for( int j=0;j<201;j++)
             {
                 dp[i][j]=-1;
             }
        }
        for(int i=0;i<n;i++)
        {
             for(int j=0;j<m;j++)
             {
                   int temp= rec(i,j,matrix,n,m,-1,dp);
                   mx=Math.max(mx,temp);
             }
        }
 
        return mx;
    }
}