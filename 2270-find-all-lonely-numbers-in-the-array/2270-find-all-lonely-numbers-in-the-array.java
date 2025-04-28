//using indexes and TC: n log n
class Solution {
    public List<Integer> findLonely1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            boolean leftOk = (i == 0) || (nums[i] - nums[i - 1] > 1);
            boolean rightOk = (i == n - 1) || (nums[i + 1] - nums[i] > 1);

            if (leftOk && rightOk) {
                list.add(nums[i]);
            }
        }
        return list;
    }

//Approch 2
//Tc: O(N)
//SC : O(N)
    public List<Integer> findLonely(int[] nums) {
        int n=nums.length;
     HashMap<Integer, Integer> map=new HashMap<>();
      List<Integer> list = new ArrayList<>();
     for(int num: nums){
         map.put(num, map.getOrDefault(num, 0) + 1);
     }
     for(Map.Entry<Integer, Integer> entries:  map.entrySet()){
        int val = entries.getKey();
        if(entries.getValue() == 1 && !map.containsKey(val+1) && !map.containsKey(val-1)){
            list.add(val);
        }
     }
     return list;
     }

}