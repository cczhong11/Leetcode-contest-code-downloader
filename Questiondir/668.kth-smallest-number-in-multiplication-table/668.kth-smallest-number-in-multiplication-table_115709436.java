class Solution {
   public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        
        while (low < high) {
        	int mid = low + (high - low) / 2;
        	if (check(m, n, mid) < k) {
        		low = mid + 1;
        	} else {
        		high = mid;
        	}
        }
        return low;
    }
    
    int check(int m, int n, int value) {
    	int sum = 0;
    	for (int i = 1; i <= m; i++) {
    		int k = value / i;
    		if (k > n) {
    			k = n;
    		}
    		sum += k;
    	}
    	return sum;
    }
}