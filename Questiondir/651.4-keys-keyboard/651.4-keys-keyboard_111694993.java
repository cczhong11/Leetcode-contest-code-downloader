public class Solution {
    public int maxA(int N) {
        if (N < 4) return N;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) dp[i] = i;
        for (int i = 5; i <= N; i++) {
            int n = dp[i - 3];
            int curr = n + n;
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j], curr);
                curr += n;
            }
        }
        return dp[N];
    }
}