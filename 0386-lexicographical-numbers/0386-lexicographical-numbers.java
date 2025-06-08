class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int startNum=1; startNum<=9; startNum++)
        dfs(startNum, n, ans);
        return ans;
    }
    void dfs(int curr, int n,  List<Integer> ans){
        if(curr >n) return;
        ans.add(curr);
        for(int append=0; append<=9;append++){
            int newNum=(curr *10)+append;
            if(newNum > n) return;
            dfs(newNum, n, ans);
        }
    }
}