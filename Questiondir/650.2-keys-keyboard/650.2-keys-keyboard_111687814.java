public class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) dp[i] = Integer.MAX_VALUE;
        dp[1] = 0;
        for (int i = 1; i <= n / 2; i++) {
            int j = 2 * i;
            int curr = dp[i] + 2;
            while (j <= n) {
                dp[j] = Math.min(dp[j], curr);
                j += i;
                curr++;
            }
        }
        return dp[n];
    }
}