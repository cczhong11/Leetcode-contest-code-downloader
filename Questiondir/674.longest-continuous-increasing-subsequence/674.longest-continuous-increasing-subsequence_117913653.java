class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; ++i) {
        	if (i == 0 || nums[i] <= nums[i - 1]) {
        		tmp = 1;
        	} else {
        		++tmp;
        	}
        	res = Math.max(res, tmp);
        }
        return res;
    }
}