class Solution {
    //Buket Sort TC:O(N) SC:O(1)
    public void sortColors1(int[] nums) {
        int n = nums.length;
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                count0++;
            else if (nums[i] == 1)
                count1++;
            else if (nums[i] == 2)
                count2++;
        }
        int index = 0;
        for (int i = 0; i < count0; i++)
            nums[index++] = 0;
        for (int i = 0; i < count1; i++)
            nums[index++] = 1;
        for (int i = 0; i < count2; i++)
            nums[index++] = 2;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0,mid = 0,high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                  swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                 swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}