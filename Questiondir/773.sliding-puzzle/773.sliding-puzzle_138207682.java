class Solution {
    public double minmaxGasDist(int[] s, int k) {
        final double error = 1e-7;
        Arrays.sort(s);
        double[] dists = new double[s.length - 1];
        for (int i = 0; i != s.length - 1; ++i)
            dists[i] = s[i + 1] - s[i];
        Arrays.sort(dists);
        int n = dists.length;
        double min = 0.0;
        double max = dists[n - 1];
        while (max - min > error) {
            double d = (max + min) / 2;
            int p = num_gs(dists, d);
            if (p > k) {
                min = d;
            } else {
                max = d;
            }
        }
        return (max + min) / 2;
    }
    
    private int num_gs(double[] dists, double d) {
        int ret = 0;
        for (int i = 0; i != dists.length; ++i) {
            ret += Math.max(0, (int)Math.floor(dists[i] / d));
        }
        return ret;
    }
}