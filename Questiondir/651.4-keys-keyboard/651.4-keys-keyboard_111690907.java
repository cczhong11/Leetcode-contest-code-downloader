public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 100];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for(int i = 6; i <= N; i++) {
            dp[i] = i;
            for(int j = 0; j <= i - 3; j++) {
                int count = dp[j] * (((i - j) - 1));
                dp[i] = Math.max(dp[i], count);
            }
        }
        return dp[N];
    }
}