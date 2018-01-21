class Solution {
private int getTotal(int value , int m , int n) {
		
		int ans = 0;
		for (int i = 1;i <= m;i ++) {
			int temp = Math.min(value / i , n);
			ans += temp;
		}
		return ans;
		
	}
	
    public int findKthNumber(int m, int n, int k) {
     
    	int low = 1 , high = m * n + 1;
    	while (low < high) {
    		int mid = (low + high) / 2;
    		int total = getTotal(mid , m , n);
    		if (total >= k) {
    			high = mid;
    		} else {
    			low = mid + 1;
    		}
    	}
    	return high;
    	
    }
}