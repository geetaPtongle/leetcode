class Solution {
   public int lengthAfterTransformations1(String s, int t) {
        for(int i=0; i<t; i++){
            int n=s.length();
            String res="";
            for(int j=0; j<n; j++){
                if(s.charAt(j) =='z') res += "ab";
                else{
                    char a=s.charAt(j);
                    a++;
                    res += a;
                }
            }
            s= res;
        }
        return s.length();
    }

    public int lengthAfterTransformations(String s, int t) {
     final int mod = 1_000_000_007;
        int freq[] =new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0; i<t; i++){
            int newFre[] =new int[26];
            for(int j=0; j<26; j++){
                if(j==25){
                    newFre[0]=(newFre[0] + freq[25])%mod;
                    newFre[1]=(newFre[1] + freq[25])%mod;
                }else{
                    newFre[j+1]=(newFre[j+1] + freq[j])%mod;
                }
            }
            freq=newFre;
        }
         int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + freq[i]) % mod;
        }
        return result;
    }
}