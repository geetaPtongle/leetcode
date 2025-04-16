class Solution {
    public int maximizeSum(int[] nums, int k) {
        int n =nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int sum =0;
        while(--k >= 0){ 
            sum += max;
             max++;
        }
        return sum;
    }
}