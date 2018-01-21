class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int length = 0;
        for(int i = 0; i < A.length; ++ i) {
            for(int j = 0; j < B.length; ++ j) {
                if(i == 0 || j == 0) {
                    dp[i][j] = A[i] == B[j] ? 1 : 0;
                }
                else {
                    dp[i][j] = A[i] == B[j] ? dp[i-1][j-1] + 1 : 0;
                }
                length = Math.max(length, dp[i][j]);
            }
        }
        return length;
    }
}