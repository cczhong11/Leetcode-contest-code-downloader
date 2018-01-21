class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0)
            return null;
        
        int[] dirs = {0, -1, 0, 1, 0};
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt = 0, sum = 0;
                
                for (int row = i-1; row <= i+1; ++row)
                    for (int col = j-1; col <= j+1; ++col) {
                        if (row < 0 || row >= m || col < 0 || col >= n) 
                            continue;
                        cnt++;
                        sum += M[row][col];
                    }
                
                res[i][j] = sum / cnt;
            }
        }
        
        return res;
    }
}