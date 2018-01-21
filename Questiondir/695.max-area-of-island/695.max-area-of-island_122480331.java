class Solution {
	int count;
	int l;
	int r;
	int[][] grid;
	int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        l = grid.length;
        int max=0;
        if (l==0)
        	return 0;
        r = grid[0].length;
        if (r==0)
        	return 0;
        
        for (int i=0;i<l;++i)
        	for (int j=0;j<r;++j)
        		if (grid[i][j]>0) {
        			count = 0;
        			dfs(i,j);
        			max = Math.max(count,max );
        		}
        
        return max;
    }


	private void dfs(int i, int j) {
		++count;
		grid[i][j]=-1;
		for (int k=0;k<4;++k) {
			int x = i+move[k][0];
			int y = j+move[k][1];
			if (x<0)
				continue;
			if (x>=l)
				continue;
			if (y<0)
				continue;
			if (y>=r) {
				continue;
			}
			if (grid[x][y]!=1)
				continue;
			dfs(x,y);
			
		}
		
	}
}