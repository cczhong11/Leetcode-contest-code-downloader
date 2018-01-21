class Solution {
    int[][] grid;
    
    int dfs(int i, int j) {
        int t=1;
        grid[i][j]=0;
        if(i>0&&grid[i-1][j]==1)
            t+=19*dfs(i-1, j);
        if(i<grid.length-1&&grid[i+1][j]==1)
            t+=31*dfs(i+1, j);
        if(j>0&&grid[i][j-1]==1)
            t+=97*dfs(i, j-1);
        if(j<grid[0].length-1&&grid[i][j+1]==1)
            t+=193*dfs(i, j+1);
        return t;
    }
    
    public int numDistinctIslands(int[][] grid) {
        this.grid=grid;
        Set<Integer> visited = new HashSet<Integer>();
        int t=0;
        for(int i=0; i<grid.length; ++i) {
            for(int j=0; j<grid[0].length; ++j) {
                if(grid[i][j]==1) {
                    int c=dfs(i, j);
                    if(!visited.contains(c)) {
                        visited.add(c);
                        ++t;
                    }
                }
            }
        }
        return t;
    }
}