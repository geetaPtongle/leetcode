class Solution {
    public int minPathSum(int[][] grid) {
         int m =grid.length;
        int n =grid[0].length;

        // int result =Integer.MAX_VALUE;
         int memo[][] = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        //travlng form 0 to n cell
      return solve(m - 1, n - 1, memo, grid);
         
    }

     public int solve(int i, int j,int[][] memo, int [][] grid) {
    if (i < 0 || j < 0) return Integer.MAX_VALUE;

    if (i == 0 && j == 0) {
        return grid[i][j];
    }

    if (memo[i][j] != Integer.MAX_VALUE) {
        return memo[i][j];
    }

    int up =solve(i - 1, j, memo, grid);
    int left = solve(i, j - 1, memo, grid);


  int minUp = up != Integer.MAX_VALUE ? up + grid[i][j] : Integer.MAX_VALUE;
        int minLeft = left != Integer.MAX_VALUE ? left + grid[i][j] : Integer.MAX_VALUE;

    return memo[i][j] = Math.min(minUp , minLeft);
    }
}