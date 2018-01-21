class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int len = nums.length, Max = 0, count = 0;
        int[][] dp = new int[len][2];
        
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j])  continue;
                if (dp[i][0] > dp[j][0] + 1)    continue;
                else if (dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = dp[j][1];
                }
                else if (dp[i][0] == dp[j][0] + 1) {
                    dp[i][1] += dp[j][1];
                }
            }
            if (dp[i][0] > Max) {
                Max = dp[i][0];
                count = dp[i][1];
            } else if (dp[i][0] == Max) {
                count += dp[i][1];
            }
        }
        return count;   
    }
}