class Solution {
    public int strangePrinter(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        if (n <= 1) return n;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (ch[i] == ch[j]) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]);
                } else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}