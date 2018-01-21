class Solution {
    public int findLength(int[] A, int[] B) {
        int na = A.length, nb = B.length;
        int[][] dp = new int[na+1][nb+1];
        for(int i=0;i<=na;i++) dp[i][0] = 0;
        for(int i=1;i<=nb;i++) dp[0][i] = 0;
        
        int ret = 0;
        for(int i=1;i<=na;i++) for(int j=1;j<=nb;j++) {
            dp[i][j] = 0;
            if(A[i-1]!=B[j-1]) continue;
            dp[i][j] = dp[i-1][j-1] + 1;
            ret = Math.max(ret, dp[i][j]);
        }
        return ret;
    }
}