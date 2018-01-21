class Solution {
	private boolean[][][] dp;
	
    public boolean checkValidString(String s) {
        
    	int i , j , k , length = s.length();
        if (length == 0) {
            return true;
        }
    	dp = new boolean[length + 5][length + 5][length + 5];
    	for (i = 0;i < length;i ++) {
    		if (i == 0) {
    			if (s.charAt(i) == '(') {
    				dp[0][1][0] = true;
    			} else if (s.charAt(i) == '*') {
    				dp[0][1][0] = true;
    				dp[0][0][0] = true;
    			}
    		} else {
    			if (s.charAt(i) == '(') {
    				for (j = 0;j <= length;j ++) {
    					for (k = 0;k <= length;k ++) {
    						if (j >= k && dp[i - 1][j][k]) {
    							dp[i][j + 1][k] = true;
    						}
    					}
    				}
    			} else if (s.charAt(i) == ')') {
    				for (j = 0;j <= length;j ++) {
    					for (k = 0;k <= length;k ++) {
    						if (j > k && dp[i - 1][j][k]) {
    							dp[i][j][k + 1] = true;
    						}
    					}
    				}
    			} else {
    				// not use
    				for (j = 0;j <= length;j ++) {
    					for (k = 0;k <= length;k ++) {
    						dp[i][j][k] = dp[i - 1][j][k];
    					}
    				}
    				for (j = 0;j <= length;j ++) {
    					for (k = 0;k <= length;k ++) {
    						if (j >= k && dp[i - 1][j][k]) {
    							dp[i][j + 1][k] = true;
    						}
    						if (j > k && dp[i - 1][j][k]) {
    							dp[i][j][k + 1] = true;
    						}
    					}
    				}
    			}
    		}
    	}
    	for (i = 0;i <= length;i ++) {
    		if (dp[length - 1][i][i]) {
    			return true;
    		}
    	}
    	return false;
    	
    }
}