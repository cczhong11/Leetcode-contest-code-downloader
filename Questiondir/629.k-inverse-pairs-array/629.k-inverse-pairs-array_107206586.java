public class Solution {
    int mo=1000000007;
    public int kInversePairs(int n, int k) {
        int[][] f=new int[1002][1002];
        f[1][0]=1;
        for (int i=2;i<=n;i++)
        {
            f[i][0]=1;
            for (int j=1;j<=k;j++) 
            {
                f[i][j]=(f[i][j-1]+f[i-1][j])%mo;
                if (j>=i) f[i][j]=(f[i][j]-f[i-1][j-i]+mo)%mo;
            }
        }
        return f[n][k];
    }
}