class Solution {
        static int count=0;
 
    static void dfs( int i, int j, int grid[][], int n , int m)
    {
         if( i<0 || j<0 || i==n || j==m || grid[i][j]==0)
         {
             return;
         }
 
         grid[i][j]=0;
 
         count++;
 
         dfs( i+1,j ,grid,n,m);
         dfs( i-1,j, grid, n,m);
         dfs(i, j+1, grid,n,m);
         dfs(i, j-1, grid,n,m);
 
    }
    public int maxAreaOfIsland(int[][] grid)
     {
          int n = grid.length;
          int m = grid[0].length;
 
          int ans=0;
 
          for( int i=0;i<n;i++)
          {
             for( int j=0;j<m;j++)
             {
                  if( grid[i][j]==1)
                  {
                       count=0;
                       dfs( i,j, grid,n,m);
 
                       if( count> ans )
                       {
                         ans= count;
                       }
                  }
             }
          }
          return ans;
    }
}