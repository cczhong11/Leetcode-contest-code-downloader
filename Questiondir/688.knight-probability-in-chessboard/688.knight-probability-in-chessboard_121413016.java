class Solution {
    int[] dr = {-2,-2,-1,-1,1,1,2,2};
    int[] dc = {-1,1,-2,2,-2,2,-1,1};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) dp[i][j][0] = 0.0;
        dp[r][c][0] = 1;
        for (int l = 1; l <= K; l++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double prob = 0.0;
                    for (int m = 0; m < 8; m++) {
                        if (i + dr[m] >= 0 && i + dr[m] < N && j + dc[m] >= 0 && j + dc[m] < N) {
                            prob += dp[i + dr[m]][j + dc[m]][l - 1] * 0.125;
                        }
                    }
                    dp[i][j][l] = prob;
                }
            }
        }
        double res = 0.0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                res += dp[i][j][K];
        return res;
    }
}