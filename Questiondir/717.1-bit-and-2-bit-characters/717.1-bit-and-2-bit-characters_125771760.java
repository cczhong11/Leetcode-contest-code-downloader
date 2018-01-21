class Solution {
	private boolean[] dp;

    public boolean isOneBitCharacter(int[] bits) {
     
    	int i , n = bits.length;
    	if (n == 1) {
    		return true;
    	} else if (n == 2) {
    		if (bits[0] == 1) {
    			return false;
    		} else {
    			return true;
    		}
    	} else {
    		dp = new boolean[n];
    		for (i = 0;i < n;i ++) {
    			if (i == 0) {
    				if (bits[i] == 0) {
    					dp[i] = true;
    				} else {
    					dp[i] = false;
    				}
    			} else {
    				// single
    				if (bits[i] == 0 && dp[i - 1]) {
    					dp[i] = true;
    				}
    				// double
    				if (bits[i - 1] == 1) {
    					if (i - 2 < 0 || (i - 2 >= 0 && dp[i - 2])) {
    						dp[i] = true;
    					}
    				}
    			}
    		}
    		if (dp[n - 3] && (bits[n - 2] == 1)) {
    			return false;
    		} else {
    			return true;
    		}
    	}
    	
    }
}