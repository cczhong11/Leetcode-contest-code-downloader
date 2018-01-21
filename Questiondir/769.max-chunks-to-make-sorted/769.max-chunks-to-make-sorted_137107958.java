class Solution {
  public int maxChunksToSorted(int[] arr) {
    
    	int i , n = arr.length , ans = 0;
    	int low = 0 , high = 0 , cnt = 0;
    	for (i = 0;i < n;i ++) {
    		cnt ++;
			if (arr[i] < low) {
				low = arr[i];
			}
			if (arr[i] > high) {
				high = arr[i];
			}
    		if (high - low + 1 == cnt) {
    			ans ++;
    			low = high + 1;
    			high = low;
    			cnt = 0;
    		}
    	}
    	return ans;
    	
    }
}