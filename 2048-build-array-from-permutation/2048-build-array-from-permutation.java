class Solution {
    public int[] buildArray1(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0; i<n;i++){
                ans[i] =nums[nums[i]];           
        }
        return ans;
    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // int msb = (int) ((Math.log(n) / Math.log(2)) + 1);
        // int mask = (1 << msb) - 1;

        // // binary String :: new Value....old Value
        // for (int i = 0; i < n; i++) {
        //     nums[i] |= (nums[nums[i]] & mask) << msb;
        // }

        // for (int i = 0; i < n; i++) {
        //     nums[i] >>= msb;        // remove old value
        // }

        for(int i=0; i<n; i++){
            nums[i] =nums[i] + n*(nums[nums[i]] %n);
        }

        for(int i=0;i<n;i++){
            nums[i]=nums[i]/n;
        }

        return nums;
    }
}