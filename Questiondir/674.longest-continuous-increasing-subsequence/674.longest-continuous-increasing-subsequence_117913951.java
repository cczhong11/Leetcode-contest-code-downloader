class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int longestSoFar = 1;
        int curr = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                curr++;
                longestSoFar = Math.max(longestSoFar, curr);
            } else {
                curr = 1;
            }
        }
        return longestSoFar;
    }
}