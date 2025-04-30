class Solution {
    // approch1
    public int findNumbers1(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] >= 10 && nums[i] <= 99) ||
                    (nums[i] >= 1000 && nums[i] <= 9999) ||
                    (nums[i] == 100000)) {
                result++;
            }
        }
        return result;
    }

    // approch2
    public int findNumbers2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = 0;
            int n = num;
            while (n != 0) {
                digits++;
                n /= 10;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        String[] strArray = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
             if (strArray[i].length() % 2 == 0) 
                count++;
        }
        return count;
    }
}