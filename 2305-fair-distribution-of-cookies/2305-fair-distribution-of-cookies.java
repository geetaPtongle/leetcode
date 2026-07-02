class Solution {
    int result = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] children =new int[k];        
        solve(cookies,k, children, 0);
        return result;
        
    }

   public void solve(int[] cookies, int k, int[] children, int index){
        if(index ==cookies.length){
             int max = 0;
            for(int i : children){
                max=Math.max(i , max);
            }
             result= Math.min(result, max);
             return;            
        }
        int cokkie=cookies[index];
        for(int i=0; i<k; i++){
            children[i] +=cokkie;
           solve(cookies,k, children, index +1);
              children[i] -=cokkie;
        }     
    }
}