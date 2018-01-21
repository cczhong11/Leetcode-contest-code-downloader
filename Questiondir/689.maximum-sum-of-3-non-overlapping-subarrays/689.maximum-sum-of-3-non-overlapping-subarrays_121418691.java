class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length+1];
        for (int i=0; i<nums.length; i++) {
            sums[i+1] = sums[i]+nums[i];
        }
        int[][] lefts = new int[nums.length][2];
        for (int i=k-1, max=0; i<nums.length; i++) {
            int sum = sums[i+1]-sums[i-k+1];
            if (i == k-1 || sum > max) {
                lefts[i][0] = i-k+1;
                max = sum;
            } else {
                lefts[i][0] = lefts[i-1][0];
            }
            lefts[i][1] = max;
        }
        int[][] rights = new int[nums.length][2];
        for (int i=nums.length-k, max=0; i>=0; i--) {
            int sum = sums[i+k]-sums[i];
            if (i == nums.length-k || sum >= max) {
                rights[i][0] = i;
                max = sum;
            } else {
                rights[i][0] = rights[i+1][0];
            }
            rights[i][1] = max;
        }
        int[] results = new int[3];
        for (int i=k, j=2*k, max=0; j+k<=nums.length; i++, j++) {
            if (i == k || max < lefts[i-1][1]+rights[j][1]+sums[j]-sums[i]) {
                max = lefts[i-1][1]+rights[j][1]+sums[j]-sums[i];
                results[0] = lefts[i-1][0];
                results[1] = i;
                results[2] = rights[j][0];
            }
        }
        return results;
    }
}