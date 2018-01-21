class Solution {
	private static class Element {
		public int x , y;
		public Element(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private int[] dx = new int[] {- 1 , 0 , 1 , 0};
	private int[] dy = new int[] {0 , 1 , 0 , - 1};
	
	private int bfs(int[][] grid , int x , int y) {
		
		Queue<Element> queue = new LinkedList<>();
		queue.add(new Element(x , y));
		grid[x][y] = 0;
		int n = grid.length , m = grid[0].length , ans = 0;
		while (!queue.isEmpty()) {
			Element e = queue.poll();
			ans ++;
			for (int i = 0;i < 4;i ++) {
				int tx = e.x + dx[i];
				int ty = e.y + dy[i];
				if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
					if (grid[tx][ty] == 1) {
						grid[tx][ty] = 0;
						queue.add(new Element(tx , ty));
					}
				}
			}
		}
		return ans;
		
	}
	
    public int maxAreaOfIsland(int[][] grid) {
        
    	int i , j , n = grid.length;
    	if (n > 0) {
    		int m = grid[0].length;
    		if (m > 0) {
    			int ans = 0;
    			for (i = 0;i < n;i ++) {
    				for (j = 0;j < m;j ++) {
    					if (grid[i][j] == 1) {
    						int temp = bfs(grid , i , j);
    						if (temp > ans) {
    							ans = temp;
    						}
    					}
    				}
    			}
    			return ans;
    		}
    	}
    	return 0;
    	
    }
}