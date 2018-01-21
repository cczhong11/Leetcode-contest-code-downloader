public class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int numDecodings(String s) {
        if(s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        
        char c = s.charAt(0);
        long[] count = new long[4];
        count[1] = 0;
        if(c == '*') {
            count[0] = 9;
            count[2] = count[3] = 1;
        } else {
            count[0] = 1;
            count[2] = count[3] = 0;
            if(c == '1') {
                count[2] = 1;
            } else if(c == '2') {
                count[3] = 1;
            }
        }
        
        for(int i=1; i<s.length(); i++) {
            count = decode(s.charAt(i), count);
        }
        
        return (int) ((count[0] + count[1]) % MOD);
    }

    public long[] decode(char next, long[] cur) {
        long single = 0, consecutive = 0, one = 0, two = 0;
        if (next == '*') {
            single = (cur[0] + cur[1]) * 9;
            one = cur[0] + cur[1];
            two = cur[0] + cur[1];
            consecutive = cur[2] * 9 + cur[3] * 6;
        } else {
            if(next == '0') {
                single = one = two = 0;
                consecutive = cur[2] + cur[3];
            } else {
                single = cur[0] + cur[1];
                if (next <= '6') {
                    consecutive = cur[2] + cur[3];
                    if (next == '1') {
                        one = cur[0] + cur[1];
                    } else if (next == '2') {
                        two = cur[0] + cur[1];
                    }
                } else {
                    consecutive = cur[2];
                }
            }
        }

        return new long[] { single % MOD, consecutive % MOD, one % MOD, two % MOD };
    }
}