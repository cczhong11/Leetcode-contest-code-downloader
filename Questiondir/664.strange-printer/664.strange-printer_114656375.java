class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int[][][] dp = new int[len][len][27];
        for (int i = 0; i < len; i++) for (int x = 0; x < 27; x++) {
            int ch = s.charAt(i) - 'a' + 1;
            dp[i][i][x] = (ch == x) ? 0 : 1;
        }
        
        for (int k = 1; k < len; k++) {
            for (int i = 0; i + k < len; i++) {
                int ch = s.charAt(i) - 'a' + 1;
                for (int x = 0; x < 27; x++) {
                    int val = 10000000;
                    if (ch == x) {
                        val = Math.min(val, dp[i+1][i+k][x]);
                    }
                    
                    for (int plen = 1; plen <= k + 1; plen++) {
                        int a = plen == 1 ? 0 : dp[i+1][i + plen-1][ch];
                        int b = plen <= k ? dp[i+plen][i+k][x] : 0;
                        val = Math.min(val, 1 + a + b);
                    }
                    dp[i][i+k][x] = val;
                }

            }
        }

        return dp[0][len-1][0];

    }
}