class Solution {
    //broth force but ther are some test cases are not running
    public int minimizeMax1(int[] nums, int p) {
        if (p == 0)
            return 0;

        int n = nums.length;
        boolean[] used = new boolean[n];
        return dfs(nums, used, 0, p, 0);
    }

    private int dfs(int[] nums, boolean[] used, int start, int remainingPairs, int currentMax) {
        if (remainingPairs == 0) {
            return currentMax;
        }

        int minMax = Integer.MAX_VALUE;

        for (int i = start; i < nums.length; i++) {
            if (used[i])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (used[j])
                    continue;

                // Choose pair (i, j)
                used[i] = used[j] = true;
                int diff = Math.abs(nums[i] - nums[j]);

                // Recurse to pick next pair
                int result = dfs(nums, used, i + 1, remainingPairs - 1, Math.max(currentMax, diff));
                minMax = Math.min(minMax, result);

                // Backtrack
                used[i] = used[j] = false;
            }
        }

        return minMax;
    }

     int n;

    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0;
        int pairs = 0;

        while (i < n - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }

        return pairs >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, mid, p)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

}