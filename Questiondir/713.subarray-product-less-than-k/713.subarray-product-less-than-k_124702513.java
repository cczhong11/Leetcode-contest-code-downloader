class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int val = 1;
        int slow = 0;
        int result = 0;
        for (int fast = 0; fast < nums.length; ) {
            val *= nums[fast++];
            while (slow < fast && val >= k) val /= nums[slow++];
            if (slow < fast) {
                result += fast - slow;
            }
        }
        return result;
    }
}