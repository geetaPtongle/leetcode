class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X=0;
        for(String ch: operations)
        X +=ch.contains("+")? 1: -1;

        return X;
    }
}