class Solution {
	boolean[][] visited;
	
	int DFS(int[][] grid, int r, int c, int row, int col) {
		if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0 || visited[r][c]) {
			return 0;
		}
		int res = 1;
		visited[r][c] = true;
		
		for (int dr = -1; dr <= 1; ++dr) {
			for (int dc = -1; dc <= 1; ++dc) {
				if (dr == 0 ^ dc == 0) {
					int nr = r + dr;
					int nc = c + dc;
					res += DFS(grid, nr, nc, row, col);
				}
			}
		}
		return res;
	}
	
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        
        int res = 0;
        for (int r = 0; r < row; ++r) {
        	for (int c = 0; c < col; ++c) {
        		if (grid[r][c] == 1 && !visited[r][c]) {
        			int area = DFS(grid, r, c, row, col);
        			res = Math.max(res, area);
        		}
        	}
        }
        return res;
    }
}