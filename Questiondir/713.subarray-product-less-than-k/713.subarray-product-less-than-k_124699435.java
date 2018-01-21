	class Solution {
	    public int numSubarrayProductLessThanK(int[] nums, int k) {
	    	if(k == 0)return 0;
	    	double lk = Math.log(k-0.5);
	    	double h = 0;
	    	int p = 0;
	    	int ret = 0;
	        for(int i = 0;i < nums.length;i++){
	        	h += Math.log(nums[i]);
	        	while(p <= i && h >= lk){
	        		h -= Math.log(nums[p++]);
	        	}
	        	ret += i-p+1;
	        }
	        return ret;
	    }
	}	
