class Solution {
    public int missingNumber1(int[] nums) {
        int n= nums.length;
        int actual_num=n*(n+1)/2;
        int sum =0;
        for(int num: nums){
            sum +=num;
        }
        return actual_num-sum;
    }

     public int missingNumber(int[] nums) {
        int xor = nums.length;  // start with n

                for (int i = 0; i < nums.length; i++) {
                    xor = xor ^ i;
                    xor = xor ^ nums[i];
                }
                return xor;
     }
}