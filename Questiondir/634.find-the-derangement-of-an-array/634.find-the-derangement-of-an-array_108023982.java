public class Solution {
    long dp[];
    long MOD = 1000000007;
    
    public int findDerangement(int n) {
        dp = new long [n + 3];
        dp[2] = 1;
        
        for (int i = 3; i <= n; i ++) {
            long res = (i - 1) * (dp[i - 1] + dp[i - 2]);
            dp[i] = res % MOD;
        }
        
        return (int) dp[n];
    }
    
}