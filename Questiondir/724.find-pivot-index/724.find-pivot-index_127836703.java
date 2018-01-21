class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int[] sums = new int[nums.length];
        for (int i = nums.length-2; i >= 0; i--) {
            sums[i] = nums[i+1]+sums[i+1];
        }
        int leftsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}