class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
         int sum=0;
        
       
        for(int i=0; i<n; i++){
            sum +=nums[i];
        }
        if(sum %2 !=0 ) return false;

          int target = sum / 2;

         int[][] memo = new int[n + 1][target + 1];

         for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(nums, n, sum/2, memo);
    }

   boolean helper( int[] nums, int n, int target, int[][] memo){
      boolean result;
        if(target ==0) return true;
        if(n==0) return false;
         if (memo[n][target] != -1) {
            return memo[n][target] == 1;
        }
        if(target >= nums[n-1]){
            result= helper(nums,n-1, target-nums[n-1], memo) || helper(nums, n-1, target, memo);
        }
        else{
             result= helper(nums, n-1, target, memo);
        }
        memo[n][target] = result ? 1 : 0;
        return result;
    }
}