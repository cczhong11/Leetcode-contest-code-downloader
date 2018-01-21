class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        int val = 0;
        for (int i = 0; i < n1; ++i) {
            val += s1.charAt(i);
            dp[i+1][0] = val;
        }
        val = 0;
        for (int i = 0; i < n2; i++) {
            val += s2.charAt(i);
            dp[0][i+1] = val;
        }
        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                dp[i+1][j+1] = Math.min(dp[i][j+1] + s1.charAt(i), dp[i+1][j] + s2.charAt(j));
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = Math.min(dp[i][j], dp[i+1][j+1]);
                }
            }
        }
//        for (int i = 0; i <= n1; ++i) {
//            for (int j = 0; j <= n2; ++j) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[n1][n2];
    }
}