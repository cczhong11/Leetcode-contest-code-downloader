class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        dp[0] = 1;
        count[0] = 1;
        for (int i = 1; i < dp.length; ++i) {
            int max = 1;
            count[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    int len = dp[j] + 1;
                    if (len > max) {
                        max = len;
                        count[i] = count[j];
                    } else if (len == max) {
                        count[i] += count[j];
                    }
                }
            }
            dp[i] = max;
        }
        
        int maxLen = 1;
        for (int i : dp) {
            maxLen = Math.max(maxLen, i);
        }
        
        int c = 0;
        for (int i = 0; i < dp.length; ++i) {
            if (maxLen == dp[i]) {
                c += count[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
        return c;
        
    }
}