class Solution {
    int[] parent;
    int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        if (n==0)
            return 0;
        m = grid[0].length;
        if (m==0)
            return 0;
        
        parent = new int[n * m];
        for (int i=0; i<n*m; i++)
            parent[i] = i;
        
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                if (grid[i][j]>0) {
                int x = getNum(i,j);
                int y = -1;
                if (i>0 && grid[i-1][j]>0){
                    y = getNum(i-1,j);
                    parent[find(x)] = find(y);
                }
                if (j>0 && grid[i][j-1]>0){
                    y = getNum(i, j-1);
                    parent[find(x)] = find(y);
                }    
            }
        
        int res = 0;
        int[] count = new int[n*m];
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++)
                if (grid[i][j]>0){
                    count[find(getNum(i,j))]++;
                    res = Math.max(count[find(getNum(i,j))], res);
        }
        return res;
    }
    
    private int getNum(int x, int y){
        return x*m + y;
    }
    
    private int find(int x){
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}