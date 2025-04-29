class Solution {
//Approach-1 (Classic sliding window)
//T.C : O(n)
//S.C : O(1)
    public long countSubarrays(int[] nums, int k) {
         int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;
        int i = 0, j = 0;

        long result = 0;
        int countMax = 0;

        while (j < n) {
            if (nums[j] == maxE) {
                countMax++;
            }

            while (countMax >= k) {
               int diff = n - j;
                result += diff;

                if (nums[i] == maxE) {
                    countMax--;
                }
                i++;
            }
            j++;
        }

        return result;
    }
    
}