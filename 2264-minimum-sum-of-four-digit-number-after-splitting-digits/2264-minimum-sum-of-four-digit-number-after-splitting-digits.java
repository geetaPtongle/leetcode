class Solution {
    public int minimumSum(int num) {
        int res=0;
        char[] nums=("" + num).toCharArray();
        Arrays.sort(nums);
        for(int i =0, j= nums.length -1; i< j; i++, j-- ){
            res += Integer.parseInt(""+ nums[i] + nums[j]);
        }
        return res;
    }
}