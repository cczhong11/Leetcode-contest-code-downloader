class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double L = 0;
        double R = 1e16;
        for (int i = 0; i < 128; ++i) {
            double M = (L + R) / 2;
            if (can(stations, K, M)) {
                R = M;
            } else {
                L = M;
            }
        }
        return L;
    }
    
    public boolean can(int[] stations, int K, double D) {
        int need = 0;
        for (int i = 1; i < stations.length; ++i) {
            int dist = stations[i] - stations[i - 1];
            if (dist <= D) {
                continue;
            }
            need += (int)(Math.ceil(dist / D) - 1);
        }
        return need <= K;
    }
}