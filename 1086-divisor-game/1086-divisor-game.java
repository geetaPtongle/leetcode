class Solution {
    public boolean divisorGame(int n) {
    int dp[] =new int[n];
        if(n < 2) return false;

       for(int i=3; i< n; i++)
       {
        if(n% i == 0 && n > i) {
           dp[i]= n-i;
        }
       }
       return n % 2==0 ;

    }
}