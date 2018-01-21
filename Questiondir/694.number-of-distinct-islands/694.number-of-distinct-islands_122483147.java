class Solution {
    boolean visited[][];
    int grid[][];
    int area;
    int starti, startj;
    int count;
    StringBuffer sb;
    public int numDistinctIslands(int[][] g) {
        grid = g;
        visited=new boolean[grid.length][grid[0].length];
        int max = 0;
        HashSet<String> set= new HashSet();
        for(int i=0;i<g.length;i++) {
            for(int j=0;j<g[0].length;j++) {
                if (visited[i][j])continue;
                if (grid[i][j]==0)continue;
                starti=i; startj=j;
                sb = new StringBuffer();
                dfs(i, j);
                set.add(sb.toString());
            }
        }
        return set.size();
    }
    
    public void dfs(int r, int c) {
        
        if (r==-1)return;
        if (c==-1)return;
        if (r==visited.length)return;
        if (c==visited[0].length)return;
        if (grid[r][c]!=1)return;
        if (visited[r][c])return;
        visited[r][c]=true;
        sb.append("["+(r-starti)+",");
        sb.append((c-startj)+"]");
        dfs(r+1,c);
        dfs(r-1,c);
        dfs(r,c+1);
        dfs(r,c-1);
    }
}
