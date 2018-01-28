class Solution {
private int get(int[] stations , double dist) {
		
		int i , n = stations.length;
		int ans = 0;
		for (i = 0;i < n - 1;i ++) {
			double diff = stations[i + 1] - stations[i];
			double temp = diff / dist;
			if (Math.abs(Math.round(temp) - temp) < 1e-8) {
				ans += ((int) Math.round(temp) - 1);
			} else {
				ans += (int) temp;
			}
		}
		return ans;
		
	}
	
    public double minmaxGasDist(int[] stations, int K) {
        
    	double low = 0 , high = 1000000000;
    	int cnt = 200;
    	while (low < high && cnt > 0) {
    		double mid = (low + high) / 2;
    		int temp = get(stations , mid);
    		if (temp <= K) {
    			high = mid;
    		} else {
    			low = mid;
    		}
    		cnt --;
    	}
    	return low;
    	
    }
}