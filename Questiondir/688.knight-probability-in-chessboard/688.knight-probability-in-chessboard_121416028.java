class Solution {
    int N;
    int[] dX = {-2,-2,-1,-1,+1,+1,+2,+2};
    int[] dY = {-1,+1,-2,+2,-2,+2,-1,+1};
    
    double[][][] _d = new double[26][26][101];
    double remains(int x, int y, int k) {
        if (0 <= x && x < N && 0 <= y && y < N) {
            // remains
            if (k == 0) return 1.0;
            // 8 moves
            if (_d[x][y][k] == -1) {
                double result = 0.0;
                for (int i = 0; i < 8; i++) {
                    result += 0.125 * remains(x + dX[i], y + dY[i], k-1);
                } 
                _d[x][y][k] = result;
            }
            return _d[x][y][k];
        } else {
            return 0.0;
        }
    }
    
    public double knightProbability(int _N, int K, int r, int c) {
        N = _N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <= K; k++) {
                    _d[i][j][k] = -1;
                }
            }
        }
        return remains(r,c, K);
    }
}