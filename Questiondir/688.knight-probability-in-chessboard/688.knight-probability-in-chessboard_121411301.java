class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[2][N][N];
        dp[0][r][c] = 1;
        for (int k=1, idx=1; k<=K; k++, idx=1-idx) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    dp[idx][i][j] = 0;
                    int[][] prevs = {{i-1, j-2}, {i+1, j-2}, {i-2, j-1}, {i+2, j-1},
                                   {i-2, j+1}, {i+2, j+1}, {i-1, j+2}, {i+1, j+2}};
                    for (int[] prev : prevs) {
                        if (prev[0] < 0 || prev[1] < 0 || prev[0] >= N || prev[1] >= N) {
                            continue;
                        }
                        dp[idx][i][j] += dp[1-idx][prev[0]][prev[1]];
                    }
                }
            }
        }
        double sum = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sum += dp[K%2][i][j];
            }
        }
        return sum/Math.pow(8.0, K);
    }
}