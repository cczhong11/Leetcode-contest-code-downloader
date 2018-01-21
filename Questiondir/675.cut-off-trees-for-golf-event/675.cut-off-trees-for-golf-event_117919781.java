class Solution {
	private static class Position implements Comparable<Position>{
		public int x , y;
		public int height;
		public Position(int x , int y , int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
		public int compareTo(Position position) {
			if (this.height < position.height) {
				return - 1;
			} else if (this.height > position.height) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	private int getDist(int x1 , int y1 , int x2 , int y2 , int n , int m) {
		
		if (x1 == x2 && y1 == y2) {
			return 0;
		}

		for (int i = 0;i < n;i ++) {
			for (int j = 0;j < m;j ++) {
				vis[i][j] = false;
			}
		}
		
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x1 , y1 , 0));
		
		vis[x1][y1] = true;
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			for (int i = 0;i < 4;i ++) {
				int tx = current.x + dx[i];
				int ty = current.y + dy[i];
				if (tx >= 0 && tx < n && ty >= 0 && ty < m && !vis[tx][ty]) {
					if (tx == x2 && ty == y2) {
						return current.height + 1;
					} else {
						if (matrix[tx][ty] >= 1) {
							vis[tx][ty] = true;
							queue.add(new Position(tx , ty , current.height + 1));
						}
					}
				}
			}
		}
		return - 1;
		
	}
	
	private int[] dx = new int[] {- 1 , 0 , 1 , 0};
	private int[] dy = new int[] {0 , 1 , 0 , - 1};
	private boolean[][] vis = new boolean[100][100];
	private int[][] matrix = new int[100][100];
	
    public int cutOffTree(List<List<Integer>> forest) {
    	
    	int i , j , n = forest.size();
    	if (n > 0) {
    		int m = forest.get(0).size();
    		if (m > 0) {
    			List<Position> list = new ArrayList<>();
    			for (i = 0;i < n;i ++) {
    				for (j = 0;j < m;j ++) {
    					matrix[i][j] = forest.get(i).get(j);
    					if (matrix[i][j] > 1) {
    						list.add(new Position(i , j , matrix[i][j]));
    					}
    				}
    			}
    			Collections.sort(list);
    			int x = 0 , y = 0 , ans = 0;
    			for (i = 0;i < list.size();i ++) {
    				int temp = getDist(x , y , list.get(i).x , list.get(i).y , n , m);
    				if (temp >= 0) {
    					x = list.get(i).x;
    					y = list.get(i).y;
    					matrix[x][y] = 1;
    					ans += temp;
    				} else {
    					return - 1;
    				}
    			}
    			return ans;
    		}
    	}
    	return 0;
    	
    }
}