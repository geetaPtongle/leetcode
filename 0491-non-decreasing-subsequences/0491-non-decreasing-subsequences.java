class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
         nonDecresingSubsequence(0, nums, path, ans);
         return ans;
    }

    public void nonDecresingSubsequence(int index, int[] nums, List<Integer> current,
            List<List<Integer>> ans) {
        Set set =new HashSet(); 

        if (current.size() > 1) {
            ans.add(new ArrayList<>(current));
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
          if ((current.isEmpty() ||  num >= current.get(current.size() - 1)) && set.add(num)) {
                current.add(num);
                nonDecresingSubsequence(i + 1, nums, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
}