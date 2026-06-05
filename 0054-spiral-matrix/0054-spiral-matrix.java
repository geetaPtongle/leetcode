class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int sRow=0;
        int sCol=0;
        int eRow=m-1;
        int eCol=n-1;
        while (sRow<=eRow && sCol<=eCol){
            //Top
            for(int i=sCol; i<=eCol; i++){
                result.add(matrix[sRow][i]);
            }
          

            //right    
            for(int i= sRow+1; i<=eRow; i++){
                result.add(matrix[i][eCol]);
            }
           

            //Bottom
            for(int i=eCol-1; i>=sCol; i--){
                if(sRow==eRow) break;
                result.add(matrix[eRow][i]);
            }
            

            //left
            for(int i=eRow-1; i>=sRow+1; i--){
                if(sCol==eCol) break;
                result.add(matrix[i][sCol]);
            }
            sRow++;eRow--;sCol++;eCol--;

        }
        return result;
    }
}