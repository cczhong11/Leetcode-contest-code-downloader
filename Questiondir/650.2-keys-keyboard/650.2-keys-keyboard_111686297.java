public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        return helper(n, dp);
    }
    private int helper(int n, int[] dp) {
        if (n == 1) {return 0;}
        if (dp[n] != 0) {return dp[n];}
        int upper = (int)(Math.sqrt(n));
        int min = n;
        for (int i = 2; i <= upper; i++) {
            if (n % i == 0) {
                min = Math.min(min, n / i + helper(i, dp));
                min = Math.min(min, i + helper(n / i, dp));
            }
        }
        return dp[n] = min;
    }
}