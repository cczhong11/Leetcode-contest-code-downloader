class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][][] dp = new int[N][N][N][N];
        dp[0][0][0][0] = grid[0][0];

     /*   ArrayList<Integer[]> toVisit = new ArrayList<>();
        if (grid[0][0] >= 0) {
            toVisit.add(new int[]{0,0,0,0});
        }
        while (!toVisit.isEmpty()) {
            int[] coords = toVisit.remove(0);
            int r1 = coords[0], c1 = coords[1], r2 = coords[2], c2 = coords[3];
            if (grid[r1][c1] == 1 )
        } */
        for (int n = 1; n <= 2 * (N - 1); n++) {
            for (int r1 = 0; r1 <= n; r1++) {
                if (r1 >= N)
                    continue;
                int c1 = n - r1;
                if (c1 >= N)
                    continue;
                for (int r2 = 0; r2 <= n; r2++) {
                    if (r2 >= N)
                        continue;
                    int c2 = n - r2;
                    if (c2 >= N)
                        continue;
                    if (grid[r1][c1] < 0 || grid[r2][c2] < 0) {
                        dp[r1][c1][r2][c2] = -1;
                        continue;
                    }
                    
                    int m = -1;
                    if (r1 > 0) {
                        if (r2 > 0)
                            m = Math.max(m, dp[r1-1][c1][r2-1][c2]);
                        if (c2 > 0)
                            m = Math.max(m, dp[r1-1][c1][r2][c2-1]);
                    }
                    if (c1 > 0) {
                        if (r2 > 0)
                            m = Math.max(m, dp[r1][c1-1][r2-1][c2]);
                        if (c2 > 0)
                            m = Math.max(m, dp[r1][c1-1][r2][c2-1]);
                    }
                    if (m < 0) {
                        dp[r1][c1][r2][c2] = -1;
                    } else {
                        dp[r1][c1][r2][c2] = m + grid[r1][c1] + (r1 == r2 && c1 == c2 ? 0 : grid[r2][c2]);
                    }
                }
            }
        }
        return dp[N-1][N-1][N-1][N-1] < 0 ? 0 : dp[N-1][N-1][N-1][N-1];
    }
}