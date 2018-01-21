class Solution {
	private double[][] dp , next;
	private int[] dx = new int[] {- 2 , - 1 , 1 , 2 , 2 , 1 , - 1 , - 2};
	private int[] dy = new int[] {1 , 2 , 2 , 1 , - 1 , - 2 , - 2 , - 1};

    public double knightProbability(int N, int K, int r, int c) {
    	
    	double total = 0;
    	int i , j , k;
    	dp = new double[30][30];
    	next = new double[30][30];
    	dp[r][c] = 1;
    	
    	for (i = 0;i < K;i ++) {
    		for (j = 0;j < N;j ++) { 		
    			for (k = 0;k < N;k ++) {
    				if (dp[j][k] > 0) {
	    				for (int d = 0;d < 8;d ++) {
	    					int tx = j + dx[d];
	    					int ty = k + dy[d];
	    					if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
	    						next[tx][ty] += dp[j][k];
	    					}
	    				}
    				}
    			}
    		}
    		for (j = 0;j < N;j ++) {
    			for (k = 0;k < N;k ++) {
    				dp[j][k] = next[j][k];
    				next[j][k] = 0;
    			}
    		}
    	}
    	for (i = 0;i < N;i ++) {
    		for (j = 0;j < N;j ++) {
    			total += dp[i][j];
    		}
    	}
    	double ans = total;
    	for (i = 0;i < K;i ++) {
    		ans /= 8;
    	}
    	return ans;
    	
    }
}