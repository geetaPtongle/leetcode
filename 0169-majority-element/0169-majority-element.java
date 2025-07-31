class Solution {
    // Brute forse approch
    
public int majorityElement1(int[] nums) {
        int n = nums.length, count = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }

            }
            if (count > n / 2)
                result = nums[i];
        }
        return result;
    }
    
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}