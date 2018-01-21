public class Solution {
    private static final int MOD = 10000_0000_0 + 7;
    
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            int t = ch - '0';
            if (ch == '*') {
                dp[i] = mul(dp[i - 1], 9);
                if (i > 1) {
                    char prev = s.charAt(i - 2);
                    if (prev == '*') {
                        dp[i] = add(mul(dp[i - 2], 15), dp[i]);
                    } else {
                        int x = s.charAt(i - 2) - '0';
                        if (x == 1) dp[i] = add(mul(dp[i - 2], 9), dp[i]);
                        if (x == 2) dp[i] = add(mul(dp[i - 2], 6), dp[i]);
                    }
                }
            } else {
                if (ch != '0') dp[i] = dp[i - 1];
                if (i > 1) {
                    char prev = s.charAt(i - 2);
                    if (prev == '*') {
                        if (t <= 6) dp[i] = add(mul(dp[i - 2], 2), dp[i]);
                        else dp[i] = add(dp[i - 2], dp[i]);
                    } else if (prev != '0') {
                        int x = Integer.valueOf(s.substring(i - 2, i));
                        if (x <= 26) dp[i] = add(dp[i - 2], dp[i]);
                    }
                }
            }
        }
        return dp[n];
    }

    private int mul(int a, int b) {
        long l = 1l * a * b;
        return (int) (l % MOD);
    }

    private int add(int a, int b) {
        return (a + b) % MOD;
    }
}