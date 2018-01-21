class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 1; i < n; i++) {
            if (grid[i - 1][0] == -1) grid[i][0] = -1;
            if (grid[0][i - 1] == -1) grid[0][i] = -1;
        }
        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++)
                if (grid[i - 1][j] == -1 && grid[i][j - 1] == -1) grid[i][j] = -1;
        for (int x1 = 0; x1 < n; x1++)
            for (int x2 = 0; x2 < n; x2++)
                for (int y1 = 0; y1 < n; y1++) {
                    int y2 = x1 + y1 - x2;
                    if (y2 < 0 || y2 >= n) continue;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) continue;
                    int point = 0;
                    if (x1 == x2) {
                        point = grid[x1][y1];
                    } else {
                        point = grid[x1][y1] + grid[x2][y2];
                    }
                    int max = 0;
                    if (x1 > 0 && x2 > 0) max = Math.max(max, dp[x1 - 1][x2 - 1][y1]);
                    if (y1 > 0 && x2 > 0) max = Math.max(max, dp[x1][x2 - 1][y1 - 1]);
                    if (x1 > 0 && y2 > 0) max = Math.max(max, dp[x1 - 1][x2][y1]);
                    if (y1 > 0 && y2 > 0) max = Math.max(max, dp[x1][x2][y1 - 1]);
                    dp[x1][x2][y1] = max + point;
                }
        return dp[n - 1][n - 1][n - 1];
    }
}
