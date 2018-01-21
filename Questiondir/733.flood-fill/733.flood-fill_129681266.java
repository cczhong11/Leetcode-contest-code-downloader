class Solution {
	private static class Position {
		public int x , y;
		public Position(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private boolean[][] vis;
	private int[] dx = new int[] {- 1 , 0 , 1 , 0};
	private int[] dy = new int[] {0 , 1 , 0 , - 1};
	
	private void bfs(int[][] image , int x , int y) {
		
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x , y));
		vis[x][y] = true;
		int color = image[x][y] , n = image.length , m = image[0].length;
		while (!queue.isEmpty()) {
			Position p = queue.poll();
			for (int i = 0;i < 4;i ++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				if (tx >= 0 && tx < n && ty >= 0 && ty < m && !vis[tx][ty] && image[tx][ty] == color) {
					vis[tx][ty] = true;
					queue.add(new Position(tx , ty));
				}
			}
		}
		
	}
	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     
    	int i , j , n = image.length , m = image[0].length;
    	vis = new boolean[n][m];
    	bfs(image , sr , sc);
    	for (i = 0;i < n;i ++) {
    		for (j = 0;j < m;j ++) {
    			if (vis[i][j]) {
    				image[i][j] = newColor;
    			}
    		}
    	}
    	return image;
    	
    }
}