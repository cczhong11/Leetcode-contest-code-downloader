class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = allOnes(M, i, j, m, n);
            }
        }
        return res;
    }
    private int allOnes(int[][] a, int i, int j, int m, int n) {
        int cnt = 0;
        int sz = 0;
        for (int i1 = i - 1; i1 <= i + 1; i1++) {
            for (int j1 = j - 1; j1 <= j + 1; j1++) {
                if (i1 < 0 || i1 >= m || j1 < 0 || j1 >= n) continue;
                cnt += a[i1][j1];
                sz++;
            }
        }
        return (int)(cnt * 1.0 / sz);
    }
}