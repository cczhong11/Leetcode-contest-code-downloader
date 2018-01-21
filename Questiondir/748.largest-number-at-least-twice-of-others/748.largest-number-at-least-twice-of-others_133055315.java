class Solution {
  public int dominantIndex(int[] nums) {
     
    	int i , j , n = nums.length;
    	int max = nums[0] , index = 0;
    	for (i = 0;i < n;i ++) {
    		if (nums[i] > max) {
    			max = nums[i];
    			index = i;
    		}
    	}
    	for (i = 0;i < n;i ++) {
    		if (i != index) {
    			if (nums[index] >= nums[i] * 2) {
    				continue;
    			} else {
    				return - 1;
    			}
    		}
    	}
    	return index;
    	
    }
}