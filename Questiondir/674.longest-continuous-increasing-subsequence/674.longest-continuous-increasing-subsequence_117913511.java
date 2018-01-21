class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int i = 0;
        while (i < nums.length) {
            int start = i;
            i++;
            while (i < nums.length && nums[i] > nums[i - 1]) {
                i++;
            }
            len = Math.max(len, i - start);
        }
        return len;
    }
}