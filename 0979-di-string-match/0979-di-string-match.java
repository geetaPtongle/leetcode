class Solution {
    public int[] diStringMatch(String s) {
        int[] array =new int[s.length() + 1 ];
         int I =0;
         int D =s.length(); 
        for(int i =0; i< s.length(); i++){
            if(s.charAt(i) == 'I'){
                 array[i] =I;
                 I++;
            }
            if(s.charAt(i) == 'D'){
                array[i] = D;
                D--;
            }
        }
         array[s.length()] = D;
        return array;
    }
}