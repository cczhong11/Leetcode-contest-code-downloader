class Solution {

    public int numDistinctIslands(int[][] grid) {
        HashSet<Island> islands = new HashSet<Island>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
            	if (grid[i][j] != 0) {
            		Island isl = getIsland(grid, i, j);
            		islands.add(isl.getNormalized());
            	}
            }
        }
        return islands.size();
    }
    
    private static final int[] DR = { -1, 0, 1, 0 };
    private static final int[] DC = { 0, 1, 0, -1 };
    
    private Island getIsland(int[][] grid, int r, int c) {
    	Island isl = new Island();
    	dfs(grid, r, c, isl);
    	return isl;
    }

    private void dfs(int[][] grid, int r, int c, Island isl) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
    	isl.add(new Point(r, c));
        
        for (int d = 0; d < 4; ++d) {
        	dfs(grid, r + DR[d], c + DC[d], isl);
        }
    }
    
    public static class Island extends HashSet<Point> {
		private static final long serialVersionUID = 6032505216615042706L;
		
		public Island getNormalized() {
			Island isl = new Island();
			int minR = 100;
			int minC = 100;
			for (Point pt : this) {
				minR = Math.min(minR, pt.R);
				minC = Math.min(minC, pt.C);
			}
			for (Point pt : this) {
				isl.add(new Point(pt.R - minR, pt.C - minC));
			}
			return isl;
		}
    }
    
    public static class Point {
    	public int R, C;
    	
    	public Point(int r, int c) {
    		this.R = r;
    		this.C = c;
    	}
    	
    	@Override
    	public int hashCode() {
    		return R * 1000 + C;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		Point pt = (Point)obj;
    		return this.R == pt.R && this.C == pt.C;
    	}
    }
}