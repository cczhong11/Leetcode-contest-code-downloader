class Solution {
 private int[] dp;
	private int[] cnt;
	
    public int findNumberOfLIS(int[] nums) {
     
    	int i , j , n = nums.length , max = 0;
    	dp = new int[n];
    	cnt = new int[n];
    	for (i = 0;i < n;i ++) {
    		if (i == 0) {
    			dp[i] = 1;
    			cnt[i] = 1;
    		} else {
    			dp[i] = 1;
    			cnt[i] = 1;
    			for (j = 0;j < i;j ++) {
    				if (nums[j] < nums[i]) {
    					int temp = dp[j] + 1;
    					if (temp > dp[i]) {
    						dp[i] = temp;
    						cnt[i] = cnt[j];
    					} else if (temp == dp[i]) {
    						dp[i] = temp;
    						cnt[i] += cnt[j];
    					}
    				}
    			}
    		}
    		if (dp[i] > max) {
    			max = dp[i];
    		}
    	}
    	int ans = 0;
    	for (i = 0;i < n;i ++) {
    		if (dp[i] == max) {
    			ans += cnt[i];
    		}
    	}
    	return ans;
    	
    }
}