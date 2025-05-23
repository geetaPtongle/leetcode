class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            boolean[] seenRow = new boolean[n];
            for (int j = 0; j < m; j++) {
                int numberIndex = matrix[i][j] - 1;
                if (seenRow[numberIndex])
                    return false;
                seenRow[numberIndex] = true;
            }
        }
         for (int col = 0; col < n; ++col) {
            // Create a tracker for seen numbers in the current column
            boolean[] seenColumn = new boolean[n];
            for (int row = 0; row < n; ++row) {
                // Retrieve the number and convert it to an index (0 to n-1)
                int numberIndex = matrix[row][col] - 1;
                // Check if the number has already been seen in the current column
                if (seenColumn[numberIndex]) {
                    // If the number is seen before, the matrix is not valid
                    return false;
                }
                // Mark the number as seen
                seenColumn[numberIndex] = true;
            }
        }
        return true;
    }

    
}