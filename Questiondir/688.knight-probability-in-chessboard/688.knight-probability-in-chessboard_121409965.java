class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] prob = new double[K + 1][N][N];
        prob[0][r][c] = 1.0;
        
        for (int k = 1; k <= K; ++k) {
        	for (int row = 0; row < N; ++row) {
        		for (int col = 0; col < N; ++col) {
        			for (int dr = -2; dr <= 2; ++dr) {
        				for (int dc = -2; dc <= 2; ++dc) {
        					if (Math.abs(dr) + Math.abs(dc) == 3) {
        						int nrow = row + dr;
        						int ncol = col + dc;
        						if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) {
        							continue;
        						}
        						prob[k][nrow][ncol] += prob[k - 1][row][col] / 8.0; 
        					}
        				}
        			}
        		}
        	}
        }
        
        double res = 0.0;
        for (int row = 0; row < N; ++row) {
        	for (int col = 0; col < N; ++col) {
        		res += prob[K][row][col];
        	}
        }
        return res;
    }
}