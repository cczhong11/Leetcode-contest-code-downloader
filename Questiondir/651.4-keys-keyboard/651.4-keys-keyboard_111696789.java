public class Solution {
    public int maxA(int N) {
        if (N <= 2) return N;
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = i + 1;
            for (int j = 0; j <= i - 2; ++j) {
                dp[i] = Math.max(dp[i], dp[i - j - 2] * (j + 1));
            }
            // System.out.print(i + ":" + dp[i] + " ");
        }
        return dp[N - 1];
    }
}