class Solution {
    public void nextPermutation(int[] nums) {
        int piv=-1;
        int n=nums.length;

        for(int i=n-2; i>=0; i--){
            if(nums[i]< nums[i+1]){
                piv=i;
                break;
            }
        }
            if(piv ==-1){
                reverse(nums, 0, n-1);
                return;
            
        }

        for(int i=n-1; i>piv; i--){
            if(nums[i] > nums[piv]){
                int temp =nums[piv];
                nums[piv]=nums[i];
                nums[i]=temp;
                break;
            }
        }

          reverse(nums, piv + 1, n - 1);
    }

     public void reverse(int[] nums, int i, int j) {

     while(i<=j){
          int temp =nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
     }
     }
}