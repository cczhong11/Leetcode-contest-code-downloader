class Solution {
    public int countCornerRectangles(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        int[][] dp = new int[n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (grid[i][j] == 1 && grid[i][k] == 1) dp[j][k]++;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int d = dp[j][k];
                ans += d * (d - 1) /2;
            }
        }

        return ans;
    }
}