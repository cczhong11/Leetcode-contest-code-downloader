class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = n - 1; i >= 0; i--) {
            int row = 1;
            int col = i + 1;
            while (row < m && col < n) {
                if(matrix[row][col] == matrix[0][i]){
                    row++;
                    col++;
                }else{
                    return false;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            int row = i + 1;
            int col = 1;
            while (row < m && col < n) {
                if(matrix[row][col] == matrix[i][0]){
                    row++;
                    col++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}