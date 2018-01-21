import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
	int[][] visited;
	
	void DFS(int[][] grid, int color, int r, int c, int row, int col) {
		if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0 || visited[r][c] == color) {
			return;
		}
		visited[r][c] = color;
		
		for (int dr = -1; dr <= 1; ++dr) {
			for (int dc = -1; dc <= 1; ++dc) {
				if (dr == 0 ^ dc == 0) {
					int nr = r + dr;
					int nc = c + dc;
					DFS(grid, color, nr, nc, row, col);
				}
			}
		}
	}
	
    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new int[row][col];
        
        int color = 0;
        for (int r = 0; r < row; ++r) {
        	for (int c = 0; c < col; ++c) {
        		if (grid[r][c] == 1 && visited[r][c] == 0) {
        			++color;
        			DFS(grid, color, r, c, row, col);
        		}
        	}
        }
        
        Set<String> set = new HashSet<String>();
        while (color > 0) {
        	int minCol = col, minRow = row;
        	for (int r = 0; r < row; ++r) {
        		for (int c = 0; c < col; ++c) {
        			if (visited[r][c] == color) {
        				minCol = Math.min(minCol, c);
        				minRow = Math.min(minRow, r);
        			}
        		}
        	}
        	StringBuilder sb = new StringBuilder();
        	for (int r = 0; r < row; ++r) {
        		for (int c = 0; c < col; ++c) {
        			if (visited[r][c] == color) {
        				int nr = r - minRow;
        				int nc = c - minCol;
        				int val = nr * 100 + nc;
        				sb.append(val);
        				sb.append("_");
        			}
        		}
        	}
        	set.add(sb.toString());
        	color--;
        }
        return set.size();
    }
}