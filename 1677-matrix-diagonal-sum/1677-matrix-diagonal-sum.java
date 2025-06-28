class Solution {
    public int diagonalSum(int[][] mat) {
        int m=mat.length;
        int sum =0;
        int n=mat[0].length;
        for(int i=0;i<m; i++)
        for(int j=0; j<n; j++){
             if(i == j){
                    sum += mat[i][j];
                }
                else if(i == (m-1-j)){
                    sum += mat[i][j];
                }
        }
        return sum;
        
    }
}