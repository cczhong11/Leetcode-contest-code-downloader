public class Solution {
    public int minSteps(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 0;
    for (int i = 2; i <= n; i ++){
        dp[i] = findFactorsMin(i, dp);
    }
    return dp[n];
}

private int findFactorsMin(int n, int[] dp){
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++){
        if (n % i == 0){
            min = Math.min(min, n / i + dp[i]);
        }
    }
    return min;
}
}