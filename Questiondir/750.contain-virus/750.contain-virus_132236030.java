class Solution {
    boolean[][] wallL;
    boolean[][] wallU;
    boolean changed=true;
    int ans=0;
    void dfs(int[][] grid,int n,int m,boolean[][] bo,boolean[][] inf,int x,int y)
    {
        if (bo[x][y]) return;
        if (grid[x][y]==0)
        {
            inf[x][y]=true;
            return;
        }
        bo[x][y]=true;
        if (!wallU[x][y]) dfs(grid,n,m,bo,inf,x-1,y);
        if (!wallU[x+1][y]) dfs(grid,n,m,bo,inf,x+1,y);
        if (!wallL[x][y]) dfs(grid,n,m,bo,inf,x,y-1);
        if (!wallL[x][y+1]) dfs(grid,n,m,bo,inf,x,y+1);
    }
    void infect(int[][] grid,int n,int m,boolean[][] bo,int x,int y)
    {
        if (bo[x][y]) return;
        bo[x][y]=true;
        if (grid[x][y]==0)
        {
            grid[x][y]=1;
            changed=true;
            return;
        }
        if (!wallU[x][y]) infect(grid,n,m,bo,x-1,y);
        if (!wallU[x+1][y]) infect(grid,n,m,bo,x+1,y);
        if (!wallL[x][y]) infect(grid,n,m,bo,x,y-1);
        if (!wallL[x][y+1]) infect(grid,n,m,bo,x,y+1);
    }
    void buildWall(int[][] grid,int n,int m,boolean[][] bo,int x,int y)
    {
        //if (x==0 && y==1) ans=1234567;
        if (bo[x][y]) return;
        bo[x][y]=true;
        if (!wallU[x][y]) 
        {
            if (grid[x-1][y]==0)
            {
                wallU[x][y]=true;
                ans++;
            }
            else buildWall(grid,n,m,bo,x-1,y);
        }
        if (!wallU[x+1][y]) 
        {
            if (grid[x+1][y]==0)
            {
                wallU[x+1][y]=true;
                ans++;
            }
            else buildWall(grid,n,m,bo,x+1,y);
        }
        if (!wallL[x][y])
        {
            if (grid[x][y-1]==0)
            {
                wallL[x][y]=true;
                ans++;
            }
            else buildWall(grid,n,m,bo,x,y-1);
        }
        if (!wallL[x][y+1])
        {
            if (grid[x][y+1]==0)
            {
                wallL[x][y+1]=true;
                ans++;
            }
            else buildWall(grid,n,m,bo,x,y+1);
        }
    }
    public int containVirus(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        wallL=new boolean[n][m+1];
        wallU=new boolean[n+1][m];
        for (int j=0;j<m;j++) wallU[0][j]=true;
        for (int j=0;j<m;j++) wallU[n][j]=true;
        for (int i=0;i<n;i++) wallL[i][0]=true;
        for (int i=0;i<n;i++) wallL[i][m]=true;
        int c=0;
        while (changed)
        {
            boolean[][] bo=new boolean[n][m];
            int max=0,maxi=0,maxj=0;
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    if (!bo[i][j] && grid[i][j]==1)
                    {
                        boolean[][] inf=new boolean[n][m];
                        dfs(grid,n,m,bo,inf,i,j);
                        int count=0;
                        for (int k=0;k<n;k++)
                            for (int l=0;l<m;l++)
                                if (inf[k][l]) count++;
                        if (count>max)
                        {
                            max=count;
                            maxi=i;
                            maxj=j;
                        }
                    }
            bo=new boolean[n][m];
            buildWall(grid,n,m,bo,maxi,maxj);
            bo=new boolean[n][m];
            changed=false;
            for (int i=0;i<n;i++)
                for (int j=0;j<m;j++)
                    if (!bo[i][j] && grid[i][j]==1) infect(grid,n,m,bo,i,j);
            c++;
        }
        return ans;
    }
}