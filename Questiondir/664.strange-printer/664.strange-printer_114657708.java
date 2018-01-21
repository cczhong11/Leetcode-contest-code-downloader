class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        Integer [][][]dp = new Integer[n][n][27];
        int ans = dfs(s, 0, n - 1, 26, dp);
        return ans;
    }
    private int dfs(String str, int s, int e, int col, Integer[][][] dp) {
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return (str.charAt(s) - 'a') == col ? 0 : 1;
        }
        if (dp[s][e][col] != null) {
            return dp[s][e][col];
        }
        int sc = str.charAt(s) - 'a';
        int ec = str.charAt(e) - 'a';
        int ans = e - s + 10;
        for (int i = s; i <= e; i++) if (str.charAt(i)-'a' == sc) {
            ans = Math.min(ans, dfs(str, s + 1, i - 1, sc, dp) + (sc == col ? 0 : 1) + dfs(str, i + 1, e, col, dp));
        }
        dp[s][e][col] = ans;
        return ans;
    }
}