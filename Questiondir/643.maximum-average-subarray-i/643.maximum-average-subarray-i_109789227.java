	public class Solution {
	    public double findMaxAverage(int[] nums, int k) {
	    	long s = 0;
	    	long max = Long.MIN_VALUE;
	        for(int i = 0;i < nums.length;i++){
	        	s += nums[i];
	        	if(i >= k-1){
	        		max = Math.max(max, s);
	        		s -= nums[i-(k-1)];
	        	}
	        }
	        return (double)max / k;
	    }
	}	
