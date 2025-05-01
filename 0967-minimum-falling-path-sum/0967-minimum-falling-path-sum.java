// class Solution {
//     int[][] memo;
//     int m;
//     int n;

//     public int minFallingPathSum(int[][] matrix) {
//         m = matrix.length;
//         n = matrix[0].length;

//         memo = new int[101][101];
//         for (int[] row : memo) {
//             Arrays.fill(row,  Integer.MAX_VALUE);
//         }
//         int minValue = Integer.MAX_VALUE;
//         int row = 0;
//         for (int col = 0; col < n; col++) {
//             minValue = Math.min(minValue, solve(matrix, row, col));
//         }
//         return minValue;
//     }

//     public int solve(int[][] matrix, int row, int col) {
//         if (row == m - 1) {
//             return matrix[row][col];
//         }
//         if (memo[row][col] != -1) {
//             return memo[row][col];
//         }
//         int minSum = Integer.MAX_VALUE;
//         int sum = matrix[row][col];

//         if (row+1 < n && col - 1 >= 0) 
//         minSum = Math.min(minSum, sum + solve(matrix, row + 1, col - 1));

//         minSum = Math.min(minSum, sum + solve(matrix, row + 1, col));

//          if (row+1 < n &&  col + 1 < n) 
//         minSum = Math.min(minSum, sum + solve(matrix, row + 1, col + 1));

//         memo[row][col] = minSum;

//         return minSum;
//     }
// }


class Solution {
    int[][] memo;
    int[][] matrix;
    int n;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.memo = new int[n][n];

        // Initialize memo with a default unvisited value
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int minPathSum = Integer.MAX_VALUE;

        // Start from each cell in the first row
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, dfs(0, col));
        }

        return minPathSum;
    }

    private int dfs(int row, int col) {
        // Boundary check
        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        // Base case: last row
        if (row == n - 1) {
            return matrix[row][col];
        }

        // If already computed, return memoized result
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }

        // Recursive calls to the next row: down-left, down, down-right
        int left = dfs(row + 1, col - 1);
        int down = dfs(row + 1, col);
        int right = dfs(row + 1, col + 1);

        // Compute and memoize the minimum path
        memo[row][col] = matrix[row][col] + Math.min(down, Math.min(left, right));
        return memo[row][col];
    }
}
