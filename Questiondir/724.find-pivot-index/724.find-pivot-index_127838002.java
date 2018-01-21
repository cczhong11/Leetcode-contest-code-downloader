class Solution {
 public int pivotIndex(int[] nums) {
     
    	int i , n = nums.length;
    	int sum = 0 , s = 0;
    	for (i = 1;i < n;i ++) {
    		sum += nums[i];
    	}
    	for (i = 0;i < n;i ++) {
    		if (sum == s) {
    			return i;
    		}
    		s += nums[i];
    		if (i + 1 < n) {
    			sum -= nums[i + 1];
    		}
    	}
    	return - 1;
    	
    }
}