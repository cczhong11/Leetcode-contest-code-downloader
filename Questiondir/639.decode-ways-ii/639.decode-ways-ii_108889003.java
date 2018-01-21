public class Solution {
	private long MOD = 1000000007;
	
	private long[][] dp;

    public int numDecodings(String s) {
     
    	int i , j , k , length = s.length();
    	dp = new long[length][10];
    	
    	if (length == 0) {
    		return 0;
    	}
    	
    	if (s.charAt(0) == '*') {
    		for (i = 1;i < 10;i ++) {
    			dp[0][i] = 1;
    		}
    	} else {
    		if (s.charAt(0) > '0') {
    			dp[0][s.charAt(0) - '0'] = 1;
    		}
    	}
    	
    	for (i = 1;i < length;i ++) {
    		List<Integer> values = new ArrayList<>();
    		if (s.charAt(i) == '*') {
    			for (j = 1;j < 10;j ++) {
    				values.add(j);
    			}
    		} else {
    			values.add(s.charAt(i) - '0');
    		}
    		
    		for (int value : values) {
    			// single value
    			if (value > 0) {
    				for (j = 0;j < 10;j ++) {
    					dp[i][value] = (dp[i][value] + dp[i - 1][j]) % MOD;
    				}
    			}
    			// combine
    			for (j = 1;j <= 2;j ++) {
    				if (s.charAt(i - 1) == '*' || (s.charAt(i - 1) - '0') == j) { 
	    				int temp = j * 10 + value;
	    				if (temp <= 26) {
	    					if (i - 2 >= 0) {
		    					for (k = 0;k < 10;k ++) {
		    						dp[i][value] = (dp[i - 2][k] + dp[i][value]) % MOD;
		    					}
	    					} else {
	    						dp[i][value] = (dp[i][value] + 1) % MOD;
	    					}
	    				}
	    			}
    			}
    		}
    	}
    	
    	long ans = 0;
    	for (i = 0;i < 10;i ++) {
    		ans = (ans + dp[length - 1][i]) % MOD;
    	}
    	return (int) ans;
    	
    }

}