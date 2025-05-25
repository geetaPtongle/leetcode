class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count =new HashMap<>();
        for(String a: words){
            count.put(a, count.getOrDefault(a, 0) +1);
        }
        int len =0;
        boolean center=false;
        for(Map.Entry <String, Integer> entry : count.entrySet()){
            String word= entry.getKey();
            int freq= entry.getValue();
            String rev= new StringBuilder(word).reverse().toString();
            if(word.equals(rev)){
                int pairs=freq/2;
                len +=pairs*4;
                if(freq %2 ==1) center =true;
            }
            else if(count.containsKey(rev)){
                int pairs =Math.min(freq, count.get(rev));
                len +=pairs*4;
                count.put(rev, 0);
                count.put(word, 0);
            }
        }
        if(center){
            len +=2;
        }
        return len;
    }
}