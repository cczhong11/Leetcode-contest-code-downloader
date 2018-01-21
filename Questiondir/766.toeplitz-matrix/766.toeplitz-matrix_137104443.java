class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int val = matrix[0][0];
        for (int i = 0; i < row && i < col; ++i) {
        	if (matrix[i][i] != val) {
        		return false;
        	}
        }
        return true;
    }
}