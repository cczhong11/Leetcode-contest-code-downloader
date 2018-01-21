class Solution {
private int[] min;
	
    public int maxChunksToSorted(int[] arr) {
       
    	int i , n = arr.length , ans = 0;
    	min = new int[n];
    	for (i = n - 1;i >= 0;i --) {
    		if (i == n - 1) {
    			min[i] = arr[i];
    		} else {
    			min[i] = Math.min(min[i + 1] , arr[i]);
    		}
    	}
    	int max = - 1;
    	for (i = 0;i < n;i ++) {
    		if (arr[i] > max) {
    			max = arr[i];
    		}
    		if (i + 1 == n) {
    			ans ++;
    		} else {
    			if (max <= min[i + 1]) {
    				max = - 1;
    				ans ++;
    			}
    		}
    	}
    	return ans;
    	
    }
	
}