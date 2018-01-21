class Solution {
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;
        int len1 = A.length, len2 = B.length;
        int[][] dp = new int[len1+1][len2+1];
        int max = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (A[i] == B[j]) {
                    dp[i+1][j+1] = dp[i][j]+1;
                    max = Math.max(dp[i+1][j+1], max);
                }
                
            }
        }
        return max;
    }
}