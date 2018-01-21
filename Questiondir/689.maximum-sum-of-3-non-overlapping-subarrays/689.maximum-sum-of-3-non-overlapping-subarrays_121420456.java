class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[3][nums.length], index = new int[6][nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(i >= k-1) {
                if(i == 0 || sum > dp[0][i-1]) {
                    dp[0][i] = sum;
                    index[0][i] = i-k+1;
                    //System.out.println(i + ", " + dp[0][i]);
                }
                else {
                    dp[0][i] = dp[0][i-1];
                    index[0][i] = index[0][i-1];
                }
            }
            if(i >= 2*k-1) {
                if(dp[1][i-1] < sum + dp[0][i-k]) {
                    dp[1][i] = sum + dp[0][i-k];
                    index[1][i] = index[0][i-k];
                    index[2][i] = i-k+1;
                    //System.out.println(i + ", " + dp[1][i]);
                }
                else {
                    dp[1][i] = dp[1][i-1];
                    index[1][i] = index[1][i-1];
                    index[2][i] = index[2][i-1];
                }
            }
            if(i >= 3*k-1) {
                if(dp[2][i-1] < sum + dp[1][i-k]) {
                    dp[2][i] = sum + dp[1][i-k];
                    index[3][i] = index[1][i-k];
                    index[4][i] = index[2][i-k];
                    index[5][i] = i-k+1;
                    //System.out.println(i + ", " + dp[2][i]);
                }
                else {
                    dp[2][i] = dp[2][i-1];
                    index[3][i] = index[3][i-1];
                    index[4][i] = index[4][i-1];
                    index[5][i] = index[5][i-1];
                }
            }
            if(i >= k-1) sum -= nums[i-k+1];
        }
        //System.out.println(dp[2][nums.length-1]);
        return new int[]{index[3][nums.length-1], index[4][nums.length-1], index[5][nums.length-1]};
    }
}