public class Solution {

	private long[] cnt = new long[4000];
	
    public int triangleNumber(int[] nums) {
     
    	int i , j , n = nums.length;
    	for (int value : nums) {
    		if (value > 0) {
    			cnt[value] ++;
    		}
    	}
    	cnt[0] = 0;
    	for (i = 1;i <= 3000;i ++) {
    		cnt[i] += cnt[i - 1];
    	}
    	long ans = 0;
    	for (i = 0;i < n;i ++) {
    		for (j = i + 1;j < n;j ++) {
    			int value1 = nums[i] , value2 = nums[j];
    			if (value1 != 0 && value2 != 0) {
	    			int lower = Math.abs(value1 - value2);
	    			int upper = value1 + value2;
	    			// from lower + 1 to upper - 1
	    			if (lower <= upper - 1) {
		    			long temp = cnt[upper - 1] - cnt[lower];
		    			if (value1 > lower && value1 < upper) {
		    				temp --;
		    			}
		    			if (value2 > lower && value2 < upper) {
		    				temp --;
		    			}
		    			ans += temp;
	    			}
    			}
    		}
    	}
    	return (int) (ans / 3);
    	
    }
}