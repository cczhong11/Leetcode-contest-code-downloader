class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int total = 0;
        int end = 0;
        int product = 1;
        for (int start = 0; start < nums.length; start++) {
            while (end < nums.length && product * nums[end] < k) {
                product *= nums[end];
                end++;
            }
            total += (end - start);
            if (start == end) {
                end++;
            } else {
                product /= nums[start];
            }
        }
        return total;
    }
}