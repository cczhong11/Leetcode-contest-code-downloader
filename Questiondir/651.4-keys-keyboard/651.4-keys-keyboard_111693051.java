public class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; ++ i) {
            if(i <= 3) {
                dp[i] = i;
            }
            else {
                dp[i] = dp[i-1] + 1;
                for (int j = 3; j < i; ++ j) {
                    dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
                }
            }
        }
        return dp[N];
    }
}