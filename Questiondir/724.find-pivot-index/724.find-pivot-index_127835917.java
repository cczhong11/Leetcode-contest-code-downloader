class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        int val = 0;
        for (int i=0; i<nums.length; i++) {
            if (val*2+nums[i] == sum) {
                return i;
            }
            val += nums[i];
        }
        return -1;
    }
}