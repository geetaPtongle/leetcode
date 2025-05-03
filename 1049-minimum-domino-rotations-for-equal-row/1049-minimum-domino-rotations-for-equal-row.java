class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result= Integer.MAX_VALUE;
        for(int i=1; i<= 6; i++){
            int steps = find(tops, bottoms, i);
            if(steps !=-1){
                result=Math.min(result, steps);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public int find(int[] tops, int[]bottoms, int val){
        int swapTop=0, swapBottom=0;
        for(int i=0; i<tops.length; i++){
            if(tops[i] != val && bottoms[i] != val){
                return -1;
            }else if(tops[i] != val){
                swapTop++;
            }else if(bottoms[i] != val){
                swapBottom++;
            }
        }
        return Math.min(swapTop, swapBottom);
    }
}