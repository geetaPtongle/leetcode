class Solution {
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        int n=nums.length;
        Set<List<Integer>> ans =new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                         long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                         if(sum == target){
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            ans.add(temp);
                         }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> fourSum2(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        // First loop - pick first number
        for (int i = 0; i < n; i++) {
            // Second loop - pick second number
            for (int j = i + 1; j < n; j++) {
                // HashSet for numbers between j and k
                HashSet<Integer> seen = new HashSet<>();

                // Third loop - pick third number
                for (int k = j + 1; k < n; k++) {
                    // Find required fourth number
                    long required = (long) target - arr[i] - arr[j] - arr[k];

                    // If required number already seen → valid quadruplet
                    if (seen.contains((int) required)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) required);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    // Add current third number into set
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

     public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if (j != i+1 && arr[j] == arr[j-1]) continue;

                int k=j+1;
                int l=n-1;

                while (k<l){
                    long sum=(long) arr[i] + arr[j] +arr[k] + arr[l];
                    if(sum < target){
                        k++;
                    } else if (sum > target) {
                        l--;
                    }
                    else {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while (k<l && arr[k] == arr[k-1]) k++;
                        while (k<l && arr[l] == arr[l+1]) l--;
                    }
                }
            }
        }
        return ans;
     }
}