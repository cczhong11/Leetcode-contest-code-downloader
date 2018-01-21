class Solution {
    public int pivotIndex(int[] nums) {
        long t = Arrays.stream(nums).sum();
        long cs = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * cs == t - nums[i])
                return i;
            cs += nums[i];
        }
        return -1;
    }
}
