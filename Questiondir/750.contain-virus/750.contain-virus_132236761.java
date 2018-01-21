class Solution {
	private static int FLAG = 1;
	private void dfs(int[][] grid, int x, int y, int flag, boolean[][] vst, List<int[]> a, List<int[]> cells) {
		int m = grid.length;
		int n = grid[0].length;

		if (!(x >= 0 && x < m && y >= 0 && y < n)) {
			return;
		}
		
		if (grid[x][y] <= 0 || grid[x][y] == flag) {
			return;
		}
		
		if (vst[x][y]) {
			return;
		}
		
		vst[x][y] = true;
		a.add(new int[] {x, y});
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		for (int i = 0; i < dx.length; i++) {
			int r = x + dx[i];
			int c = y + dy[i];
			if (!(r >= 0 && r < m && c >= 0 && c < n)) {
				continue;
			}
			if (grid[r][c] == 0) {
				grid[r][c] = flag;
				cells.add(new int[] { r, c });
			} else if (grid[r][c] < 0 || grid[r][c] == flag) {
				continue;
			} else {
				dfs(grid, r, c, flag, vst, a, cells);
			}
		}
	}
	
	void printGrid(int[][] grid) {
		
		System.out.println("\n\n\n");
		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
	}

	public int containVirus(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };
		int ans = 0;
		while (true) {
			List<List<int[]>> blocks = new ArrayList<>();
			List<List<int[]>> cells = new ArrayList<>();
			
			boolean[][] vst = new boolean[m][n];
			FLAG++;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] > 0 && grid[i][j] < FLAG) {
						List<int[]> block = new ArrayList<>();
						List<int[]> tcells = new ArrayList<>();
						dfs(grid, i, j, FLAG, vst, block, tcells);
						
						
						blocks.add(block);
						cells.add(tcells);
						
						for (int k = 0; k < tcells.size(); k++) {
							int[] pos = tcells.get(k);
							grid[pos[0]][pos[1]] = 0;
						}
					}
				}
			}
			
			if (blocks.size() == 0) {
				break;
			}
			
			int bIndex = 0;
			for (int i = 0; i < blocks.size(); i++) {
				if (cells.get(i).size() > cells.get(bIndex).size()) {
					bIndex = i;
				}
			}
			
			List<int[]> block = blocks.get(bIndex);
			for (int i = 0; i < block.size(); i++) {
				int x = block.get(i)[0];
				int y = block.get(i)[1];
				
				for (int j = 0; j < dx.length; j++) {
					int r = x + dx[j];
					int c = y + dy[j];
					if (!(r >= 0 && r < m && c >= 0 && c < n)) {
						continue;
					}
					if (grid[r][c] == 0) {
						ans++;
					}
				}
				grid[x][y] = -1;
			}
			
			for (int i = 0; i < blocks.size(); i++) {
				if (i == bIndex) continue;
				
				List<int[]> tcells = cells.get(i);
				for (int k = 0; k < tcells.size(); k++) {
					int[] pos = tcells.get(k);
					grid[pos[0]][pos[1]] = FLAG;
				}
			}
			
			//printGrid(grid);
		}
		return ans;
	}
}