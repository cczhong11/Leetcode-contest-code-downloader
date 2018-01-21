class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, max = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}