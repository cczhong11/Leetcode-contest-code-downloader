class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int dir[][] = {{-2,-1}, {-1,-2}, {1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};

        double p[][][] = new double[2][N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
            p[0][i][j] = 0;
            p[1][i][j] = 0;
        }
        p[0][r][c] = 1;

        for (int k = 0; k < K; k++) {
            int cur = k%2;
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
                p[1-cur][i][j] = 0;
            }

            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
                if (p[cur][i][j] > 0) {
                    for (int x = 0; x < 8; x++) {
                        int nr = i + dir[x][0];
                        int nc = j + dir[x][1];
                        if (nr >=0 && nr < N && nc >=0 && nc < N) {
                            p[1-cur][nr][nc] += p[cur][i][j] / 8;
                        }
                    }

                }
            }
        }
        
        double res = 0;
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) {
            res += p[K%2][i][j];
        }

        return res;
    }
}