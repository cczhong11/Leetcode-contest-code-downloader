	class Solution {
	    public int[][] imageSmoother(int[][] M) {
	    	int n = M.length;
	    	int m = M[0].length;
        	int[][] NM = new int[n][m];
        	for(int i = 0;i < n;i++){
        		for(int j = 0;j < m;j++){
        			int s = 0;
        			int nu = 0;
        			for(int k = i-1;k <= i+1;k++){
        				for(int l = j-1;l <= j+1;l++){
        					if(k >= 0 && k < n && l >= 0 && l < m){
        						s += M[k][l];
        						nu++;
        					}
        				}
        			}
        			s /= nu;
        			NM[i][j] = s;
        		}
        	}
        	M = NM;
	        return M;
	    }
	}	
