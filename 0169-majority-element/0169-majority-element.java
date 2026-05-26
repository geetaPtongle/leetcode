class Solution {
    public int majorityElement1(int[] nums) {
        int n=nums.length;
        for(int i=0;i < n;i++){
             int count =0;
            int temp=nums[i];
            for(int j=0; j<n;j++){
                if(temp == nums[j])
                count++;
            }
        if(count > n/2)
        return temp;
        }
        return -1;
        
    }
public int majorityElement(int[] nums) {
    int n=nums.length;
    int el=0;
    int count1=0;

    for(int i=0; i<n; i++){
        if(count1==0){
            el= nums[i];
            count1=1;
        }
        else if(nums[i] ==el){
            count1++;
        } 
        else {count1--;}        
    }

    int count2=0;
    for(int i=0;i<n; i++){
        if(nums[i] ==el) count2++;
    }

    if(count2 > (n/2)) return el;
    
    return -1;
    }
    
}