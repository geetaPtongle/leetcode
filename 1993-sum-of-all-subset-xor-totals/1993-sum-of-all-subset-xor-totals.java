class Solution {
    List<List<Integer>> subsets=new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        solve(0, nums, temp);

        int result =0;
        for (List<Integer> subset : subsets) {
            int xor=0;
            for(int num: subset){
                xor ^=num;
            }
            result +=xor;
        }
        return result;
    }

    void solve(int index, int[] nums, List<Integer> temp){
        if(index >= nums.length){
            subsets.add(new ArrayList(temp));
            return;
        }

        temp.add(nums[index]);
        solve(index +1, nums, temp);
        temp.remove(temp.size() -1);
         solve(index +1, nums, temp);
    }
}