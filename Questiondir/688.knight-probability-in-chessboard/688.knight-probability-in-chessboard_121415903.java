class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        // what is the probability that the knight is at (x, y) after m moves
        double[][][] probability = new double[N][N][K+1];
        probability[r][c][0] = 1;
        int[][] offsets = new int[][] {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        for (int move = 1; move <= K; move++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] offset : offsets) {
                        if (i + offset[0] >= 0 && i + offset[0] < N && j + offset[1] >= 0 && j + offset[1] < N) {
                            probability[i][j][move] += (probability[i + offset[0]][j + offset[1]][move-1] / offsets.length);
                        }
                    }
                }
            }
        }
        double onboardProbability = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                onboardProbability += probability[i][j][K];
            }
        }
        return onboardProbability;
    }
}