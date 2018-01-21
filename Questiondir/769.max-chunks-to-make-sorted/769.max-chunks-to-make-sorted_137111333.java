class Solution {
    public int maxChunksToSorted(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0] == 0 ? 1 : -1;
        boolean flag[] = new boolean[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int ans = -1;
            for (int k = i; k >= 0; k--) {
                if (k > 0 && dp[k-1] < 0) continue;
                
                Arrays.fill(flag, false);
                boolean ok = true;
                for (int x = k; x <= i; x++) {
                    int v = arr[x];
                    if (v < k || v > i || flag[v]) {
                        ok = false;
                        break;
                    }
                    flag[v] = true;
                }
                
                if (ok) {
                    int tmp = k == 0 ? 1 : dp[k-1] + 1;
                    ans = Math.max(ans, tmp);
                }
            }
            dp[i] = ans;
        }
        
        return dp[arr.length-1];
    }
}