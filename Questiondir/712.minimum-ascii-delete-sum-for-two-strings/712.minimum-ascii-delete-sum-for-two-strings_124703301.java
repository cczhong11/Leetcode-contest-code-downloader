class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] items : dp) {
            Arrays.fill(items, -1);
        }
        return help(s1, s2, 0, 0, dp);
    }
    public int help(String s1, String s2, int i1, int i2, int[][] dp) {
        int res = 0;
        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        if (i1 == s1.length() && i2 == s2.length()) {
            return res;
        } else if (i1 == s1.length() || i2 == s2.length()) {
            if (i1 < s1.length()) {
                for (int i = i1; i < s1.length(); i++) {
                    res += (int)s1.charAt(i);
                }
            }
            if (i2 < s2.length()) {
                for (int i = i2; i < s2.length(); i++) {
                    res += (int)s2.charAt(i);
                }
            }
            dp[i1][i2] = res;
            return res;
        }
        if (s1.charAt(i1) == s2.charAt(i2)) {
            res = help(s1, s2, i1 + 1, i2 + 1, dp);
        } else {
            res = Math.min(help(s1, s2, i1 + 1, i2, dp) + (int)s1.charAt(i1),
                            help(s1, s2, i1, i2 + 1, dp) + (int)s2.charAt(i2));
        }
        dp[i1][i2] = res;
        return res;
    }
}