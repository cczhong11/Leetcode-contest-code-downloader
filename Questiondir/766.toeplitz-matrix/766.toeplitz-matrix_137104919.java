class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int r = i;
            int c = 0;
            int v = matrix[r][c];
            while (r < m && c < n) {
                if (matrix[r][c] != v) return false;
                r++;
                c++;
            }
        }

        for (int i = 0; i < n; i++) {
            int r = 0;
            int c = i;
            int v = matrix[r][c];
            while (r < m && c < n) {
                if (matrix[r][c] != v) return false;
                r++;
                c++;
            }
        }
        
        return true;
    }
}