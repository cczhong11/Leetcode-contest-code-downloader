import java.util.Arrays;

class Solution {
	boolean check(int[] stations, int K, double m) {
		for (int i = 0; i + 1 < stations.length; ++i) {
			double d = stations[i + 1] - stations[i];
			K -= Math.ceil(d / m) - 1;
		}
		return K >= 0;
	}
	
    public double minmaxGasDist(int[] stations, int K) {
    	int N = stations.length;
    	Arrays.sort(stations);
        double l = 0.0;
        double r = stations[N - 1] - stations[0];
        for (int steps = 0; steps < 100; ++steps) {
        	double m = (l + r) / 2.0;
        	if (check(stations, K, m)) {
        		r = m;
        	} else {
        		l = m;
        	}
        }
        return r;
    }
}