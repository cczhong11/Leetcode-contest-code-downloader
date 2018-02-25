class Solution {
	List<Integer> arrayToList(int[][] board) {
		List<Integer> list = new ArrayList<>();
		int m = board.length;
		int n = board[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				list.add(board[i][j]);
			}
		}
		
		return list;
	}
	
	int[][] listToArray(List<Integer> list) {
		int[][] board = new int[2][3];
		board[0][0] = list.get(0);
		board[0][1] = list.get(1);
		board[0][2] = list.get(2);
		board[1][0] = list.get(3);
		board[1][1] = list.get(4);
		board[1][2] = list.get(5);
		return board;
	}
	
    public int slidingPuzzle(int[][] board) {
        int[][] target = {{1,2,3},{4,5,0}};
        List<Integer> targetList = arrayToList(target);
        
        Map<List<Integer>, Integer> dis = new HashMap<>();
        Queue<List<Integer>> q = new ArrayDeque<>();
        List<Integer> src = arrayToList(board);
        
        dis.put(src, 0);
        q.add(src);
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
        		List<Integer> state = q.poll();
        		int d = dis.get(state);
        		if (state.equals(targetList)) {
        			return d;
        		}
        		
        		int[][] b = listToArray(state);
        		int x = 0, y = 0;
        		for (int i = 0; i < 2; i++) {
        			for (int j = 0; j < 3; j++) {
        				if (b[i][j] == 0) {
        					x = i;
        					y = j;
        					break;
        				}
        			}
        		}
        		
        		for (int i = 0; i < dx.length; i++) {
        			int r = x + dx[i];
        			int c = y + dy[i];
        			
        			if (r >= 0 && r < 2 && c >= 0 && c < 3) {
        				int t = b[x][y];
        				b[x][y] = b[r][c];
        				b[r][c] = t;
        				List<Integer> newState = arrayToList(b);
        				if (!dis.containsKey(newState)) {
        					dis.put(newState, d + 1);
        					q.add(newState);
        				}
        				t = b[x][y];
        				b[x][y] = b[r][c];
        				b[r][c] = t;
        			}
        		}
        		
        }
        return -1;
        
    }
}