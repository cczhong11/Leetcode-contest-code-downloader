class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            while (right < nums.length && (right == left || nums[right] > nums[right - 1])) {
                right++;
            }
            max = Math.max(max, right - left);
            left = right;
        }
        
        return max;
    }
}