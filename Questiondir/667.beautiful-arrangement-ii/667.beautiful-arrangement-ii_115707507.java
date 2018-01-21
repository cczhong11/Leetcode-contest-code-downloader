class Solution {
   public int[] constructArray(int n, int k) {
    	int[] ans = new int[n];
    	if (k == 1) {
    		
    		for (int i = 0; i < n; i++) {
    			ans[i] = i + 1;
    		}
    		return ans;
    	}
    	

    	ans[0] = n;
    	int low = 1;
    	int high = n - 1;
    	int i = 1;
    	for (; k > 1; k--, i++) {
    		if (high < ans[i - 1]) {
    			ans[i] = low;
    			low++;
    		} else {
    			ans[i] = high;
    			high--;
    		}
    	}
    	if (ans[i - 1] < low) {
    		for (; i < n; i++, low++) {
    			ans[i] = low;
    		}
    	} else {
    		for (; i < n; i++, high--) {
    			ans[i] = high;
    		}
    	}
    	return ans;
    }
}