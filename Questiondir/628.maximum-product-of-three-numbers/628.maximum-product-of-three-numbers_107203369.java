	public class Solution {
	    public int maximumProduct(int[] nums) {
	        Arrays.sort(nums);
	        int n = nums.length;
	        int s = nums[n-1] * nums[n-2] * nums[n-3];
	        s = Math.max(s, nums[n-1] * nums[n-2] * nums[0]);
	        s = Math.max(s, nums[n-1] * nums[1] * nums[0]);
	        s = Math.max(s, nums[2] * nums[1] * nums[0]);
	        return s;
	    }
	}	
