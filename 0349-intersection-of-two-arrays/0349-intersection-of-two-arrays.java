class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
         Set<Integer> result = new HashSet<>();
       Set<Integer> set=new HashSet<Integer>();
      for (int num : nums1) {
        set.add(num);
       }
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;

        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }
}