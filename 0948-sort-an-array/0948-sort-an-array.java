class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;

        int mid = nums.length / 2;

        // Split into left and right halves
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];

        for (int i = 0; i < mid; i++) left[i] = nums[i];
        for (int i = mid; i < nums.length; i++) right[i - mid] = nums[i];

        // Recursively sort both halves
        left = sortArray(left);
        right = sortArray(right); 
        return merge(left, right);
    }

    public int[] merge(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int[] a3 = new int[n1 + n2];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < a3.length; i++) {
            int val1 = (p1 < n1) ? a1[p1] : Integer.MAX_VALUE;
            int val2 = (p2 < n2) ? a2[p2] : Integer.MAX_VALUE;

            if (val1 <= val2) {
                a3[i] = val1;
                p1++;
            } else {
                a3[i] = val2;
                p2++;
            }
        }
        return a3;
    }
}