class Solution {
private int[] dp;
	private int[] cnt;
	
    public int deleteAndEarn(int[] nums) {
     
    	dp = new int[10010];
    	cnt = new int[10010];
    	for (int value : nums) {
    		cnt[value] ++;
    	}
    	for (int i = 1;i <= 10000;i ++) {
    		// use current
    		if (i == 1) {
    			dp[i] = cnt[i] * i;
    		} else {
    			int temp = dp[i - 2] + cnt[i] * i;
    			if (temp > dp[i]) {
    				dp[i] = temp;
    			}
    		}
    		// not use
    		if (dp[i - 1] > dp[i]) {
    			dp[i] = dp[i - 1];
    		}
    	}
    	return dp[10000];
    		
    }
}