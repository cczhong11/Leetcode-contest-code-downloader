class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // sliding window
        int res = 0;
        // corner case
        if (nums == null || nums.length == 0 || k <= 1) {
            return res;
        }
        int left = 0, right = 0;
        int cur = 1;
        while (right < nums.length) {
            cur *= nums[right++];
            while (cur >= k) {
                // count how many combinations we have
                cur /= nums[left++];
            }
            res += right - left;
        }
        return res;
    }
}