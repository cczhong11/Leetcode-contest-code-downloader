class Solution {
	public int countCornerRectangles(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		int[][] count = new int[n][n]; // count[j][k];
		int ans = 0;
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 0)
						continue;
					for (int k = 0; k < j; k++) {
						if (grid[i][k] == 1) {
							count[j][k]++;
						}
					}
				}
			} else {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 0)
						continue;
					for (int k = 0; k < j; k++) {
						if (grid[i][k] == 0)
							continue;
						ans += count[j][k];
					}
				}

				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 0)
						continue;
					for (int k = 0; k < j; k++) {
						if (grid[i][k] == 1) {
							count[j][k]++;
						}
					}
				}
			}
		}
		return ans;
	}
}