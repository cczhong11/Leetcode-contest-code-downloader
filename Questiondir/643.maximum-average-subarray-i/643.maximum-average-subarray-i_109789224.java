public class Solution {

    public double findMaxAverage(int[] nums, int k) {
     
    	int i , j , n = nums.length;
    	double sum = 0 , ans = - 1000000000;
    	for (i = 0;i < n;i ++) {
    		sum += nums[i];
    		if (i >= k - 1) {
    			double temp = sum / k;
    			if (temp > ans) {
    				ans = temp;
    			}
    			sum -= nums[i - (k - 1)];
    		}
    	}
    	return ans;
    	
    }
    
}