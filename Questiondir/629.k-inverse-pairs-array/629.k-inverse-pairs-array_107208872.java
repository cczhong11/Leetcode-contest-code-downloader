import java.util.Arrays;

public class Solution {
    public static final long MOD = (long) (1e9 + 7);
    public int kInversePairs(int n, int k) {
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            long[] sum = new long[k + 2];
            for (int j = 0; j <= k; j++) {
                sum[j + 1] = (sum[j] + dp[j]) % MOD;
            }
            long[] newDp = new long[k + 1];
            for (int j = 0; j <= k; j++) {
                newDp[j] = sum[j + 1];
                int stop = Math.max(j - i + 1, 0);
                newDp[j] -= sum[stop];
                newDp[j] %= MOD;
                if (newDp[j] < 0) {
                    newDp[j] += MOD;
                }
            }
            dp = newDp;
//            System.out.println("i = " + i);
//            System.out.println("dp = " + Arrays.toString(dp));
        }
        return (int) dp[k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kInversePairs(2, 2));
    }
}