class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    	int[][] g = new int[grid.length][];
    	for (int i = 0; i < grid.length; ++i) {
    		g[i] = new int[grid[i].length];
    		for (int j = 0; j < grid[i].length; ++j) {
    			g[i][j] = grid[i][j];
    		}
    	}
    	
        int best = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
            	if (grid[i][j] != 0) {
            		best = Math.max(best, bfs(g, i, j));
            	}
            }
        }
        return +best;
    }
    
    private static final int[] DR = { -1, 0, 1, 0 };
    private static final int[] DC = { 0, 1, 0, -1 };
    
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
            return 0;
        }
        
        grid[r][c] = 0;
        
        int cnt = 1;
        for (int d = 0; d < 4; ++d) {
            cnt += dfs(grid, r + DR[d], c + DC[d]);
        }
        return cnt;
    }
    
    private int bfs(int[][] grid, int r0, int c0) {
    	Queue<Integer> q = new ArrayDeque<Integer>();
    	int cnt = 1;
    	grid[r0][c0] = 0;
    	q.offer(r0);
    	q.offer(c0);
    	while (!q.isEmpty()) {
    		int r = q.poll();
    		int c = q.poll();
    		for (int d = 0; d < 4; ++d) {
    			int rn = r + DR[d];
    			int cn = c + DC[d];
    			if (land(grid, rn, cn)) {
    				grid[rn][cn] = 0;
    				q.offer(rn);
    				q.offer(cn);
    				++cnt;
    			}
    		}
    	}
    	return cnt;
    }
    
    private boolean land(int[][] grid, int r, int c) {
    	return (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] != 0);
    }
}