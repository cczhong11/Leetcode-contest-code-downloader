class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }
        int m = A.length;
        int n = B.length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) {
                    dp[i+1][j+1] = dp[i][j]+1;
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        
        return res;
    }
}