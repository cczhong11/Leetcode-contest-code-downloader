public class Solution {
    public int maximumProduct(int[] nums) {
     
    	int i , j , n = nums.length , ans = Integer.MIN_VALUE;
    	Arrays.sort(nums);
		int temp = nums[0] * nums[1] * nums[n - 1];
		if (temp > ans) {
			ans = temp;
		}
    	temp = nums[n - 1] * nums[n - 2] * nums[n - 3];
    	if (temp > ans) {
    		ans = temp;
    	}
    	return ans;
    	
    }
}