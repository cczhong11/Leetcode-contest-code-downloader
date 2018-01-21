import java.util.Arrays;

public class Solution {
	final static int MOD = (int)(1e9 + 7);
	int[][] dp;

	int solve(int n, int k) {
		if (k < 0 || n < 0) return 0;
		if (n * (n - 1) / 2 < k) return 0;
		if (k == 0) return 1;
		if (dp[n][k] >= 0) return dp[n][k];
		int res = 0;
		res += solve(n - 1, k);
		if (res >= MOD) res -= MOD;
		res += solve(n, k - 1);
		if (res >= MOD) res -= MOD;
		res -= solve(n - 1, k - n);
		if (res < 0) res += MOD;
		dp[n][k] = res;
		return res;
	}
	
    public int kInversePairs(int n, int k) {
        dp = new int[n + 1][k + 1];
        for (int[] d : dp) {
        	Arrays.fill(d, -1);
        }
        return solve(n, k);
    }
}