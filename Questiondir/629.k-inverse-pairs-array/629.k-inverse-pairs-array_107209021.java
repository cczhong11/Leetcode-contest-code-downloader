public class Solution {
    int N = 0x400;
    int MOD = 1000000000+7;
    int [][]z = new int[N][N];
    int f( int x, int y ) {
        long p = x, q = y;
        return (int)((p+q)%MOD);
    }
    public int kInversePairs(int n, int k) {
        int i,j,t,m;
        for ( i = 0; i <= n; ++i )
            for ( j = 0; j <= n; ++j )
                z[i][j] = 0;
        for ( z[0][0] = 1, m = 1; m <= n; ++m )
            for ( z[m][0] = 1, t = 1; t < N && t <= (m*(m-1))/2; ++t ) {
                z[m][t] = f(f(z[m][t-1],z[m-1][t]),(t>=m?MOD-z[m-1][t-m]:0));
            }
        return (int)z[n][k];
    }
}