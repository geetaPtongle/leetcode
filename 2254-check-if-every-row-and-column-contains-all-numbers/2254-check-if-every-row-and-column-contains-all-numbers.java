class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int row = 0; row < n; row++) {
            boolean[] seenRow = new boolean[n];
            for (int col = 0; col < m; col++) {
                int numberIndex = matrix[row][col] - 1;
                if (seenRow[numberIndex])
                    return false;
                seenRow[numberIndex] = true;
            }
        }
         for (int col = 0; col < n; ++col) {
            boolean[] seenColumn = new boolean[n];
            for (int row = 0; row < n; ++row) {
                int numberIndex = matrix[row][col] - 1;
                if (seenColumn[numberIndex]) {
                    return false;
                }
                seenColumn[numberIndex] = true;
            }
        }
        return true;
    }

    
}