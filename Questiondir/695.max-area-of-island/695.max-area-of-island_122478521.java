class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int[][] g;
    //boolean[][] bo;
    int n,m;
    int sum=0;
    void dfs(int x,int y)
    {
        if (g[x][y]==0) return;
        sum++;
        g[x][y]=0;
        if (x>0) dfs(x-1,y);
        if (x<n-1) dfs(x+1,y);
        if (y>0) dfs(x,y-1);
        if (y<m-1) dfs(x,y+1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        n=grid.length;
        if (n==0) return 0;
        m=grid[0].length;
        if (m==0) return 0;
        g=grid;
        //bo=new boolean[n][m];
        int max=0;
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (grid[i][j]==1)
                {
                    sum=0;
                    dfs(i,j);
                    max=Math.max(max,sum);
                }
        return max;
    }
}