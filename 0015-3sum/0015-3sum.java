class Solution {
    public List<List<Integer>> threeSum1(int[] arr) {
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

     public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(arr);
    for(int i=0; i<n; i++){
        if(i>0 && arr[i] == arr[i-1]) continue;
        int j=i+1;
        int k=n-1;
        while(j <k){
            int sum= arr[i] +arr[j]+arr[k];
            if(sum < 0){
                j++;
            }
            else if(sum >0){
                k--;
            }
            else{
                ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                j++;
                k--;

                while(j< k && arr[j] == arr[j-1]) j++;
                while(j< k && arr[k] == arr[k+1]) k--;
            }
        }

    }
        return ans;
     }
}