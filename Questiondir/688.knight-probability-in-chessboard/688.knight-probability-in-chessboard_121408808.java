	class Solution {
		int[] DRK = {-2,-2,-1,-1,1,1,2,2};
		int[] DCK = {-1,1,-2,2,-2,2,-1,1};
		
	    public double knightProbability(int N, int K, int r, int c) {
	    	int n = N;
	        double[][] dp = new double[n][n];
	        dp[r][c] = 1;
	        for(int i = 0;i < K;i++){
		        double[][] ndp = new double[n][n];
		        for(int u = 0;u < n;u++){
		        	for(int v = 0;v < n;v++){
				        for(int k = 0;k < 8;k++){
				        	int nu = u + DRK[k], nv = v + DCK[k];
				        	if(nu >= 0 && nu < n && nv >= 0 && nv < n){
				        		ndp[nu][nv] += dp[u][v] / 8;
				        	}
				        }
		        	}
		        }
		        dp = ndp;
	        }
	        double ret = 0;
	        for(int u = 0;u < n;u++){
	        	for(int v = 0;v < n;v++){
	        		ret += dp[u][v];
	        	}
	        }
	        return ret;
	    }
	}	
