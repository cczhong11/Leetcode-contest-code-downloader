public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        return gao(A, B);
    }
    private List<Integer> gao(int[] a, int b) {
        List<Integer> ans = new ArrayList<>();
        int n = a.length;
        if (a[n - 1] == -1) return ans;
        int[] dp = new int[n];
        dp[n - 1] = a[n - 1];
        Integer[] next = new Integer[n];
        next[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= b && i + j < n; j++) {
                if (a[i + j] == -1) continue;
                if (next[i + j] == null) continue;
                if (next[i] == null || dp[i + j] + a[i] < dp[i]) {
                    dp[i] = dp[i + j] + a[i];
                    next[i] = i + j;
                }
            }
        }
        if (next[0] != null) {
            for (int i = 0; i != -1; i = next[i]) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}