public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = i - j < 2 ? s.charAt(j) == s.charAt(i) : s.charAt(j) == s.charAt(i) && dp[j+1][i-1];
                if(dp[j][i]) cnt++;
            }
        }
        return cnt;
    }
}