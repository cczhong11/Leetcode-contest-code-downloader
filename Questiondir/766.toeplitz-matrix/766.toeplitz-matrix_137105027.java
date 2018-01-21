class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return true;
        int n = matrix[0].length;
        if (n == 0) return true;
        for (int x = m - 1; x >= 0; --x)
            if (!valid(matrix, x, 0, m, n)) return false;
        for (int y = n - 1; y >= 0; --y)
            if (!valid(matrix, 0, y, m, n)) return false;
        return true;
    }
    
    private boolean valid(int[][] matrix, int x, int y, int m, int n) {
        int v = matrix[x][y];
        while (true) {
            if (x >= m || y >= n) return true;
            if (matrix[x][y] != v) return false;
            ++x;
            ++y;
        }
    }
}