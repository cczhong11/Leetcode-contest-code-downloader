public class Solution {
	private long[][] dp;
	private long[] sum;
	
	private long MOD = 1000000007;
	
    public int kInversePairs(int n, int k) {
     
    	dp = new long[n + 1][k + 1];
    	sum = new long[k + 1];
    	dp[1][0] = 1;
    	for (int i = 0;i <= k;i ++) {
    		sum[i] = 1;
    	}
    	for (int i = 2;i <= n;i ++) {
    		for (int j = 0;j <= k;j ++) {
    			int from = Math.max(j - (i - 1) , 0) , to = j;
    			dp[i][j] = sum[to];
    			if (from - 1 >= 0) {
    				dp[i][j] = (dp[i][j] - sum[from - 1] + MOD) % MOD;
    			}
    		}
    		for (int j = 0;j <= k;j ++) {
    			if (j == 0) {
    				sum[j] = dp[i][j];
    			} else {
    				sum[j] = (sum[j - 1] + dp[i][j]) % MOD;
    			}
    		}
    	}
    	return (int) dp[n][k];
    	
    }
}