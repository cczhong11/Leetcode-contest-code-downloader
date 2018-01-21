class Solution {
    int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
    int m, n;
    public int containVirus(int[][] grid) {
    	m = grid.length; n = grid[0].length;
    	int res = 0;
    	while (true) {
	    	boolean [][] v = new boolean[m][n];
	    	//int max = 0;
	    	int[] cur = new int[4];
	    	for (int i=0;i<m;i++) {
	    		for (int j=0;j<n;j++) {
	    			if (grid[i][j]==1 && !v[i][j]) {
	    				boolean[][] z = new boolean[m][n];
	    				int[] rt = new int[2];
	    				dfs(grid,v,z,rt,i,j);
	    				//if (rt[0]==0) 
	    				if (rt[0]>cur[0]) {
	    					cur[0] = rt[0];
	    					cur[1] = rt[1];
	    					cur[2] = i;
	    					cur[3] = j;
	    				}
	    			}
	    		}
	    	}
	    	if (cur[0] == 0) {
	    		return res;
	    	}
	    	res += cur[1];
	    	dfs1(grid, cur[2], cur[3]);
	    	for (int i=0;i<m;i++) {
	    		for (int j=0;j<n;j++) {
	    			if (grid[i][j]==0) {
	    				for(int k=0;k<4;k++) {
	    		    		int x = i+dir[k][0], y = j+dir[k][1];
	    		    		if (x>=0 && x<m && y>=0 && y<n) {
	    		    			if (grid[x][y]==1) {
	    		    				grid[i][j] = 3;
	    		    				break;
	    		    			}
	    		    		}
	    				}
	    			}
	    		}
    		}
	    	for (int i=0;i<m;i++) {
	    		for (int j=0;j<n;j++) {
	    			if (grid[i][j]==3) {
	    				grid[i][j]=1;
	    			}
	    		}
    		}
	    	res= res;
    	}
        //return res;
    }
    void dfs1(int[][]grid, int i, int j) {
    	grid[i][j] = 2;
    	for(int k=0;k<4;k++) {
    		int x = i+dir[k][0], y = j+dir[k][1];
    		if (x>=0 && x<m && y>=0 && y<n) {
    			if (grid[x][y]==1) {
    				dfs1(grid,x,y);
    			}
    		}
    	}
    }
    void dfs(int[][]grid, boolean[][]v, boolean[][] z, int[] rt,int i, int j) {
    	int[] res = new int[2];
    	v[i][j] = true;
    	for(int k=0;k<4;k++) {
    		int x = i+dir[k][0], y = j+dir[k][1];
    		if (x>=0 && x<m && y>=0 && y<n) {
    			if (grid[x][y]==0) {
    				rt[1]++;
    				if (!z[x][y]) {
    					z[x][y] = true;
    					rt[0]++;
    				}
    			}
    			if (grid[x][y]==1 && !v[x][y]) {
    				dfs(grid,v,z,rt,x,y);
    			}
    		}
    	}
    }
}