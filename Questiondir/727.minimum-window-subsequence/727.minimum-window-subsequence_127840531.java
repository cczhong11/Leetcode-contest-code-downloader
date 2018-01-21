import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minWindow("abcdzbddf", "bde"));
    }

    String s, t;
    int[][] f;
    int inf = 1 << 29;

    public String minWindow(String S, String T) {
        s = S;
        t = T;
        f = new int[s.length() + 1][t.length() + 1];

        Arrays.fill(f[0], inf);
        f[0][0] = 0;
        for (int i = 1; i <= s.length(); i++)
            for (int j = 1; j <= t.length(); j++) {
                f[i][j] = f[i - 1][j] + 1;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
            }

        int ans = inf, tail = -1;
        for (int i = 1; i <= s.length(); i++) {
            if (f[i][t.length()] < ans) {
                ans = f[i][t.length()];
                tail = i;
            }
        }

        if (ans >= inf) return "";
        else return s.substring(tail - ans, tail);
    }

}
