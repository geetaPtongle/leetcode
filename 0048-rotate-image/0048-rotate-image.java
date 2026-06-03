class Solution {
    public void rotate1(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] ans = new int[n][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[j][m-i-1]= matrix[i][j];
            }
        }

    for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

      public void rotate(int[][] matrix) {
      int n=matrix.length;
      for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];           
            matrix[j][i] = temp;
        }
      }
        for(int i=0; i<n; i++){
        int left =0; int right=n-1;
            while(left<right){
            int temp= matrix[i][left];
            matrix[i][left]= matrix[i][right];
            matrix[i][right] = temp;
            left++;
            right--;
            }
        }

      }
}