class Solution {
    int n = 0;
    int m = 0;
    boolean inMap(int x,int y)
    {
        if (x>=0&&x<n&&y>=0&&y<m)
             return true;
        else return false;
    }
    int encode(int x, int y)
    {
        return x*m+y;
    }
    boolean isSame(int a,int ah,int b, int bh)
    {
        if (ah/m-a/m!=bh/m-b/m) return false;
        if (ah%m-a%m!=bh%m-b%m) return false;
        else return true;
    }
    public int numDistinctIslands(int[][] grid) {
        n = grid.length;
        if (n==0) return 0;
        m = grid[0].length;
        if (m==0) return 0;
        List<Integer>[] island = new List[n*m];
        int[] islandPoint = new int[n*m];
        int[] q = new int[n*m];
        for (int i = 0;i<n*m;i++) island[i] = null;
        int numOfisland = 0;
        boolean[][] check = new boolean[n][m];
        for (int i = 0;i<n;i++)
            for (int j = 0;j<m;j++) check[i][j] = true;
        for (int i = 0;i<n;i++)
            for (int j = 0;j<m;j++)
                if (check[i][j]&&grid[i][j]==1)
                {
                    int l = -1;
                    int r = 0;
                    islandPoint[numOfisland] = encode(i,j);
                    q[0] = encode(i,j);
                    check[i][j] = false;
                    while (l<r)
                    {
                        l++;
                        int nowx = q[l]/m;
                        int nowy = q[l]%m;
                        int tmpx;
                        int tmpy;
                        tmpx = nowx-1;
                        tmpy = nowy;
                        if (inMap(tmpx,tmpy)&&grid[tmpx][tmpy]==1&&check[tmpx][tmpy])
                        {
                            r++;
                            q[r] = encode(tmpx,tmpy);
                            check[tmpx][tmpy] = false;
                        }
                        tmpx = nowx+1;
                        tmpy = nowy;
                        if (inMap(tmpx,tmpy)&&grid[tmpx][tmpy]==1&&check[tmpx][tmpy])
                        {
                            r++;
                            q[r] = encode(tmpx,tmpy);
                            check[tmpx][tmpy] = false;
                        }
                        tmpx = nowx;
                        tmpy = nowy-1;
                        if (inMap(tmpx,tmpy)&&grid[tmpx][tmpy]==1&&check[tmpx][tmpy])
                        {
                            r++;
                            q[r] = encode(tmpx,tmpy);
                            check[tmpx][tmpy] = false;
                        }
                        tmpx = nowx;
                        tmpy = nowy+1;
                        if (inMap(tmpx,tmpy)&&grid[tmpx][tmpy]==1&&check[tmpx][tmpy])
                        {
                            r++;
                            q[r] = encode(tmpx,tmpy);
                            check[tmpx][tmpy] = false;
                        }
                    }
                    List<Integer> tmplist = new ArrayList<Integer>();
                    for (int ii = 0;ii<=r;ii++)
                        tmplist.add(q[ii]);
                    island[numOfisland++] = tmplist;
                }
        boolean[] ti = new boolean[numOfisland];
        for (int i = 0;i<numOfisland;i++) ti[i] = true;
        for (int i = 0;i<numOfisland;i++)
            for (int j = i;j<numOfisland;j++)
                if (i!=j&&ti[j]&&island[i].size()==island[j].size())
                {
                    boolean flag = true;
                    for (int k = 0;k<island[i].size();k++)
                        if (!isSame(island[i].get(k),islandPoint[i],island[j].get(k),islandPoint[j]))
                        {
                            flag = false;
                            break;
                        }
                    if (flag) ti[i] = false;
                }
        int ans = 0;
        for (int i = 0;i<numOfisland;i++) if (ti[i]) ans++;
        return ans;
    }
}