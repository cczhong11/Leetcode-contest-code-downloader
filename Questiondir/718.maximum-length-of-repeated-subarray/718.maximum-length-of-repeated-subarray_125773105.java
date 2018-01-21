	class Solution {
	    public int findLength(int[] A, int[] B) {
	        int n = A.length, m = B.length;
	        int[][] dp = new int[n+1][m+1];
	        int ret = 0;
	        for(int i = 0;i < n;i++){
	        	for(int j = 0;j < m;j++){
	        		if(A[i] == B[j]){
	        			dp[i+1][j+1] = dp[i][j] + 1;
	        		}else{
	        			dp[i+1][j+1] = 0;
	        		}
	        		ret = Math.max(ret, dp[i+1][j+1]);
	        	}
	        }
	        return ret;
	    }
	}	
