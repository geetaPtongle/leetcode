class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        Integer [][]dp =new Integer[m][m];
        return solve(0, 0 , triangle, dp);
    }

    public int solve(int i, int j, List<List<Integer>> triangle, Integer[][] dp){
         int m = triangle.size();
         if (dp[i][j] != null) return dp[i][j];
        if( i== m-1) return triangle.get(i).get(j);
        int down =  triangle.get(i).get(j) + solve(i+1, j, triangle, dp);
        int diago =  triangle.get(i).get(j) + solve(i+1, j+1, triangle,dp);
        return dp[i][j] =Math.min(down,diago);
    }
}