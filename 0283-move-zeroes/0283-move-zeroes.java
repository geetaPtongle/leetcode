class Solution {
    public void moveZeroes1(int[] nums) {
        int n= nums.length;
        int[] temp = new int[nums.length];
        int index =0;
        for(int i=0; i<n; i++){
            if(nums[i] !=0){
                temp[index]=nums[i];
                index++;
            }
        }
        for(int i=0; i<n; i++){
            nums[i] =temp[i];
        }
    }

    //Findout firts zero using a pointer j. If no zero is found, no further steps are needed.
    public void moveZeroes2(int[] nums) {
        int n= nums.length;
        int j=-1;
        //Finding first 0 element
        for(int i=0; i<n; i++){
            if(nums[i] ==0){
                j=i;
                break;
            }
        }
        if (j == -1) return;

        for(int i= j+1; i<n; i++){
            if(nums[i] !=0){
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }


      public void moveZeroes(int[] nums) {
      int n=nums.length, j=0;
      for(int i=0; i<n; i++){
         if(nums[i] !=0){
                int temp =nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            } 
      }
      }
}