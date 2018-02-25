class Solution {
    double eps = 1e-8;
    public double minmaxGasDist(int[] stations, int K) {
        double min = 1e-8;
        double max = 100000000;
        int n = stations.length;
        double last = 0;
        while(min + eps < max){
            double mid = (min + max) / 2;
            if(check(stations, n, mid, K)){
                last = mid;
                max = mid;
                
            }
            else{
                min = mid;
            }
        }
        return last;
    }
    
    boolean check(int[] stations, int n, double max, int K){
        for(int i = 0; i + 1 < n; i++){
            double dis = stations[i + 1] - stations[i];
            dis /= max;
            if(dis - Math.floor(dis) > eps){
                dis = Math.ceil(dis);
            }
            int cnt = (int)dis;
            if(cnt > 0){
                cnt--;
            }
            K -= cnt;
            if(K < 0){
                return false;
            }
        }
        return true;
    }
}