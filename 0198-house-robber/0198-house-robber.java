class Solution {
    public int rob1(int[] nums) {
        int[] memo =new int [nums.length];
        Arrays.fill(memo, -1);
       return solve(nums, 0, memo);
    }
    public int solve(int[] nums, int index, int[] memo){
        if(index >= nums.length) return 0;
        if(memo[index] !=-1) return memo[index];
        int steal =nums[index] + solve(nums, index+2, memo);
        int skip = solve(nums, index+1, memo);
        return memo[index]=Math.max(steal, skip);
    };

  public int rob(int[] nums) {
    int n =nums.length ;
    int t[] =new int[n+1];
    t[0] =0;
    t[1] =nums[0];
    for(int i =2; i<= n; i++){
        int steal=nums[i-1] + t[i-2];
        int skip=t[i-1];
       t[i] =Math.max(steal, skip);
    }
    return t[n];
  }
}