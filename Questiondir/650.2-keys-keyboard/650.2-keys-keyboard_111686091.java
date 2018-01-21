	public class Solution {
	    public int minSteps(int n) {
	        int[] dp = new int[n+1];
	        Arrays.fill(dp, 99999);
	        dp[1] = 0;
	        for(int i = 1;i <= n;i++){
	        	for(int j = 1;i*(j+1) <= n;j++){
	        		dp[i*(j+1)] = Math.min(dp[i*(j+1)], dp[i] + (1+j));
	        	}
	        }
	        return dp[n];
	    }
	}	
