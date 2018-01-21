import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    int mod = 1000000007;

    public int kInversePairs(int n, int k) {
        int[] f = new int[k + 1];
        int[] g = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            g[0] = f[0];
            for (int j = 1; j <= k; j++) g[j] = (f[j] + g[j - 1]) % mod;

            f[0] = 1;
            for (int j = 1; j <= k; j++) {
                // f[j] + f[j - 2] + ... + f[j - i + 1]
                f[j] = (g[j] - (j - i >= 0 ? g[j - i] : 0) + mod) % mod;
            }

//            System.out.println(Arrays.toString(f));
        }
        return f[k];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kInversePairs(3, 0));

    }
}