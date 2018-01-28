class Solution {
private static class Element {
		public String string;
		public int dist;
		public Element(String string , int dist) {
			this.string = string;
			this.dist = dist;
		}
	}
	
	private String getString(int[][] board) {
		
		StringBuilder builder = new StringBuilder();
		int i , j , n = board.length , m = board[0].length;
		for (i = 0;i < n;i ++) {
			for (j = 0;j < m;j ++) {
				builder.append(board[i][j]);
			}
		}
		return builder.toString();
		
	}
	
	private int[][] getBoard(String string) {
		
		int[][] ans = new int[2][3];
		int x = 0 , y = 0;
		for (int i = 0;i < string.length();i ++) {
			ans[x][y] = string.charAt(i) - '0';
			if (y == 2) {
				x ++;
				y = 0;
			} else {
				y ++;
			}
		}
		return ans;
		
	}
	
	private int[] dx = new int[] {- 1 , 0 , 1 , 0};
	private int[] dy = new int[] {0 , 1 , 0 , - 1};
	
    public int slidingPuzzle(int[][] board) {
     
    	Set<String> set = new HashSet<>();
    	String string = getString(board);
    	if (string.equals("123450")) {
    		return 0;
    	} else {
    		Queue<Element> queue = new LinkedList<>();
    		queue.add(new Element(string , 0));
    		set.add(string);
    		while (!queue.isEmpty()) {
    			Element e = queue.poll();
    			String current = e.string;
    			int[][] matrix = getBoard(current);
    			int x = 0 , y = 0;
    			int i , j;
    			for (i = 0;i < 2;i ++) {
    				for (j = 0;j < 3;j ++) {
    					if (matrix[i][j] == 0) {
    						x = i;
    						y = j;
    						break;
    					}
    				}
    			}
    			for (i = 0;i < 4;i ++) {
    				int tx = x + dx[i];
    				int ty = y + dy[i];
    				if (tx >= 0 && tx < 2 && ty >= 0 && ty < 3) {
    					int temp = matrix[x][y];
    					matrix[x][y] = matrix[tx][ty];
    					matrix[tx][ty] = temp;
    					
    					String s = getString(matrix);
    					if (s.equals("123450")) {
    						return e.dist + 1;
    					}
    					if (!set.contains(s)) {
	    					set.add(s);
	    					queue.add(new Element(s , e.dist + 1));
    					}
    					
    					temp = matrix[x][y];
    					matrix[x][y] = matrix[tx][ty];
    					matrix[tx][ty] = temp;
    				}
    			}
    		}
    	}
    	return - 1;
    	
    }
	
}