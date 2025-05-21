class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m= matrix[0].length;
        boolean zeroRow[]= new boolean[n];
        boolean zeroCol[]= new boolean[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(matrix[i][j] ==0){
                zeroRow[i]=true;
                zeroCol[j]=true;
               }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(zeroRow[i] || zeroCol[j] ){
                    matrix[i][j] =0;
                }
            }
        }
    }
}