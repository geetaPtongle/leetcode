//Optimized approach (dynamic programming approach)
// Time Complexity (TC):
// Initialization:

// The first two loops where we initialize dp[0][j] and dp[i][0] both run in O(m * n) time since you are iterating over all rows and columns.

// Dynamic Programming Calculation:

// The nested loops (starting from i = 1 and j = 1) also run in O(m * n) because both i and j iterate over the entire matrix of size m x n.

// In each iteration, you perform constant-time operations: the Math.min and addition, which are O(1) operations.

// Summing the DP table:

// The final nested loop that sums all elements of the dp table also runs in O(m * n) time.

// Since all the loops together are O(m * n), the overall time complexity is:

// Time Complexity (TC) = O(m * n)

// Space Complexity (SC):
// Matrix dp:

// You are creating a 2D array dp of size m x n, so the space complexity for this matrix is O(m * n).

// Auxiliary space:

// You are not using any other significant extra space apart from the dp array.
class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n = matrix[0].length; // number of rows
       int[][] dp = new int[m][n]; //number of columns
        

        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j]; //First loop is for columns, should go up to n
        for (int i = 0; i < m; i++) dp[i][0] = matrix[i][0]; //Second loop is for rows, should go up to m

         for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] != 0) {
                 int top = dp[i - 1][j];          // square ending just above
                    int left = dp[i][j - 1];         // square ending just left
                    int topLeft = dp[i - 1][j - 1];  // square ending diagonally

                dp[i][j] = 1 + Math.min(top,
                               Math.min(topLeft, left));
            }
        }
    }
        int sum =0;
         for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                sum +=dp[i][j];
            }
         }



    return sum;

    }

//Same code with with otimization
      public int countSquares1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int totalSquares = 0;

        // Fill the first column and update count
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0]; // Only 1x1 square possible here
            totalSquares += dp[i][0];
        }

        // Fill the first row and update count (start from j = 1 to avoid double count of (0,0))
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j]; // Only 1x1 square possible here
            totalSquares += dp[0][j];
        }

        // Fill the rest of the DP matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int top = dp[i - 1][j];          // square ending just above
                    int left = dp[i][j - 1];         // square ending just left
                    int topLeft = dp[i - 1][j - 1];  // square ending diagonally

                    // Minimum of the three neighbors plus 1 (current cell as bottom-right corner)
                    dp[i][j] = 1 + Math.min(top, Math.min(left, topLeft));

                    totalSquares += dp[i][j]; // Add current cell's square count to total
                }
            }
        }

        return totalSquares;
    }
}