class Solution {
    int[][] dir={{-1,0},{-1,1},{-1,-1},{0,-1},{0,1},{1,0},{1,-1},{1,1},{0,0}};
    boolean ok(int x,int y,int n,int m)
    {
        return (x>=0 && y>=0 && x<n && y<m);
    }
    public int[][] imageSmoother(int[][] M) {
        int n=M.length,m=M[0].length;
        int[][] a=new int[n][m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
            {
                int count=0,sum=0;
                for (int k=0;k<9;k++)
                    if (ok(i+dir[k][0],j+dir[k][1],n,m))
                    {
                        count++;
                        sum+=M[i+dir[k][0]][j+dir[k][1]];
                    }
                a[i][j]=sum/count;
            }
        return a;
    }
}