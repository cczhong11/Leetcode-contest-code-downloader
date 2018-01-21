public class Solution {
    long [][]a = new long[32][2];
    {
        int i;
        for ( a[1][0] = a[1][1] = 1, i = 2; i < 32; ++i ) {
            a[i][0] = a[i-1][0]+a[i-1][1];
            a[i][1] = a[i-1][0];
        }
    }
    long f( int []c, int n, int len ) {
        int i,j,k;
        for ( k = n-1, i = 0; i < len-1; ++i, --k )
            if ( c[k] == 1 && c[k-1] == 1 )
                return 0;
        --k;
        if ( k >= 0 && c[k] == 0 ) return 0;
        if ( k < 0 ) return 1;
        assert k >= 0 && c[k] == 1;
        return a[n-len][0];
    }
    public int findIntegers(int num) {
        int i,j,k,m,n;
        int []c = new int[32];
        if ( num == 1 ) return 2;
        for ( i = 31; i >= 0; --i )
            c[i] = ((num>>i)&1);
        for ( n = 31; n >= 0 && c[n] == 0; --n ) ;
        if ( n < 0 ) return 1;
        assert n >= 0;
        ++n;
        // c[0], c[1], ..., c[n-1], with c[n-1] = 1
        long ans = a[n-1][0]+a[n-1][1];
        for ( i = 1; i <= n; ++i ) {
            ans += f(c,n,i);
        }
        return (int)ans;
    }
}