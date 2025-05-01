class Solution {
    int[][] memo;
    int m;
    int n;

    public int minFallingPathSum(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        memo = new int[101][101];
        for (int[] row : memo) {
            Arrays.fill(row,  Integer.MAX_VALUE);
        }
        int minValue = Integer.MAX_VALUE;
        int row = 0;
        for (int col = 0; col < n; col++) {
            minValue = Math.min(minValue, solve(matrix, row, col));
        }
        return minValue;
    }

    public int solve(int[][] matrix, int row, int col) {
        if (row == m - 1) {
            return matrix[row][col];
        }
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        int minSum = Integer.MAX_VALUE;
        int sum = matrix[row][col];

        if (row+1 < n && col - 1 >= 0) 
        minSum = Math.min(minSum, sum + solve(matrix, row + 1, col - 1));

        minSum = Math.min(minSum, sum + solve(matrix, row + 1, col));

         if (row+1 < n &&  col + 1 < n) 
        minSum = Math.min(minSum, sum + solve(matrix, row + 1, col + 1));

        memo[row][col] = minSum;

        return minSum;
    }
}