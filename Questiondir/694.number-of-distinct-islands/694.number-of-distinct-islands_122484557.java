class Solution {
	List<List<int[]>> islands;
	
	List<int[]> islandNow;
	
	int count;
	int l;
	int r;
	int[][] grid;
	int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numDistinctIslands(int[][] grid) {
    	islands = new ArrayList<List<int[]>>();
        this.grid = grid;
        l = grid.length;
        if (l==0)
        	return 0;
        r = grid[0].length;
        if (r==0)
        	return 0;
        
        for (int i=0;i<l;++i)
        	for (int j=0;j<r;++j)
        		if (grid[i][j]>0) {
        			islandNow = new ArrayList<int[]>();
        			dfs(i,j,0,0);
        			check();
        		}
        
        return islands.size();
    }


	private void check() {
		boolean t = true;
		for (List<int[]> island:islands) {
			boolean k = true;
			if (island.size()!=islandNow.size())
				continue;
			for (int i=0;i<island.size();++i) {
				if (island.get(i)[0]!=islandNow.get(i)[0] || 
						island.get(i)[1]!=islandNow.get(i)[1]) {
					k = false;
					break;
				}
			}
			if (k) {
				t = false;
				break;
			}
		}
		if (t) {
			islands.add(islandNow);
		}
		
	}


	private void dfs(int i, int j,int ix, int iy) {
		++count;
		int[] now = {ix,iy};
		islandNow.add(now);
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
			dfs(x,y,ix+move[k][0],iy+move[k][1]);
			
		}
		
	}
}