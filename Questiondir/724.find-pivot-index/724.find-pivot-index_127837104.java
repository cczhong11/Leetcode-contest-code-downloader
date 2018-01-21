class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int halfSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (halfSum == (sum-halfSum-nums[i])) {
                return i;
            }
            halfSum += nums[i];            
        }
        return -1;
    }
}