import java.util.Arrays;

class Solution {
    private static final double oo = (1<<29), tol = 1e-9;
    int g( double x ) {
        int dx = (int)(x+tol);
        if ( Math.abs(x-dx) < tol )
            return dx-1;
        return dx;
    }
    int f( int []s, double d ) {
        int i,j,k,m = 0;
        for ( i = 0; i < s.length-1; ++i ) {
            int x = s[i], y = s[i+1];
            m += (int)(g((y-x)/d));
        }
        return m;
    }
    public double minmaxGasDist(int[] s, int m) {
        int i,j,k,n = s.length;
        Arrays.sort(s);
        double good, bad, mid;
        for ( good = +oo, bad = 0; Math.abs(good-bad) > tol; ) {
            mid = (good+bad)/2;
            if ( f(s,mid) > m )
                bad = mid;
            else good = mid;
        }
        return good;
    }
}