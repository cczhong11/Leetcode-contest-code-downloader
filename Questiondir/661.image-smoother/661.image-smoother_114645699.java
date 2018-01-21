class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M.length < 1 || M[0].length < 1) {
            return M;
        }
        int[][] matrix = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                matrix[i][j] = helper(M, i, j);
            }
        }
        return matrix;
    }
    
    private int helper(int[][] M,int i,int j) {
        int count = getCount(M, i, j);
        return sum(M, i, j)/count;
    }
    
    private int getCount(int[][] M, int i, int j) {
        int count = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for(int p = j - 1; p <= j + 1; p++) {
                count += isValid(M, k, p);
            }
        }
        return count;
    }
    
    private int isValid(int[][] M, int i, int j) {
        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length) {
            return 0;
        }
        return 1;        
    }
    
    private int sum(int[][] M, int i, int j) {
        int sum = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for(int p = j - 1; p <= j + 1; p++) {
                sum += get(M, k, p);
            }
        }
        return sum;
    }
    
    private int get(int[][] M, int i, int j) {
        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length) {
            return 0;
        }
        return M[i][j];
    }
    
}