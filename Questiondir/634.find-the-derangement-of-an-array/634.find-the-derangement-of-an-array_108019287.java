import java.util.Arrays;

public class Solution {
    public int findDerangement(int n) {
        int mod = 1000000007;
        long[] f = new long[n + 10];
        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % mod * (i - 1) % mod;
        }
        return (int) f[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " " + sol.findDerangement(i));
        }
    }
}