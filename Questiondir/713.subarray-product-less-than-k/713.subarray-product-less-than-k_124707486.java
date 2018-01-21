class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int cur = 1;
        int res = 0;
        while (right < nums.length) {
            cur *= nums[right];
            while (left <= right && cur >= k) {
                cur /= nums[left++];
            }
            if (cur <= k) {
                res += right - left + 1;
            }
            right++;            
        }
        return res;
    }
}