class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(n, 0, 0, current, res);
        return res;
    }

    
    private void backtrack(int n, int openN, int closeN, StringBuilder current, List<String> res) {
        if (openN == n && closeN == n) {
            res.add(current.toString());
            return;
        }

        if (openN < n) {
            current.append("(");
            backtrack(n, openN + 1, closeN, current, res);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (closeN < openN) {
            current.append(")");
            backtrack(n, openN, closeN + 1, current, res);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}