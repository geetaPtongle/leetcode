class Solution {
    //Approch 1st TC and SC

    // Time Complexity (TC):
    // Replacing elements: The loop that goes through the array (for(int i = 0; i < n; i++)) has a time complexity of O(n), where n is the length of the array.

    // Sorting: Arrays.sort(nums) uses Timsort (a hybrid sorting algorithm that combines Merge Sort and Insertion Sort). The time complexity of Timsort is O(n log n) in the average and worst cases.

    //Total TC = O(n + n log n) = O(n log n).

    // Space Complexity (SC):
    // In-place Modification: The array is modified in place, so there is no additional space used for that step. Hence, space complexity for replacing elements is O(1).

    // Sorting: Arrays.sort(nums) uses Timsort, which is an in-place sorting algorithm. Therefore, the space complexity for sorting is O(log n).

    public int[] transformArray1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        Arrays.sort(nums);
        return nums;
    }

// Approch 2nd
//(TC) (SC) of Optimized Code:
// Time Complexity (TC):

// The first loop counts and modifies the values, which takes O(n).

// The second loop fills in the 0s and 1s, which also takes O(n).

// Total TC = O(n + n) = O(n).

// Space Complexity (SC):

// The array is modified in place, so no extra space is used. SC = O(1).

    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
                zeroCount++;
            } else {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < zeroCount; i++) {
            nums[i] = 0;
        }
        for (int i = zeroCount; i < n; i++) {
            nums[i] = 1;
        }
        return nums;
    }
}