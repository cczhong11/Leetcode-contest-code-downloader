class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 1, sum = M[i][j];
                if (i > 0) {
                    sum += M[i - 1][j];
                    count++;
                    if (j > 0) {
                        sum += M[i - 1][j - 1];
                        count++;
                    }
                    if (j < n - 1) {
                        sum += M[i - 1][j + 1];
                        count++;
                    }
                }
                
                if (i < m - 1) {
                    sum += M[i + 1][j];
                    count++;
                    if (j > 0) {
                        sum += M[i + 1][j - 1];
                        count++;
                    }
                    if (j < n - 1) {
                        sum += M[i + 1][j + 1];
                        count++;
                    }
                }
                
                if (j > 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                
                if (j < n - 1) {
                    sum += M[i][j + 1];
                    count++;
                }
                
                res[i][j] = sum / count;
            }
        }
        
        return res;
    }
}