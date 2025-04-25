class Solution {
    Integer[] memo;

    public int numDecodings(String s) {
        memo = new Integer[s.length() + 1];
        Arrays.fill(memo, -1);
        return solve(0, s);
    }

    public int solve(int index, String s) {
        if (index == s.length())
            return 1;
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (memo[index] != -1)
            return memo[index];
        int pick1 = solve(index + 1, s);
        int pick2 = 0;
        if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            pick2 = solve(index + 2, s);
        }
        memo[index] = pick1 + pick2;
        return memo[index];
    }

}
