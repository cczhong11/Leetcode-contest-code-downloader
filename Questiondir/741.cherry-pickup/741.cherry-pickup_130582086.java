class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][][][] f=new int[n][m][n][m];
        f[0][0][0][0]=grid[0][0];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                for (int k=0;k<n;k++)
                    {
                        if (i+j+k==0) continue;
                        int l=i+j-k;
                        if (l<0 || l>=n) continue;
                        f[i][j][k][l]=-100000000;
                        if (grid[i][j]==-1 || grid[k][l]==-1)
                        {
                            continue;
                        }
                        if (i>0 && k>0) f[i][j][k][l]=Math.max(f[i][j][k][l],f[i-1][j][k-1][l]);
                        if (j>0 && k>0) f[i][j][k][l]=Math.max(f[i][j][k][l],f[i][j-1][k-1][l]);
                        if (j>0 && l>0) f[i][j][k][l]=Math.max(f[i][j][k][l],f[i][j-1][k][l-1]);
                        if (i>0 && l>0) f[i][j][k][l]=Math.max(f[i][j][k][l],f[i-1][j][k][l-1]);
                        f[i][j][k][l]+=grid[i][j];
                        if (i!=k || j!=l) f[i][j][k][l]+=grid[k][l];
                    }
        if (f[n-1][m-1][n-1][m-1]<0) return 0; else return f[n-1][m-1][n-1][m-1];
    }
}