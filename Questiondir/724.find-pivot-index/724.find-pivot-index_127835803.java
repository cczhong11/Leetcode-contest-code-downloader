class Solution {
    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        for (int i = 0; i < sums.length; i++) {
            int left = sums[i] - nums[i];
            if (left * 2 == sums[sums.length - 1] - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}