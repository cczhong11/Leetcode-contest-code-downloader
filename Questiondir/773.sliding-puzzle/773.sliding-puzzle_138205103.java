class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double l = 0.0;
        double r = 1e8;

        while (r - l > 0.000000001) {
            double m = l + (r - l) / 2;
            int needs = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                int d = stations[i+1] - stations[i];
                needs += (int) (d / m);
            }
            if (needs > K) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }
}