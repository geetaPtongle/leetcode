class Solution {
    //Approach-1 (Using simple backtracking to generate subsets)
    //T.C : O(n * 2^n)
    //S.C : O(n * 2^n)
    // List<List<Integer>> subsets = new ArrayList<>();

    // public int subsetXORSum1(int[] nums) {
    //     List<Integer> temp = new ArrayList<>();
    //     solve(0, nums, temp);

    //     int result = 0;
    //     for (List<Integer> subset : subsets) {
    //         int xor = 0;
    //         for (int num : subset) {
    //             xor ^= num;
    //         }
    //         result += xor;
    //     }
    //     return result;
    // }

    // void solve(int index, int[] nums, List<Integer> temp) {
    //     if (index >= nums.length) {
    //         subsets.add(new ArrayList(temp));
    //         return;
    //     }

    //     temp.add(nums[index]);
    //     solve(index + 1, nums, temp);
    //     temp.remove(temp.size() - 1);
    //     solve(index + 1, nums, temp);
    // }

    public int subsetXORSum(int[] nums) {
        return helper(0, nums, 0);
    }

    int helper(int index, int[] nums, int xor){
        if(index == nums.length) return xor;
        int take =helper(index +1, nums, nums[index]^xor);
        int exclude=helper(index+1, nums, xor);

        return take + exclude;
    }

}