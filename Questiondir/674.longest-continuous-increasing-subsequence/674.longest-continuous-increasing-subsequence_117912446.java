class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int longest = 0;
        int curr = 0;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > last) {
                ++curr;
                last = nums[i];
                longest = Math.max(longest, curr);
            } else {
                curr = 1;
                last = nums[i];
            }
        }
        return longest;
    }
}