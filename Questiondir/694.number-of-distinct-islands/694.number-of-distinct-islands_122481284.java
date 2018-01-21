class Solution {
	private static class Element implements Comparable<Element>{
		public int x , y;
		public Element(int x , int y) {
			this.x = x;
			this.y = y;
		}
		public int hashCode() {
			return this.x * 31 + this.y;
		}
		public boolean equals(Object object) {
			Element e = (Element) object;
			return this.x == e.x && this.y == e.y;		
		}
		public int compareTo(Element e) {
			if (this.x < e.x) {				
				return - 1;
			} else if (this.x > e.x) {
				return 1;
			} else {
				if (this.y < e.y) {
					return - 1;
				} else if (this.y > e.y) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	
	private Set<List<Element>> set = new HashSet<>();
	private int[] dx = new int[] {- 1 , 0 , 1 , 0};
	private int[] dy = new int[] {0 , 1 , 0 , - 1};
	
	private List<Element> bfs(int[][] grid , int x , int y) {
		
		List<Element> list = new ArrayList<>();
		Queue<Element> queue = new LinkedList<>();
		queue.add(new Element(x , y));
		grid[x][y] = 0;
		int n = grid.length , m = grid[0].length;
		while (!queue.isEmpty()) {
			Element e = queue.poll();
			list.add(e);
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
		Collections.sort(list);
		return list;
		
	}
	
	private void getList(List<Element> list) {
		
		int x = list.get(0).x , y = list.get(0).y;
		for (Element e : list) {
			e.x -= x;
			e.y -= y;
		}
		
	}
	
    public int numDistinctIslands(int[][] grid) {
        
    	int i , j , n = grid.length;
    	if (n > 0) {
    		int m = grid[0].length;
    		if (m > 0) {
                set.clear();
    			for (i = 0;i < n;i ++) {
    				for (j = 0;j < m;j ++) {
    					if (grid[i][j] == 1) {
    						List<Element> list = bfs(grid , i , j);
    						getList(list);
    						set.add(list);
    					}
    				}
    			}
    			return set.size();
    		}
    	}
    	return 0;
    	
    }
}