class Solution {
    int[][] grid;
    
    int dfs(int i, int j) {
        int t=1;
        grid[i][j]=0;
        if(i>0&&grid[i-1][j]==1)
            t+=dfs(i-1, j);
        if(i<grid.length-1&&grid[i+1][j]==1)
            t+=dfs(i+1, j);
        if(j>0&&grid[i][j-1]==1)
            t+=dfs(i, j-1);
        if(j<grid[0].length-1&&grid[i][j+1]==1)
            t+=dfs(i, j+1);
        return t;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        this.grid=grid;
        try{
        for(int i=0; i<grid.length; ++i)
            for(int j=0; j<grid[0].length; ++j)
                if(grid[i][j]==1)
                    max=Math.max(dfs(i, j), max);
        }catch(Exception e){System.out.println(e);}
        return max;
    }
}