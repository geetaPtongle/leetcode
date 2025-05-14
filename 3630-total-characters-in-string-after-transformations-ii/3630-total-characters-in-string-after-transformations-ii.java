class Solution {
 final int SIZE = 26;
     final long MOD = 1_000_000_007;
    // public int lengthAfterTransformations1(String s, int t, List<Integer> nums) {
    //     for (int i = 0; i < t; i++) {
    //         StringBuilder new_s = new StringBuilder();
    //         for (char c : s.toCharArray()) {
    //             int count = nums.get(c - 'a');
    //             for (int j = 1; j <= count; j++) {
    //                 char next_char = (char)((c - 'a' + j) % 26 + 'a');
    //                 new_s.append(next_char);
    //             }
    //         }
    //         s = new_s.toString();
    //     }
    // return  s.length() % mod;
    // }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] T = new long[SIZE][SIZE];

        // Build transition matrix
        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                T[i][(i + j) % SIZE]++;
            }
        }

        // Matrix exponentiation
        long[][] T_exp = matrixPower(T, t);

        // Frequency array
        long[] freq = new long[SIZE];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Multiply frequency with T_exp
        long total = 0;
        for (int j = 0; j < SIZE; j++) {
            long sum = 0;
            for (int i = 0; i < SIZE; i++) {
                sum = (sum + freq[i] * T_exp[i][j]) % MOD;
            }
            total = (total + sum) % MOD;
        }

        return (int)total;
    }

    // Matrix exponentiation
    private long[][] matrixPower(long[][] matrix, int power) {
        long[][] result = new long[SIZE][SIZE];

        // Initialize result as identity matrix
        for (int i = 0; i < SIZE; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrix(result, matrix);
            }
            matrix = multiplyMatrix(matrix, matrix);
            power >>= 1;
        }

        return result;
    }

    // Multiply two matrices
    private long[][] multiplyMatrix(long[][] A, long[][] B) {
        long[][] res = new long[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    res[i][j] = (res[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}