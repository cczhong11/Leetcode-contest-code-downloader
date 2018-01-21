class Solution {
    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tot = 0;
                int val = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        int x = i + dx;
                        int y = j + dy;
                        if (x < 0 || x >= n || y < 0 || y >= m) continue;
                        tot++;
                        val += M[x][y];
                    }
                }
                ans[i][j] = val / tot;
            }
        }
        return ans;
    }
}