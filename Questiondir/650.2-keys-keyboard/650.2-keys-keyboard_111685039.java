public class Solution {
    public int minSteps(int n) {
        int[][] f=new int[n+1][n+1];
        f[1][1]=1;
        for (int i=2;i<=n;i++)
        {
            int min=100000000;
            for (int j=1;j<i;j++)
            {
                f[i][j]=(j<=i/2)?f[i-j][j]+1:100000000;
                min=Math.min(f[i][j],min);
            }
            f[i][i]=min+1;
        }
        return f[n][n]-1;
    }
}