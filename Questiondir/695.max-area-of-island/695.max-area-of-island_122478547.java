class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        if (n==0) return 0;
        f = new int[n*m];
        for (int i = 0;i<n*m;i++) f[i] =-1;
        int ansnow = 0;
        for (int i = 0;i<m;i++)
            for (int j = 0;j<n;j++)
                if (grid[i][j]==1)
        {
            int x = i;
            int y = j;
            int id = x*n+y;
            if (f[id]!=-1) continue;//ans.add(ansnow);
            else
            {
                f[id] = id;
                int tmpid = (x-1)*n+y;
                ansnow++;
                if (x>0&&f[tmpid]!=-1&&getfa(tmpid)!=id)
                {
                    f[getfa(tmpid)] = id;
                    ansnow--;
                }
                tmpid = (x+1)*n+y;
                if (x+1<m&&f[tmpid]!=-1&&getfa(tmpid)!=id)
                {
                    f[getfa(tmpid)] = id;
                    ansnow--;
                }
                tmpid = x*n+y+1;
                if (y+1<n&&f[tmpid]!=-1&&getfa(tmpid)!=id)
                {
                    f[getfa(tmpid)] = id;
                    ansnow--;
                }
                tmpid = x*n+y-1;
                if (y>0&&f[tmpid]!=-1&&getfa(tmpid)!=id)
                {
                    f[getfa(tmpid)] = id;
                    ansnow--;
                }
                //ans.add(ansnow);
            }
        }
        for (int i = 0;i<n*m;i++) if (f[i]!=-1)f[i] = getfa(f[i]);
        int[] count = new int[n*m];
        for (int i = 0;i<n*m;i++) count[i] = 0;
        for (int i = 0;i<n*m;i++) if (f[i]!=-1) count[f[i]]++;
        int max = 0;
        for (int i = 0;i<n*m;i++) max = Math.max(max,count[i]);
        return max;
        
    }
    int getfa(int o)
    {
        if (f[o]==o) return o;
        else
        {
            f[o] = getfa(f[o]);
            return f[o];
        }
    }
    int[] f;
}