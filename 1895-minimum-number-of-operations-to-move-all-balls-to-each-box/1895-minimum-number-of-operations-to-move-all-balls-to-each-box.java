class Solution {
    public int[] minOperations1(String boxes) {
        int n=boxes.length();
        int[] ans=new int[n];     
        int total=0;
            for(int i=0; i<n; i++){
                total=0;
                for(int j=0; j<n ;j++){
                    if(i==j) continue;
                    int abs=Math.abs(j-i); 
                     int val=Character.getNumericValue(boxes.charAt(j));
                    total += abs*val;
                }
                ans[i] =total;
            }
            return ans;
    }

    public int[] minOperations(String boxes) {
         int n=boxes.length();
        int[] ans=new int[n];     
        int cumVal=0;
        int cumSum=0;
        for(int i=0; i< n; i++){
            ans[i] +=cumSum;
            int val = Character.getNumericValue(boxes.charAt(i));
            cumVal += val;
        cumSum += cumVal;
        }
        cumVal=0;
        cumSum=0;

         for(int i=n-1;  i>=0; i--){
            ans[i] +=cumSum;
             int val = Character.getNumericValue(boxes.charAt(i));
            cumVal += val;
            cumSum +=cumVal;
        }
        return ans;
    }
}