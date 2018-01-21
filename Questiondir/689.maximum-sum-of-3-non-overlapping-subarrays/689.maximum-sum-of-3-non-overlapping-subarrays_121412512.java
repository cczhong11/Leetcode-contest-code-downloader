class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        long[][] maxSum = new long[nums.length][3];
        int[][] maxNextStart = new int[nums.length][3];
        int slidingStart = nums.length - k;
        int slidingEnd = nums.length;
        long slidingSum = 0L;
        for (int i = slidingStart; i < slidingEnd; i++) slidingSum += nums[i];
        maxSum[slidingStart][0] = slidingSum;
        maxNextStart[slidingStart][0] = slidingStart;
        for (int i = slidingStart - 1; i >= 0; i--) {
            slidingSum += nums[i] - nums[i+k];
            if (slidingSum >= maxSum[i+1][0]) {
                maxSum[i][0] = slidingSum;
                maxNextStart[i][0] = i;
            } else {
                maxSum[i][0] = maxSum[i+1][0];
                maxNextStart[i][0] = maxNextStart[i+1][0];
            }
            for (int j = 1; j <= 2; j++) {
                if (slidingSum + maxSum[i+k][j-1] >= maxSum[i+1][j]) {
                    maxSum[i][j] = slidingSum + maxSum[i+k][j-1];
                    maxNextStart[i][j] = i;
                } else {
                    maxSum[i][j] = maxSum[i+1][j];
                    maxNextStart[i][j] = maxNextStart[i+1][j];
                }
            }
        }
        int[] result = new int[3];
        int i = 0;
        for (int j = 2; j >= 0; j--) {
            result[2-j] = maxNextStart[i][j];
            i = maxNextStart[i][j] + k;
        }
        return result;
    }
}