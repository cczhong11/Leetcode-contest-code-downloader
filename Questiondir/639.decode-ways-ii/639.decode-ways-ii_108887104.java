public class Solution {
    public int numDecodings(String s) {
        long[] dp = new long[s.length()];
        long mod = 1000000000 + 7;
        for (int i = 0; i < dp.length; i++) {
            char cur = s.charAt(i);
            if (cur == '*') {
                if (i == 0) dp[i] = 9;
                else {
                    dp[i] += dp[i - 1] * 9;
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '*') {
                        if (i > 1) dp[i] += dp[i - 2] * 9;
                        else dp[i] += 9;
                    }
                    if (s.charAt(i - 1) == '2' || s.charAt(i - 1) == '*') {
                        if (i > 1) dp[i] += dp[i - 2] * 6;
                        else dp[i] += 6;
                    }
                }

            } else {
                if (i == 0) {
                    if (cur == '0') return 0;
                    dp[i] = 1;
                }
                else if (cur == '0') {
                    if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2' && s.charAt(i - 1) != '*') return 0; 
                    if (i > 1) {
                        if (s.charAt(i - 1) == '*') dp[i] = dp[i - 2] * 2;
                        else dp[i] = dp[i - 2];
                    }
                    else {
                        if (s.charAt(i - 1) == '*') dp[i] = 2;
                        else dp[i] = 1;
                        
                    }
                }
                else {
                    dp[i] += dp[i - 1];
                    if ((s.charAt(i - 1) == '1' || s.charAt(i - 1) == '*')) {
                        if (i > 1) dp[i] += dp[i - 2];
                        else dp[i] += 1;
                    }
                    if ((s.charAt(i - 1) == '2' || s.charAt(i - 1) == '*') && cur < '7') {
                        if (i > 1) dp[i] += dp[i - 2];
                        else dp[i] += 1;
                    }
                }
            }
            dp[i] %= mod;
        }
        return (int) (dp[dp.length - 1]%mod);
    }
}