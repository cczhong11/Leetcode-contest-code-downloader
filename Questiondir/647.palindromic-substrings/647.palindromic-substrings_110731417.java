public class Solution {
	private boolean[][] dp;
	
    public int countSubstrings(String s) {
    	
    	int i , j , length = s.length();
    	if (length == 0) {
    		return 0;
    	} else {
    		dp = new boolean[length][length];
    		for (i = 1;i <= length;i ++) {
    			for (j = 0;j < length;j ++) {
    				int from = j , to = j + i - 1;
    				if (to < length) {
    					if (from == to) {
    						dp[from][to] = true;
    					} else if (from + 1 == to) {
    						if (s.charAt(from) == s.charAt(to)) {
    							dp[from][to] = true;
    						} else {
    							dp[from][to] = false;
    						}
    					} else {
    						if (dp[from + 1][to - 1] && (s.charAt(from) == s.charAt(to))) {
    							dp[from][to] = true;
    						} else {
    							dp[from][to] = false;
    						}
    					}
    				}
    			}
    		}
    		int ans = 0;
    		for (i = 0;i < length;i ++) {
    			for (j = 0;j < length;j ++) {
    				if (dp[i][j]) {
    					ans ++;
    				}
    			}
    		}
    		return ans;
    	}
    	
    }
}