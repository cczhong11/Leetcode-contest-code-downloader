	class Solution {
	    public boolean isToeplitzMatrix(int[][] a) {
	        int n = a.length, m = a[0].length;
	        for(int i = 0;i < n-1;i++){
	        	for(int j = 0;j < m-1;j++){
	        		if(a[i][j] != a[i+1][j+1])return false;
	        	}
	        }
	        return true;
	    }
	}	// 
