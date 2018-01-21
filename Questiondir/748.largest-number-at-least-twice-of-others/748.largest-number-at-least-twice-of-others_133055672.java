class Solution {
    public int dominantIndex(int[] nums) {
        int imax = -1;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[imax = i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == imax) continue;
            if (nums[i] * 2 > max)
                return -1;
        }
        return imax;
    }
}