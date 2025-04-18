//Using simple backtracking
//T.C : O(2^n) where n is the total number of words
//S.C : O(n)
class Solution {
    int maxScore = Integer.MIN_VALUE;
    int n;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        n = words.length;
        //Calculate frequncy of latters
        for (char ch : letters) {
            freq[ch - 'a']++;
        }

        solve(0, score, words, 0, freq);
        return maxScore;
    }

    public void solve(int idx, int[] score, String[] words, int currScore, int[] freq) {
        maxScore = Math.max(maxScore, currScore);
        if (idx >= n)
            return;

        int i = 0;
        int tempScore = 0;
        int[] tempFreq = Arrays.copyOf(freq, freq.length);

        while (i < words[idx].length()) {
            char ch = words[idx].charAt(i);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            i++;
        }

        if (i == words[idx].length())
            solve(idx + 1, score, words, currScore + tempScore, tempFreq);

        solve(idx + 1, score, words, currScore, freq);
    }
}