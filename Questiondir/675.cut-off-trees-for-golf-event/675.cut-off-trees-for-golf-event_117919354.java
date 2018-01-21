class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
    	if (forest.size() == 0 || forest.get(0).size() == 0) return 0;
        List<int[]> h = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) for (int j = 0; j < forest.get(0).size(); j++) {
        	if (forest.get(i).get(j) > 1) h.add(new int[] {forest.get(i).get(j), i, j});
        }
        Collections.sort(h, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}});
        int curRow = 0;
        int curCol = 0;
        int res = 0;
        int n = forest.size();
        int m = forest.get(0).size();
        int[][] dirs = new int[][] {{1,0},{0,-1}, {-1,0}, {0,1}};
        for (int i = 0; i < h.size(); i++) {
        	boolean[][] visited = new boolean[n][m];
        	int endRow = h.get(i)[1];
        	int endCol = h.get(i)[2];
        	Queue<Integer> q = new LinkedList<>();
        	int step = 0;
        	boolean canReach = false;
        	if (curRow != endRow || curCol != endCol) {
        		q.offer(curRow * m + curCol);
        		visited[curRow][curCol] = true;
        		while (!q.isEmpty() && !canReach) {
        			step++;
        			int size = q.size();
        			for (int j = 0; j < size; j++) {
        				int tmp = q.poll();
            			int r = tmp / m;
            			int c = tmp % m;
            			for (int k = 0; k < 4; k++) {
            				int nr = r + dirs[k][0];
            				int nc = c + dirs[k][1];
            				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]|| forest.get(nr).get(nc) == 0) continue;
            				if (nr == endRow && nc == endCol) {
            					canReach = true;
            					break;
            				}
            				visited[nr][nc] = true;
            				q.offer(nr * m + nc);
            			}
        			}
        		}
        	} else {
        		canReach = true;
        	}
        	if (!canReach) return -1;
        	res += step;
        	curRow = endRow;
        	curCol = endCol;
        }
        return res;
    }
}