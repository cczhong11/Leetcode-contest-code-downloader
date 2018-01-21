public class Solution {
	private static double[] values = new double[10010];
	
	private static boolean check(int[] nums , double avg , int k) {
		
		int i , n = nums.length;
		for (i = 0;i < n;i ++) {
			values[i] = (double) nums[i] - avg;
		}
		// length k, >= 0
		double sum = 0 , min = 0 , s = 0;
		for (i = 0;i < n;i ++) {
			sum += values[i];
			if (i >= k - 1) {
				if (sum - min >= 0) {
					return true;
				}
				s += values[i - (k - 1)];
				if (s < min) {
					min = s;
				}
			}
		}
		return false;
		
	}
	
    public double findMaxAverage(int[] nums, int k) {
     
    	int cnt = 0;
    	double low = - 10000000;
    	double high = 10000000;
    	while (low < high && cnt < 100) {
    		double mid = (low + high) / 2;
    		if (check(nums , mid , k)) {
    			low = mid;
    		} else {
    			high = mid;
    		}
    		cnt ++;
    	}
    	return low;
    	
    }
}