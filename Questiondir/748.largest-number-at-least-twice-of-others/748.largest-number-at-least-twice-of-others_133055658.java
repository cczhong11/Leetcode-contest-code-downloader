class Solution {
    public int dominantIndex(int[] nums) {
    	int maxIndex = -1;
    	int max = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; ++i) {
    		if (nums[i] > max) {
    			max = nums[i];
    			maxIndex = i;
    		}
    	}
    	int n = nums.length;
    	Arrays.sort(nums);
    	if (max >= nums[n - 2] * 2) return maxIndex;
    	return -1;
    }
}