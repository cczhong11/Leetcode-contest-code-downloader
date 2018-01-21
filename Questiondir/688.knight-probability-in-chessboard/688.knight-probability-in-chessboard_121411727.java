class Solution {
    private static int[][] DIR = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public double knightProbability(int N, int K, int r, int c) {
        Double[][][] dp = new Double[N][N][K + 1];
        return dfs(N, K, r, c, 0, dp);
    }
    private double dfs(int N, int K, int x, int y, int k, Double[][][] memo) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return 0;
        }
        if (memo[x][y][k] != null) {
            return memo[x][y][k];
        }
        if (k == K) {
            memo[x][y][k] = 1.0;
            return 1;
        }
        double ans = 0.0;
        for (int i = 0; i < 8; i++) {
            int xx = x + DIR[i][0];
            int yy = y + DIR[i][1];
            ans += 1.0 * dfs(N, K, xx, yy, k + 1, memo) / 8.0;
        }
        memo[x][y][k] = ans;
        return ans;
    }
}