class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int n = nums.length;
        for (int i = 0; i < n; i++)
            count[nums[i]]++;
        int[][] dp = new int[10001][2]; // 0: not taking; 1: taking
        for (int i = 1; i < 10001; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = count[i] * i + ((i == 1)? 0 : Math.max(dp[i - 2][0], dp[i - 2][1]));
        }
        return Math.max(dp[10000][0], dp[10000][1]);
    }
}