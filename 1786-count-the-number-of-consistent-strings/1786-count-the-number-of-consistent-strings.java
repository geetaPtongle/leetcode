class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count =0;
    for(int i=0; i<words.length;i++){
        boolean isAllowed =true;
        for(int j=0; j<words[i].length(); j++){
            if(allowed.indexOf(words[i].charAt(j)) == -1){
                isAllowed=false;
                break;
            }
        }
        if(isAllowed) count++;
    }
    return count;
}
}