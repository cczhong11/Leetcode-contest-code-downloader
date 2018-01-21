class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    	int cnt = 0;
    	int start = 0;
    	int end = 1;
    	int product = nums[0];
    	while (start < nums.length) {
    		if (product < k) {
    			cnt += (end - start);
    			if (end < nums.length) {
    				product *= nums[end];
    				end++;
    			} else {
    				break;
    			}
    		} else {
    			product /= nums[start];
    			start++;
    			if (start == end) {
    				if (start == nums.length) {
    					break;
    				} else {
    					product = nums[end];
    					end++;
    				}
    			}
    		}
    	}
    	return cnt;
    }
}