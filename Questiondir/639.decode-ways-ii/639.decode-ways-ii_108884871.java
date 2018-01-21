import java.util.Arrays;

public class Solution {
    private static final long MOD = (long) (1e9 + 7);

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            dp[i + 1] += dp[i] * getWays(s.charAt(i));
            dp[i + 1] %= MOD;
            if (i >= 1) {
                dp[i + 1] += dp[i - 1] * getWays(s.substring(i - 1, i + 1));
                dp[i + 1] %= MOD;
            }
        }
//        System.out.println("dp = " + Arrays.toString(dp));
        return (int) dp[n];
    }

    private long getWays(String s) {
        if (s.charAt(0) == '*') {
            if (s.charAt(1) == '*') {
                return 15;
            } else if (s.charAt(1) <= '6') {
                return 2;
            } else {
                return 1;
            }
        } else {
            if (s.charAt(1) == '*') {
                if (s.charAt(0) == '1') {
                    return 9;
                } else if (s.charAt(0) == '2') {
                    return 6;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(0) == '0') {
                    return 0;
                }
                int a = Integer.parseInt(s);
                return a >= 10 && a <= 26 ? 1 : 0;
            }
        }
    }

    private long getWays(char c) {
        if (c == '*') {
            return 9;
        }
        if (c == '0') {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("*10*1"));
    }
}