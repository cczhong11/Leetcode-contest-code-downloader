class Solution {

	private long[] dp1;
	private int[] index1;
	private long[] dp2;
	private int[] index2;
	private long[] prefixSum;
	
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
     
    	int i , n = nums.length;
    	long sum = 0;
    	
    	dp1 = new long[n];
    	dp2 = new long[n];
    	index1 = new int[n];
    	index2 = new int[n];
    	prefixSum = new long[n];
    	
    	for (i = 0;i < n;i ++) {
    		if (i == 0) {
    			prefixSum[i] = nums[i];
    		} else {
    			prefixSum[i] = prefixSum[i - 1] + nums[i];
    		}
    	}
    	
    	for (i = 0;i < n;i ++) {
    		sum += nums[i];
    		if (i >= k - 1) {
    			if (i == k - 1) {
	    			dp1[i] = sum;
	    			index1[i] = i - (k - 1);
    			} else {
    				if (sum > dp1[i - 1]) {
    					dp1[i] = sum;
    					index1[i] = i - (k - 1);
    				} else {
    					dp1[i] = dp1[i - 1];
    					index1[i] = index1[i - 1];
    				}
    			}
    			sum -= nums[i - (k - 1)];
    		}
    	}
    	sum = 0;
    	for (i = n - 1;i >= 0;i --) {
    		sum += nums[i];
    		if (i <= n - k) {
    			if (i == n - k) {
    				dp2[i] = sum;
    				index2[i] = i;
    			} else {
    				if (sum >= dp2[i + 1]) {
    					dp2[i] = sum;
    					index2[i] = i;
    				} else {
    					dp2[i] = dp2[i + 1];
    					index2[i] = index2[i + 1];
    				}
    			}
    			sum -= nums[i + k - 1];
    		}
    	}
    	long ans = 0;
    	int[] result = new int[3];
    	for (i = k;i + 2 * k - 1 < n;i ++) {
    		int from = i , to = i + k - 1;
    		long temp = dp1[from - 1] + prefixSum[to] - prefixSum[from - 1] + dp2[to + 1];
    		if (temp > ans) {
    			ans = temp;
    			result[0] = index1[from - 1];
    			result[1] = from;
    			result[2] = index2[to + 1];
    		} else if (temp == ans) {
    			if (check(result , new int[] {index1[from - 1] , from , index2[to + 1]})) {
    				result[0] = index1[from - 1];
    				result[1] = from;
    				result[2] = index2[to + 1];
    			}
    		}
    	}
    	return result;
    	
    }
    
    private boolean check(int[] result1 , int[] result2) {
    	
    	int i , n = 3;
    	for (i = 0;i < n;i ++) {
    		if (result2[i] < result1[i]) {
    			return true;
    		} else if (result2[i] > result1[i]) {
    			return false;
    		}
    	}
    	return false;
    	
    }
    
}