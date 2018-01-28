class Solution {
    boolean ok(int[] a,int k,double x)
    {
        int n=a.length,tot=0;
        for (int i=0;i<n-1;i++)
        {
            double gap=a[i+1]-a[i];
            int now=(int)Math.ceil(gap/x)-1;
            tot+=now;
            if (tot>k) return false;
        }
        return true;
    }
    public double minmaxGasDist(int[] stations, int K) {
        Arrays.sort(stations);
        double l=0.0,r=stations[stations.length-1]-stations[0];
        while ((r-l)>5e-7)
        {
            double mid=(r+l)/2;
            //if (1==1) return mid;
            if (ok(stations,K,mid)) r=mid; else l=mid;
        }
        return r;
    }
}