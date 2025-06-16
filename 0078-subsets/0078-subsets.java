class Solution {
        private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp =new ArrayList<>();
        solve(nums, 0, temp);
    return result;
    }

     void solve(int[] nums, int index, List<Integer> temp){
        if(nums.length <= index){
            result.add(new ArrayList<>(temp));
            return ;
        }

        temp.add(nums[index]);
        solve(nums, index+1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, index+1, temp);
     }
}