	class Solution {
	    public int cherryPickup(int[][] a) {
	        int n = a.length;
	        int[][] dp = new int[n][n];
	        for(int i = 0;i < n;i++){
	        	for(int j = 0;j < n;j++){
	        		dp[i][j] = -999999;
	        	}
	        }
	        dp[0][0] = a[0][0];
	        for(int i = 1;i <= 2*n-2;i++){
	        	int[][] ndp = new int[n][n];
		        for(int j = 0;j < n;j++){
		        	for(int k = 0;k < n;k++){
		        		ndp[j][k] = -999999;
		        	}
		        }
	        	for(int j = Math.max(0, i-(n-1));j <= Math.min(n-1, i);j++){
	        		for(int k = Math.max(0, i-(n-1));k <= Math.min(n-1, i);k++){
	        			if(a[j][i-j] == -1 || a[k][i-k] == -1)continue;
	        			for(int pj = j-1;pj <= j;pj++){
	        				for(int pk = k-1;pk <= k;pk++){
	        					if(pj >= 0 && pk >= 0){
	        						ndp[j][k] = Math.max(ndp[j][k], dp[pj][pk] + (j == k ? a[j][i-j] : a[j][i-j] + a[k][i-k]));
	        					}
	        				}
	        			}
	        		}
	        	}
	        	dp = ndp;
	        }
	        if(dp[n-1][n-1] < 0)return 0;
	        return dp[n-1][n-1];
	    }
	}	
