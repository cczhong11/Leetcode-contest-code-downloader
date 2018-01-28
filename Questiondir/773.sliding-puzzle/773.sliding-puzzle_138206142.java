class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        double left = (double) 1, right = (double) (stations[stations.length-1] - stations[0]);
        left = left / (2*K);
        double error = 0.0000001;
        while(right-left > error) {
            double middle = (right-left) / 2 + left;
            int numberOfGasStationsNeeded = minimumNumberOfGasStationNeededToGetDistance(stations, middle);
            if (numberOfGasStationsNeeded > K) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return right;
    }
    
    private int minimumNumberOfGasStationNeededToGetDistance(int stations[], double dist) {
        int n = stations.length;
        int ret = 0;
        try {
            for(int i=0;i<n-1;i++) {
                int tmp = divideAndGetFloor(stations[i+1] - stations[i], dist) - 1;
                ret += tmp;
            }
            return ret;
        } catch (RuntimeException e) {
            return Integer.MAX_VALUE;
        }
    }
    
    private int divideAndGetFloor(int a, double b) {
        try {
            double ret1 = a / b;
            if(ret1>Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            int ret = (int) ret1;
            if (b*ret==a) return ret;
            else return ret+1;
        } catch (RuntimeException e) {
            return Integer.MAX_VALUE;
        }
    }
}