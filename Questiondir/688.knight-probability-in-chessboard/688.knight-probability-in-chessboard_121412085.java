class Solution {
 	public double knightProbability(int N, int K, int r, int c) {
		if (K == 0) return 1.0;
		
		double[][][] dp = new double[N][N][K + 1];
		
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j][0] = 1;
			}
		}
		
		for (int k = 1; k <= K; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int l = 0; l < 8; l++) {
						int x = i + dx[l];
						int y = j + dy[l];
						
						if (!(x >= 0 && x < N && y >= 0 && y < N)) {
							continue;
						}
						dp[i][j][k] += dp[x][y][k - 1];
					}
				}
			}
		}
		return dp[r][c][K] / Math.pow(8.0, K * 1.0);
	}
}