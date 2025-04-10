//  Time Complexity:
// Sorting: O(n log n)
// Sliding window: O(n)
// Total: O(n log n)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minSum = Math.min(minSum, diff);
        }
        return minSum;
    }
}