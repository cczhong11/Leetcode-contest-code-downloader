public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        long prev = 0;
        char c = s.charAt(0);
        long[][] dp = new long[s.length()][10];
        int mod = 1000000007;
        if (c == '*') {
            for (int i = 1; i < 10; i++) dp[0][i] = 1;
            prev = 9;
        } else if (c != '0') {
            dp[0][c - '0'] = 1;
            prev = 1;
        } else {
            prev = 0;
        }
        if (s.length() == 1) return (int) prev;
        c = s.charAt(1);
        long oldPrev = 1;
        if (c == '*') {
            for (int i = 1; i < 10; i++) dp[1][i] = prev;
            if (dp[0][1] != 0) {
                for (int i = 1; i < 10; i++) dp[1][i] += oldPrev;
            }
            if (dp[0][2] != 0) {
                for (int i = 1; i < 7; i++) dp[1][i] += oldPrev;
            }
        } else {
            if (c != '0') dp[1][c - '0'] = prev;
            if (dp[0][1] != 0) dp[1][c - '0'] += oldPrev;
            if (dp[0][2] != 0 && c <= '6') dp[1][c - '0'] += oldPrev;
        }
        oldPrev = prev;
        prev = 0;
        for (int i = 0; i < 10; i++) {
            prev += dp[1][i];
        }
        for (int j = 2; j < s.length(); j++) {
            c = s.charAt(j);
            if (c == '*') {
                for (int i = 1; i < 10; i++) dp[j][i] = prev;
                if (dp[j - 1][1] != 0) {
                    for (int i = 1; i < 10; i++) dp[j][i] += oldPrev;
                }
                if (dp[j - 1][2] != 0) {
                    for (int i = 1; i < 7; i++) dp[j][i] += oldPrev;
                }
            } else {
                if (c != '0') dp[j][c - '0'] = prev;
                if (dp[j - 1][1] != 0) dp[j][c - '0'] += oldPrev;
                if (dp[j - 1][2] != 0 && c <= '6') dp[j][c - '0'] += oldPrev;
            }
            oldPrev = prev;
            prev = 0;
            for (int i = 0; i < 10; i++) {
                dp[j][i] %= mod;
                prev += dp[j][i];
            }
            prev %= mod;
        }
        return (int)prev;
    }
}