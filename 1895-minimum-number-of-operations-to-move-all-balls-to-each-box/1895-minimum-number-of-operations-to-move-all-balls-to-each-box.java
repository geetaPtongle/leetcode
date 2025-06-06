class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] ans=new int[n];
        // Set<Integer> indices = IntStream.range(0, n)
        //     .filter(i -> binary.charAt(i) == '1')
        //     .boxed()
        //     .collect(Collectors.toSet());
        int total=0;
            for(int i=0; i<n; i++){
                total=0;
                for(int j=0; j<n ;j++){
                    if(i==j) continue;
                    int abs=Math.abs(j-i); 
                     int val=Character.getNumericValue(boxes.charAt(j));
                    total += abs*val;
                }
                ans[i] =total;
            }
            return ans;
    }
}