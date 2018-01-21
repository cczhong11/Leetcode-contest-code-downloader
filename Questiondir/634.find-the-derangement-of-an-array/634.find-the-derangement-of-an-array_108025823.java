public class Solution {
     private static long mod = 1000000007;
    public int findDerangement(int n) {
        if (n <= 1) {
            return 0;
        }
        long []dp = new long[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (((dp[i - 1] % mod + dp[i - 2] % mod) % mod) * (i - 1) % mod) % mod;
        }
        return (int)dp[n];
    }
}