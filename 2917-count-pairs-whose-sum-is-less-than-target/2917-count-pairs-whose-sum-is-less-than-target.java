class Solution {
// Approch 1st
// Time Complexity:
// O(n^2): Since you're using two nested loops, 
    public int countPairs1(List<Integer> nums, int target) {
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target)
                    count++;
            }
        }
        return count;
    }

// Approch 2st
// Time Complexity: 
// O(nlogn), due to the sorting step, which is more efficient than the nested loop approach with 

// Space Complexity: O(1), because we're only using a constant amount of extra space.

public int countPairs(List<Integer> nums, int target) {
        // Sort the list to use two-pointer technique
        Collections.sort(nums);
        
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;

        // Use two pointers to find the valid pairs
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                // If sum is less than target, all pairs from left to right are valid
                count += (right - left);
                left++; // Move left pointer to the right
            } else {
                // If sum is >= target, move right pointer to the left
                right--;
            }
        }

        return count;
    }
}