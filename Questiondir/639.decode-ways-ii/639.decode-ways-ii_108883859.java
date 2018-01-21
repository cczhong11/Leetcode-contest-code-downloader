	public class Solution {
	    public int numDecodings(String s) {
	        int mod = 1000000007;
	        long[] dp = new long[3];
	        dp[0] = 1;
	        for(char c : s.toCharArray()){
	        	long[] ndp = new long[3];
	        	if(c != '*'){
	        		if(c > '0')ndp[0] += dp[0];
	        		if(c == '1')ndp[1] += dp[0];
	        		if(c == '2')ndp[2] += dp[0];
	        		ndp[0] += dp[1];
	        		if(c <= '6')ndp[0] += dp[2];
	        	}else{
	        		ndp[0] += dp[0] * 9;
	        		ndp[1] += dp[0];
	        		ndp[2] += dp[0];
	        		ndp[0] += dp[1] * 9;
	        		ndp[0] += dp[2] * 6;
	        	}
	        	ndp[0] %= mod;
	        	ndp[1] %= mod;
	        	ndp[2] %= mod;
	        	dp = ndp;
	        }
	        return (int)dp[0];
	    }
	}	
