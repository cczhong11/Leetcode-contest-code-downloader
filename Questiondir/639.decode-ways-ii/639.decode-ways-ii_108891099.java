public class Solution {
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                dp[i] = dp[i + 1] * 9;
                dp[i] %= 1000000007;
                if (i < s.length() - 1) {
                    if (s.charAt(i + 1) == '*') {
                        dp[i] += dp[i + 2] * (9 + 6);
                    }
                    else if (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6') {
                        dp[i] += dp[i + 2] * 2;
                    }
                    else {
                        dp[i] += dp[i + 2];
                    }
                    dp[i] %= 1000000007;
                }
            }
            else if (s.charAt(i) == '0') {
                dp[i] = 0;
            }
            else if (s.charAt(i) == '1') {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1) {
                    if (s.charAt(i + 1) == '*') {
                        dp[i] += dp[i + 2] * 9;
                    }
                    else {
                        dp[i] += dp[i + 2];
                    }
                    dp[i] %= 1000000007;
                }
            }
            else if (s.charAt(i) == '2') {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1) {
                    if (s.charAt(i + 1) == '*') {
                        dp[i] += dp[i + 2] * 6;
                    }
                    else if (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6') {
                        dp[i] += dp[i + 2];
                    }
                }
                dp[i] %= 1000000007;
            }
            else {
                dp[i] = dp[i + 1];
            }
            //System.out.println(i + " " + dp[i]);
        }
        return (int)dp[0];
    }
}