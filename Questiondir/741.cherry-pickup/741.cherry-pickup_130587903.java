class Solution {
	public int cherryPickup(int[][] grid) {
		int n = grid.length;
		if (grid[0][0] < 0 || grid[n - 1][n - 1] < 0)
			return 0;
		if (n == 0)
			return 0;
		int[][][][] dp = new int[n][n][n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
						dp[i][j][k][l] = -10;
					}
				}
			}
		}
		dp[0][0][0][0] = grid[0][0];

		int ans = dfsDP(n - 1, n - 1, n - 1, n - 1, dp, grid);
		if (ans < 0)
			return 0;
		else
			return ans;

	}

	int dfsDP(int x0, int y0, int x1, int y1, int[][][][] dp, int[][] grid) {
		int n = grid.length;
		if (!((x0 >= 0 && x0 < n) && (y0 >= 0 && y0 < n) && (x1 >= 0 && x1 < n) && (y1 >= 0 && y1 < n))) {
			return -1;
		}
		// System.out.println("x0 = " + x0 + " y0 = " + y0 + " x1 = " + x1 + " y1 = " +
		// y1);
		if (grid[x0][y0] < 0 || grid[x1][y1] < 0)
			return -1;
		if (dp[x0][y0][x1][y1] != -10)
			return dp[x0][y0][x1][y1];

		dp[x0][y0][x1][y1] = -1;
		int sum = 0;
		if (x0 == x1 && y0 == y1) {
			sum += grid[x0][y0];
		} else {
			sum += grid[x0][y0] + grid[x1][y1];
			;
		}
		int t = dfsDP(x0 - 1, y0, x1 - 1, y1, dp, grid);
		if (t >= 0)
			dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

		t = dfsDP(x0 - 1, y0, x1, y1 - 1, dp, grid);
		if (t >= 0)
			dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

		t = dfsDP(x0, y0 - 1, x1 - 1, y1, dp, grid);
		if (t >= 0)
			dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

		t = dfsDP(x0, y0 - 1, x1, y1 - 1, dp, grid);
		if (t >= 0)
			dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

		return dp[x0][y0][x1][y1];

	}
}