public class Solution {
    public int countArrangement(int N) {
        return dfs(0, N, 0);
    }
    private int dfs(int idx, int n, int state) {
        if (idx == n) {
            return 1;
        } else {
            int cnt = 0;
            
            for (int i=0; i<n; i++) {
                if (0 == (state&(1<<i)) && (0 == (i+1)%(idx+1) || 0 == (idx+1)%(i+1))) {
                    cnt += dfs(idx+1, n, state|(1<<i));
                }
            }
            return cnt;
        }
    }
}