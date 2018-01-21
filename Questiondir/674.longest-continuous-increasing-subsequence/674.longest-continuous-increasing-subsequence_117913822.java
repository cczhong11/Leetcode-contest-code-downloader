class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        int count = 1, Max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
                Max = Math.max(Max, count);
            } else {
                count = 1;
            }
        }
        Max = Math.max(Max, count);
        return Max;
    }
}