class Solution {
    public int rob(int[] nums) {
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

}