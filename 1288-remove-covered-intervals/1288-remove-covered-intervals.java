class Solution {
    public int removeCoveredIntervals1(int[][] intervals) {
        int n=intervals.length;
       List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->{
            if(a[0] != b[0]){
                  return a[0] - b[0];
            }
             return b[1] - a[1];
        });
        result.add(intervals[0]);
        for(int i=1; i<n; i++){
            int[] last = result.get(result.size() - 1);
            if(last[0] <= intervals[i][0] && last[1] >= intervals[i][1]){
                continue;
            }
            result.add(intervals[i]);
        }
        return result.size();
    }

     public int removeCoveredIntervals(int[][] intervals) {
      int n=intervals.length;
        Arrays.sort(intervals, (a,b)->{
            if(a[0] != b[0]){
                  return a[0] - b[0];
            }
             return b[1] - a[1];
        });
        int count =1;
        int lastIntervalEndPt=intervals[0][1];
        for(int i=1; i<n ;i++){
            if(lastIntervalEndPt >= intervals[i][1]) continue;
            lastIntervalEndPt =intervals[i][1];
            count++;
        }
        return count;
     }
}