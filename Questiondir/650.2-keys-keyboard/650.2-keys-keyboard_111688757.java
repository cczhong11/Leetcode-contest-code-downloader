public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1000];
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++) {
            dp[i] = i;
            for(int j = 2; j <= i / 2; j++) {
                if(i % j == 0) {
                    dp[i] = Math.min(dp[i], (i / j) + dp[j]);
                }
            }
        }
        return dp[n];
    }
}