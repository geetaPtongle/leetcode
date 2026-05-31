class Solution {
    public int[] twoSum(int[] nums, int target) {
      
          int n = nums.length;

        // Step 1: store [value, original_index]
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        // Step 2: sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
          int i = 0, j = nums.length - 1;
        while (i < j) {
           int sum = arr[i][0] + arr[j][0];
            if (sum == target) {
                return new int[]{arr[i][1], arr[j][1]}; // 1-based indexing
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

  public int[] twoSum1(int[] nums, int target) {
     HashMap<Integer, Integer> map = new HashMap<>(); // num -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // 0-based index
            }

            map.put(nums[i], i);
        }

        return null;
  }
}