public class Solution {
    public int findDerangement(int n) {
        long[] ans = new long[n + 10];
        ans[1] = 0;
        ans[2] = 1;
        long MOD = 1000000007;
        
        for (int i = 3; i <= n; i++)
            ans[i] = ((ans[i - 1] + ans[i - 2]) * (i - 1)) % MOD;
        return (int)ans[n];
    }
}