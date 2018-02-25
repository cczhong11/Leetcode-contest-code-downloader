class Solution {
   public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        int n = stations.length;
        double low = 0.0;
        double high = stations[n - 1] - stations[0];
        
        while (high - low > 1e-8) {
        		double mid = (low + high) / 2.0;
        		int sum = 0;
        		for (int i = 0; i < n - 1; i++) {
        			double t = Math.ceil((stations[i + 1] - stations[i]) / mid);
        			if (t <= 1) {
        				continue;
        			}
        			sum += t - 1;
        		}
        		if (sum <= K) {
        			high = mid;
        		} else {
        			low = mid;
        		}
        }
        return low;
    }
}