class Solution {
   public int[] constructArray(int n, int k) {
    
    	if (k == 1) {
    		int[] ans = new int[n];
    		for (int i = 0;i < n;i ++) {
    			ans[i] = i + 1;
    		}
    		return ans;
    	} else {
    		int value1 = 1 , value2 = k + 1;
    		int[] ans = new int[n];
    		int next = 0;
    		while (value1 < value2) {
    			ans[next ++] = value1;
    			ans[next ++] = value2;
    			value1 ++;
    			value2 --;
    		}
    		if (value1 == value2) {
    			ans[next ++] = value1;
    		}
    		for (int i = k + 2;i <= n;i ++) {
    			ans[next ++] = i;
    		}
    		return ans;
    	}
    	
    }
}