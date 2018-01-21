public class Solution {
    private static final long MOD = 1000000000L+7L;
    private static final int N = (1<<17);
    int n;
    char []c;
    long []z = new long[N];
    public int numDecodings(String s) {
        if ( s == null || s.length() == 0 ) return 0;
        n = s.length();
        c = new char[n+1];
        int i,j,k;
        for ( i = 0; i < n; ++i )
            c[i+1] = s.charAt(i);
        for ( z[0] = 1, i = 1; i <= n; ++i ) {
            if ( c[i] == '*' ) {
                if ( i == 1 ) {
                    z[i] = 9;
                    continue ;
                }
                z[i] += z[i-1]*9; z[i] %= MOD;
                if ( i >= 2 ) {
                    if ( c[i-1] == '1' ) {
                        z[i] += z[i-2]*9;
                        z[i] %= MOD;
                    }
                    if ( c[i-1] == '2' ) {
                        z[i] += z[i-2]*6;
                        z[i] %= MOD;
                    }
                    if ( c[i-1] == '*' ) {
                        z[i] += z[i-2]*15;
                        z[i] %= MOD;
                    }
                }
            }
            else {
                if ( c[i] == '0' ) {
                    if ( i >= 2 && c[i-1] == '1' ) {
                        z[i] += z[i-2];
                        z[i] %= MOD;
                    }
                    if ( i >= 2 && c[i-1] == '2' ) {
                        z[i] += z[i-2];
                        z[i] %= MOD;
                    }
                    if ( i >= 2 && c[i-1] == '*' ) {
                        z[i] += 2*z[i-2];
                        z[i] %= MOD;
                    }
                    continue ;
                }
                if ( '1' <= c[i] && c[i] <= '6' ) {
                    z[i] += z[i-1]; z[i] %= MOD;
                    if ( i >= 2 && c[i-1] == '1' ) {
                        z[i] += z[i-2];
                        z[i] %= MOD;
                    }
                    if ( i >= 2 && c[i-1] == '2' ) {
                        z[i] += z[i-2];
                        z[i] %= MOD;
                    }
                    if ( i >= 2 && c[i-1] == '*' ) {
                        z[i] += 2*z[i-2];
                        z[i] %= MOD;
                    }
                    continue ;
                }
                assert '7' <= c[i] && c[i] <= '9';
                z[i] += z[i-1]; z[i] %= MOD;
                if ( i >= 2 && c[i-1] == '1' ) {
                    z[i] += z[i-2];
                    z[i] %= MOD;
                }
                if ( i >= 2 && c[i-1] == '*' ) {
                    z[i] += z[i-2];
                    z[i] %= MOD;
                }
            }
        }
    	return (int)(z[n]%MOD);
    }
}