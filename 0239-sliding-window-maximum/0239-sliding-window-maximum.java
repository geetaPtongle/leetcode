class Solution {
    //Brute Force Approach
    public int[] maxSlidingWindow1(int[] nums, int k) {
       int n= nums.length;
        int max = Integer.MIN_VALUE;
        int[] ans= new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            max=nums[i];
            for(int j=i; j<k+i; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }           
            ans[i] = max;
        }
        return ans;
    }

class Pair implements Comparable<Pair>{
int val;
int idx;
public Pair(int val, int idx){
    this.val =val;
    this.idx=idx;
}
@Override
public int compareTo(Pair p2){
    //acending
    // return this.val-p2.val;
    //Decending
    return p2.val -this.val;
}
}
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] res=new int[n-k+1];
        for(int i=0; i<k; i++){
            pq.add(new Pair(nums[i], i));
        }
        res[0] =pq.peek().val;
        for(int i=k; i<n; i++){
            while(pq.size()> 0 && pq.peek().idx <=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(nums[i], i));
            res[i-k+1] =pq.peek().val;
        }
        return res;
    }
}