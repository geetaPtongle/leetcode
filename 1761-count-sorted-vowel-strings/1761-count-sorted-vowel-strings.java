
//Time Complexity: O(n * 5) → Efficient (only 5 vowels)
// Space Complexity: O(1) → Constant space (just one array of size 5)

class Solution {
    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

     public int countVowelStrings(int n) {
        // An array to represent the counts of vowel strings for each vowel ending
        // f[0] for 'a', f[1] for 'e', f[2] for 'i', f[3] for 'o', f[4] for 'u'
        int[] vowelCounts = {1, 1, 1, 1, 1};

        // Loop over the length n times, first length is already initialized, so we start from 0 to n-2
        for (int i = 0; i < n - 1; i++) {
            // A temporary variable to keep track of the cumulative sum
            int cumulativeSum = 0;
            // This loop calculates the new counts by adding up counts from all previous vowels
            for (int j = 0; j < 5; ++j) {
                // Update cumulative sum with the current vowel count
                cumulativeSum += vowelCounts[j];
                // Update the count for the current vowel with the new cumulative sum
                vowelCounts[j] = cumulativeSum;
            }
        }
        // Sum up all the counts and return the result
        return Arrays.stream(vowelCounts).sum();
    }
}