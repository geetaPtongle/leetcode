class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
    Set<List<Integer>> ans = new HashSet<>();
        for(int i=0; i<n; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int thirdEl=-(arr[i] + arr[j]);
                if(hashset.contains(thirdEl)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], thirdEl);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}