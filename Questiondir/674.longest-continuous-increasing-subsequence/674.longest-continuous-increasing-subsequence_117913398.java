class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
        	int cur = 1;
        	for (int j = i+1; j < nums.length; j++) {
        		if (nums[j] <= nums[j-1]) {
        			i = j-1;
        			break;
        		}
        		cur++;
        	}
        	res = Math.max(res, cur);
        }
        return res;
    }

}