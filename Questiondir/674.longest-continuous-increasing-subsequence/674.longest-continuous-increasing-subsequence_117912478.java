	class Solution {
	    public int findLengthOfLCIS(int[] nums) {
	    	int len = 0;
	    	int max = 0;
	    	for(int i = 0;i < nums.length;i++){
	    		if(i == 0 || nums[i] > nums[i-1]){
	    			len++;
	    		}else{
	    			len = 1;
	    		}
	    		max = Math.max(max, len);
	        }
	    	return max;
	    }
	}	