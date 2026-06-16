class Solution {
    public int trap1(int[] height) {
        int n=height.length;
        int totalTrap =0;
        for(int i=0; i<n; i++){
            int maxLeft = 0;
            int maxRight =0;
            
            //finding left maxhight
            for(int j=0; j<=i; j++){
                if(height[j] > maxLeft) 
                maxLeft =height[j];
            }

            //finding right maxhight
            for(int j=i; j<n; j++){
                if(height[j] > maxRight) 
                maxRight =height[j];
            }

        totalTrap +=Math.min(maxRight, maxLeft) - height[i];
        }
        return totalTrap;
    }

    public int trap(int[] height) {
        int ans= 0;
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0] = height[0];
  

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
            for(int i=n-2; i>=0;i--){
            rightMax[i] =Math.max(rightMax[i+1], height[i]);
        }

            for(int i=0;i <n; i++){
                ans +=Math.min(leftMax[i], rightMax[i]) -height[i];
            }
        return  ans;
    }
}