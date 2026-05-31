class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int num: nums){
            xor ^=num;
        }
        return xor;
    }
     public int singleNumber1(int[] nums) {
        int n=nums.length;
        int max= nums[0];
        //finding max element
        for(int i=0; i<n; i++){
            max= Math.max(max, nums[i]);
        }

        //create hash array with max + 1 size
        int[] hash =new int[max+1];

        //count frecuency 
        for(int i=0; i<n; i++){
            hash[nums[i]]++;
        }

        //find out the element which has 1 fecency
        for(int i=0; i<hash.length; i++){
            if(hash[nums[i]] == 1) return nums[i];
        }
        return -1;
     }

}