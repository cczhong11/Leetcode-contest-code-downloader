class Solution {
	double[][][] dp;
	int N;
	int K;
    public double knightProbability(int N, int K, int r, int c) {
    	this.N=N;
    	this.K=K;
        dp = new double[N][N][K+1];
        for (int i=0;i<N;++i)
        	for (int j=0;j<N;++j) {
        		for (int k1=0;k1<K;++k1) {
        			dp[i][j][k1]=-1;
        		}
        		dp[i][j][K]=1;
        	}
        return dfs(r,c,0);
  
    }
	
    int[][] move = {{1,2},{2,1},{1,-2},{2,-1},{-1,-2},{-2,-1},{-1,2},{-2,1}};
    
    private double dfs(int r, int c, int i) {
		if (r<0) {
			return 0;
		}
		if (r>=N)
			return 0;
		if (c<0)
			return 0;
		if (c>=N)
			return 0;
		if (Math.abs(dp[r][c][i]+1)>0.5) {
			return dp[r][c][i];
		}
		dp[r][c][i]=0;
		for (int j=0;j<8;++j) {
			dp[r][c][i]+=dfs(r+move[j][0],c+move[j][1],i+1)/8;
		}
		return dp[r][c][i];
			
		
	}
}