class Solution {
    boolean visited[][];
    int grid[][];
    int area;
    public int maxAreaOfIsland(int[][] g) {
        grid = g;
        visited=new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i=0;i<g.length;i++) {
            for(int j=0;j<g[0].length;j++) {
                if (visited[i][j])continue;
                if (grid[i][j]==0)continue;
                area=0;
                dfs(i, j);
                max=Math.max(area, max);
            }
        }
        return max;
    }
    
    public void dfs(int r, int c) {
        
        if (r==-1)return;
        if (c==-1)return;
        if (r==visited.length)return;
        if (c==visited[0].length)return;
        //System.out.println(r+" "+c);
        if (grid[r][c]!=1)return;
        if (visited[r][c])return;
        area++;
        visited[r][c]=true;
        dfs(r+1,c);
        dfs(r-1,c);
        dfs(r,c+1);
        dfs(r,c-1);
    }
}