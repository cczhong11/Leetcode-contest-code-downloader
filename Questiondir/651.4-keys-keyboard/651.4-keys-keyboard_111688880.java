public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int max = dp[i - 1] + 1;
            for (int j = i - 3; j >= 1; j--) {
                max = Math.max(max, dp[j] * (i - j - 1));
            }
            dp[i] = max;
        }
        return dp[N];
    }
}