class Solution {
    int[][] g;
    int n,m;
    int sum=0;
    void dfs(List<int[]> list,int x,int y,int p,int q)
    {
        if (g[x][y]==0) return;
        list.add(new int[]{x-p,y-q});
        g[x][y]=0;
        if (x>0) dfs(list,x-1,y,p,q);
        if (x<n-1) dfs(list,x+1,y,p,q);
        if (y>0) dfs(list,x,y-1,p,q);
        if (y<m-1) dfs(list,x,y+1,p,q);
    }
    boolean equal(List<int[]> b,List<int[]> c)
    {
        if (b.size()!=c.size()) return false;
        int n=b.size();
        for (int i=0;i<n;i++)
            if (b.get(i)[0]!=c.get(i)[0] || b.get(i)[1]!=c.get(i)[1]) return false;
        return true;
    }
    public int numDistinctIslands(int[][] grid) {
        n=grid.length;
        if (n==0) return 0;
        m=grid[0].length;
        if (m==0) return 0;
        g=grid;
        List<List<int[]>> a=new ArrayList<>();
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (grid[i][j]==1)
                {
                    List<int[]> list=new ArrayList<>();
                    dfs(list,i,j,i,j);
                    boolean bo=true;
                    for (List<int[]> ll:a)
                        if (equal(list,ll)) 
                        {
                            bo=false;
                            break;
                        }
                    if (bo) a.add(list);
                }
        return a.size();
    }
}