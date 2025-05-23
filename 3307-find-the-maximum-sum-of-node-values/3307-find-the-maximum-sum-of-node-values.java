class Solution {
    public long maximumValueSum1(int[] nums, int k, int[][] edges) {
        long sum=0;
    int count =0;
    int loss=Integer.MAX_VALUE;
    for(int num : nums){
        if((num ^ k)>num){
            count++;
            sum +=(num^k);
        }
        else{
            sum+=num;
        }
       loss = Math.min(loss, Math.abs(num - (num ^ k)));
    }
    if(count % 2==0) return sum;
    return sum-loss;
    }

 public long maximumValueSum(int[] nums, int k, int[][] edges) {
            int n = nums.length;
            Long[] profit = new Long[n];
            long orgSum = 0;

            for (int i = 0; i < n; i++) {
                profit[i] = (long)(nums[i] ^ k) - nums[i];
                orgSum += nums[i];
            }

            // Sort profits in descending order
            Arrays.sort(profit, Collections.reverseOrder());

            for (int i = 0; i + 1 < n; i += 2) {
                long pairSum = profit[i] + profit[i + 1];
                if (pairSum > 0) {
                    orgSum += pairSum;
                } else {
                    break; // No point in adding negative or zero profit pairs
                }
            }
            return orgSum;
        }
}