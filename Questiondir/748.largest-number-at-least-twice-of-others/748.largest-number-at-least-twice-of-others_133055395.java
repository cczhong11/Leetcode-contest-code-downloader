class Solution {
    public int dominantIndex(int[] nums) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                idx = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first >= second * 2)? idx : -1;
    }
}