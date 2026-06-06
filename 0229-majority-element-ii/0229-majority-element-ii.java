class Solution {
    public List<Integer> majorityElement1(int[] nums) {
       int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Check if nums[i] is not already part of the result
            if (result.size() == 0 || result.get(0) != nums[i] && (result.size() < 2 || result.get(1) != nums[i])) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }
                if (count > n / 3) {
                    result.add(nums[i]);
                }
            }

            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int count1=0, count2=0;
        int el1=0,el2=0;
        int n=nums.length;
        for(int i=0; i<n; i++){

            if(count1 ==0 && nums[i] !=el2){
                count1=1;
                el1=nums[i];
            }else if(count2==0 && nums[i] !=el1){
                count2=1;
                el2=nums[i];
            }else if(nums[i] ==el1) {
                count1++;
            } else if (nums[i] ==el2) {
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        int mini = n / 3 + 1;
        for (int i=0; i<n ;i++){
            if(nums[i] ==el1) count1++;
            if (nums[i] ==el2) count2++;
        }
        if(count1 >= mini) result.add(el1);
        if (count2 >=mini && el1 !=el2) result.add(el2);
        return result;
    }
}