class Solution {
	private int[] dp;
	
    public int findLengthOfLCIS(int[] nums) {
     
    	int i , j , n = nums.length , ans = 0;
    	dp = new int[n];
    	for (i = 0;i < n;i ++) {
    		if (i == 0) {
    			dp[i] = 1;
    		} else {
    			if (nums[i] > nums[i - 1]) {
    				dp[i] = dp[i - 1] + 1;
    			} else {
    				dp[i] = 1;
    			}
    		}
    		if (dp[i] > ans) {
    			ans = dp[i];
    		}
    	}
    	return ans;
    	
    }
}