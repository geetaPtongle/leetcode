class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        //Approch 1st using built in function
        // for(int i=0; i<n+1; i++){
        //     ans[i]=Integer.bitCount(i);
        // }

        
        if (n == 0)
            return ans;

        ans[1] = 1;
        //Approch 2nd
        // for (int i = 2; i < n + 1; i++) {
        //     if (i % 2 == 0) {
        //         ans[i] = ans[i / 2];
        //     } else {
        //         ans[i] = ans[i / 2] + 1;
        //     }
        // }

        //Approch 3nd
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

// Pseudocode Steps (in plain English):
// Create an array ans of size n+1 to store the answer for each number from 0 to n.

// Set ans[0] = 0 because 0 in binary is 0, which has 0 ones.

// For every number i from 1 to n:

// Think of i in binary.

// Get the result of i / 2 using i >> 1. This gives a number that we've already solved earlier.

// Check if the last bit of i is 1 or 0 using (i & 1).

// If it's 1, it means i is odd → so we need to add 1 more '1' to the count from i / 2.

// If it's 0, then no need to add anything extra.

// Add the values and store the result in ans[i].

// After the loop, return the ans array.