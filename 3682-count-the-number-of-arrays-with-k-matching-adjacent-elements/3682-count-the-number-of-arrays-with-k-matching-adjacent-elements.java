class Solution {
    static final int mod = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        long ans = m;
        ans = (ans * modPow(m - 1, n - k - 1)) % mod;
        ans = (ans * comb(n - 1, k)) % mod; // corrected: combination index was wrong
        return (int) ans;
    }

    long modPow(long x, int exp) {
        long result = 1;
        x = x % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * x) % mod;
            x = (x * x) % mod;
            exp >>= 1;
        }
        return result;
    }

    long comb(int n, int k) {
        if (k > n) return 0;
        if (n - k < k) k = n - k;
        long num = 1, den = 1;
        for (int i = 1; i <= k; i++) {
            num = (num * (n - i + 1)) % mod;
            den = (den * i) % mod;
        }
        return (num * modInverse(den)) % mod;
    }

    long modInverse(long a) {
        return modPow(a, mod - 2); // Fermat's Little Theorem, since mod is prime
    }
}
