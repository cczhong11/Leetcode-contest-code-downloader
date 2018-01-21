class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 0; i <= m; i++) {
        	for (int j = 0; j <= n; j++) {
        		if (i == 0 || j == 0) dp[i][j] = 0;
        		else if (A[i - 1] == B[j - 1]) {
        			dp[i][j] = dp[i - 1][j - 1] + 1;
        			res = Math.max(dp[i][j], res);
        		}
        		else dp[i][j] = 0;
        	}
        }
        return res;
    }
}