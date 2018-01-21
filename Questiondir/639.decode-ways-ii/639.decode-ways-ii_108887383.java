import javax.xml.bind.SchemaOutputResolver;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int mod = 1000000007;
        int[][] f = new int[s.length()][10];
        int[] g = new int[s.length()];

        if (s.charAt(0) != '*') {
            f[0][s.charAt(0) - '0'] = 1;
        } else {
            for (int i = 1; i < 10; i++)
                f[0][i] = 1;
        }
        for (int i = 0; i < 10; i++)
            g[0] += f[0][i];

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 10; j++) {
                if (j == s.charAt(i) - '0' || (j != 0 && s.charAt(i) == '*')) {
                    if (j > 0) {
                        f[i][j] = (f[i][j] + g[i - 1]) % mod;
                    }

                    for (int k = 1; k < 3; k++) {
                        int val = k * 10 + j;
                        if (s.charAt(i - 1) - '0' == k || s.charAt(i - 1) == '*') {
                            if (val >= 1 && val <= 26) {
                                f[i][j] = (f[i][j] + (i - 2 >= 0 ? g[i - 2] : 1)) % mod;
                            }
                        }
                    }
                }

                g[i] = (g[i] + f[i][j]) % mod;
            }
        }

//        for (int[] a : f) {
//            System.out.println(Arrays.toString(a));
//        }

        return g[s.length() - 1];

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("*"));
        System.out.println(sol.numDecodings("1*"));
        System.out.println(sol.numDecodings("***"));
    }
}