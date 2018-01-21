public class Solution {
    public static final long MOD = (long) (1e9 + 7);

    public int findDerangement(int n) {
        if (n == 0) {
            return 0;
        }
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        f[1] = 0;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = (i - 1) * g[i - 1] % MOD;
            g[i] = f[i - 1] + (i - 1) * g[i - 1] % MOD;
        }
        return (int) f[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDerangement(4));
    }
}