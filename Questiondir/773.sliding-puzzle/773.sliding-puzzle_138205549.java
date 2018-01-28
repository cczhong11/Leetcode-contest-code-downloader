class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        int size = stations.length;
        int total = stations[size-1] - stations[0];
        double max = total * 1.0 / (K + 1);
        double min = total * 1.0 / (K + 1 + size - 2);
        double eps = 0.000001;
        while (max - min > eps) {
        	double mid = (max + min) / 2;
        	if (canArrange(stations, mid, K)) {
        		max = mid;
        	} else {
        		min = mid;
        	}
        }
        return max;
    }

	private boolean canArrange(int[] stations, double mid, int k) {
		int count = 0;
		int currIdx = 1;
		double currDist = stations[0];
		int target = stations[stations.length-1];
		while(currDist < target) {
			if (stations[currIdx] - currDist <= mid) {
				currDist = stations[currIdx];
				currIdx++;
			} else {
				currDist += mid;
				count++;
			}
		}
		return count <= k;
	}
}