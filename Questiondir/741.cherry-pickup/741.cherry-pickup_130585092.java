class Solution {
	private static int[][][][] dp = new int[52][52][52][52];
	
    public int cherryPickup(int[][] grid) {
     
    	int n = grid.length , m = grid[0].length;
    	for (int x1 = 0;x1 < n;x1 ++) {
    		for (int x2 = 0;x2 < m;x2 ++) {
    			for (int x3 = 0;x3 < n;x3 ++) {
    				for (int x4 = 0;x4 < m;x4 ++) {
    					dp[x1][x2][x3][x4] = - 1;
    				}
    			}
    		}
    	}
    	
    	if (grid[0][0] == 1) {
    		dp[0][0][0][0] = 1;
    	} else if (grid[0][0] == 0) {
    		dp[0][0][0][0] = 0;
    	}
    	
    	for (int x1 = 0;x1 < n;x1 ++) {
    		for (int y1 = 0;y1 < m;y1 ++) {
    			for (int x2 = 0;x2 < n;x2 ++) {
    				for (int y2 = 0;y2 < m;y2 ++) {
    					if (grid[x1][y1] >= 0 && grid[x2][y2] >= 0) {
    						// from up
    						if (x1 - 1 >= 0 && x2 - 1 >= 0 && dp[x1 - 1][y1][x2 - 1][y2] >= 0) {
    							int temp = dp[x1 - 1][y1][x2 - 1][y2];
    							if (grid[x1][y1] == 1) {
    								temp ++;
    							}
    							if (grid[x2][y2] == 1) {
    								temp ++;
    							}
    							if (x1 == x2 && y1 == y2 && grid[x1][y1] == 1) {
    								temp --;
    							}
    							if (temp > dp[x1][y1][x2][y2]) {
    								dp[x1][y1][x2][y2] = temp;
    							}
    						}
    						
    						if (x1 - 1 >= 0 && y2 - 1 >= 0 && dp[x1 - 1][y1][x2][y2 - 1] >= 0) {
    							int temp = dp[x1 - 1][y1][x2][y2 - 1];
    							if (grid[x1][y1] == 1) {
    								temp ++;
    							}
    							if (grid[x2][y2] == 1) {
    								temp ++;
    							}
    							if (x1 == x2 && y1 == y2 && grid[x1][y1] == 1) {
    								temp --;
    							}
    							if (temp > dp[x1][y1][x2][y2]) {
    								dp[x1][y1][x2][y2] = temp;
    							}
    						}
    						
    						if (y1 - 1 >= 0 && x2 - 1 >= 0 && dp[x1][y1 - 1][x2 - 1][y2] >= 0) {
    							int temp = dp[x1][y1 - 1][x2 - 1][y2];
    							if (grid[x1][y1] == 1) {
    								temp ++;
    							}
    							if (grid[x2][y2] == 1) {
    								temp ++;
    							}
    							if (x1 == x2 && y1 == y2 && grid[x1][y1] == 1) {
    								temp --;
    							}
    							if (temp > dp[x1][y1][x2][y2]) {
    								dp[x1][y1][x2][y2] = temp;
    							}
    						}
    						
    						if (y1 - 1 >= 0 && y2 - 1 >= 0 && dp[x1][y1 - 1][x2][y2 - 1] >= 0) {
    							int temp = dp[x1][y1 - 1][x2][y2 - 1];
    							if (grid[x1][y1] == 1) {
    								temp ++;
    							}
    							if (grid[x2][y2] == 1) {
    								temp ++;
    							}
    							if (x1 == x2 && y1 == y2 && grid[x1][y1] == 1) {
    								temp --;
    							}
    							if (temp > dp[x1][y1][x2][y2]) {
    								dp[x1][y1][x2][y2] = temp;
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	if (dp[n - 1][m - 1][n - 1][m - 1] < 0) {
    		return 0;
    	} else {
    		return dp[n - 1][m - 1][n - 1][m - 1];
    	}
    	
    }
}