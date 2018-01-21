public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i=2; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=1; j*2<=i; j++) {
                if (0 == i%j) {
                    dp[i] = Math.min(dp[i], dp[j]+i/j);
                }
            }
        }
        return dp[n];
    }
}