class Solution {
 public boolean isToeplitzMatrix(int[][] matrix) {
     
    	int i , j , n = matrix.length , m = matrix[0].length;
    	for (i = 0;i < n;i ++) {
    		int x = i , y = 0 , value = matrix[i][0];
    		while (x < n && y < m && matrix[x][y] == value) {
    			x ++;
    			y ++;
    		}
    		if (x < n && y < m) {
    			return false;
    		}
    	}
    	for (j = 0;j < m;j ++) {
    		int x = 0 , y = j , value = matrix[0][j];
    		while (x < n && y < m && matrix[x][y] == value) {
    			x ++;
    			y ++;
    		}
    		if (x < n && y < m) {
    			return false;
    		}
    	}
    	return true;
    	
    }
}