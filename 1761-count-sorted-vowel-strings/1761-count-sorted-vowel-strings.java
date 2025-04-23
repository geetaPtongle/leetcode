class Solution {
    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

    public int countVowelStrings(int n) {
        int ans = 0;
        for (char ch : vowels) {
            ans += solve(n - 1, ch);
        }
        return ans;
    }

    public int solve(int n, int last) {
        if (n == 0) {
            return 1;
        }
        int temp = 0;
        for (char ch : vowels) {
            if (last >= ch) {
                temp += solve(n - 1, ch);
            }
        }
        return temp;
    }
}