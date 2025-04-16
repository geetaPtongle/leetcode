class Solution {
    public String makeSmallestPalindrome(String s) {
        int i =0, j =s.length()-1;
        char[] charArray = s.toCharArray();
        while(i < j){
            if(charArray[i] != charArray[j]){
            char smallest = (charArray[i] < charArray[j]) ? charArray[i] : charArray[j];
            charArray[i] = smallest;
            charArray[j] = smallest;  
            }
            i++;
            j--;
        }
        return new String(charArray);
    }
}