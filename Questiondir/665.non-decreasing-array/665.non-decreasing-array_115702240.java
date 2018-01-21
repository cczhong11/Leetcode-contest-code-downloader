class Solution {
  
    public boolean checkPossibility(int[] nums) {
    	
    	int i , j , n = nums.length;
    	if (n <= 2) {
    		return true;
    	} else {
    		if (nums[0] > nums[1]) {
    			for (i = 1;i < n - 1;i ++) {
    				if (nums[i + 1] < nums[i]) {
    					return false;
    				}
    			}
    			return true;
    		} else {
    			i = 0;
    			while (i + 1 < n && nums[i] <= nums[i + 1]) {
    				i ++;
    			}
    			if (i + 1 == n) {
    				return true;
    			} else {
    				if (i - 1 < 0) {
    					i ++;
    				} else {
    					if (nums[i - 1] <= nums[i + 1]) {
    						i ++;
    					} else {
    						nums[i + 1] = nums[i];
    						i ++;
    					}
    				}
	    			while (i + 1 < n && nums[i] <= nums[i + 1]) {
	    				i ++;
	    			}
	    			return i + 1 == n;
    			}
    		}	
    	}
    	
    }
    
}