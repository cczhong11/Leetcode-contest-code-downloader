class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            int elem = matrix[0][col];
            // String s = "";
            for (int x = 1; x < matrix.length; x++) {
                if (col + x >= matrix[0].length) break;
                if (matrix[x][col+x] != elem) return false;
                // s += "(" + x + ", " + (col+x) + "), ";
            }
            // System.out.println(s);
        }
        for (int row = 0; row < matrix.length; row++) {
            int elem = matrix[row][0];
            // String s = "";
            for (int y = 1; y < matrix[0].length; y++) {
                if (row + y >= matrix.length) break;
                if (matrix[row+y][y] != elem) return false;
                // s += "(" + (row+y) + ", " + y + "), ";
            }
            // System.out.println(s);
        }
        return true;
    }
}