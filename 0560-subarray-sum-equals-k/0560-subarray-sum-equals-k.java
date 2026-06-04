class Solution {
    public int subarraySum1(int[] nums, int k) {
        int n=nums.length;
        int count= 0;
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++){
                sum +=nums[j];
                if(sum==k) count++;
            }
        }
        return count++;
    }

    public int subarraySum(int[] nums, int k) {
         int n=nums.length;
        Map<Integer, Integer> hash=new HashMap<>();
        int prefixSum=0;
        int count=0;
        hash.put(0, 1);
        for(int i=0; i<n; i++){
            prefixSum += nums[i];
            if(hash.containsKey(prefixSum-k)){
                count += hash.get(prefixSum-k);
            }
            hash.put(prefixSum, hash.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}