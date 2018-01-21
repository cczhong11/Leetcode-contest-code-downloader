class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        int total = 0;
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 1) {
                count[i] = 1;
            } else {
                count[i] = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && dp[j] == dp[i] - 1) {
                        count[i] += count[j];
                    }
                }
            }
            if (dp[i] == max) {
                total += count[i];
            }
        }
        
        return total;
    }
}