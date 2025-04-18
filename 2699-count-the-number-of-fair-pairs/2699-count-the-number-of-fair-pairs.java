class Solution {
    
//⏱ Time Complexity:
// O(n log n) for sorting
// O(n log n) for binary search in each iteration
// ➡️ Total: O(n log n)
// \U0001f4e6 Space Complexity: O(1)

   public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int leftBound = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int rightBound = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (rightBound - leftBound + 1);
        }
        return count;
    }

    // First index where nums[index] >= target
    private int lowerBound(int[] nums, int left, int right, int target) {
        int res = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    // Last index where nums[index] <= target
    private int upperBound(int[] nums, int left, int right, int target) {
        int res = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}