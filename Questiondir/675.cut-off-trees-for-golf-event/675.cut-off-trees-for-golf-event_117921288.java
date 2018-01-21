class Solution {
	public int cutOffTree(List<List<Integer>> forest) {
		if (forest.size() == 0 || forest.get(0).size() == 0) return 0;
		int m = forest.size();
		int n = forest.get(0).size();
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (forest.get(i).get(j) > 1) {
					list.add(new int[] {i, j});
				}
			}
		}
		list.sort((a, b) -> {
			return forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]);
		});
		
		int ans = bfs(0, 0, list.get(0)[0], list.get(0)[1], forest);
		if (ans < 0) return -1;
		for (int i = 1; i < list.size(); i++) {
			int x0 = list.get(i - 1)[0];
			int y0 = list.get(i - 1)[1];
			int x1 = list.get(i)[0];
			int y1 = list.get(i)[1];
			int d = bfs(x0, y0, x1, y1, forest);
			if (d < 0) return -1;
			ans += d;
		}
		return ans;
	}
	
	int bfs(int x0, int y0, int x1, int y1, List<List<Integer>> forest) {
		if (x0 == x1 && y0 == y1) return 0;
		int m = forest.size();
		int n = forest.get(0).size();
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		int d[][] = new int[m][n];
		d[x0][y0] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{x0, y0});
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			for (int i = 0; i < 4; i++) {
				int r = x + dx[i];
				int c = y + dy[i];
				if (r >= 0 && r < m && c >= 0 && c < n && forest.get(r).get(c) >= 1 && d[r][c] == 0) {
					if (r == x && c == y) continue;
					d[r][c] = d[x][y] + 1;
					q.add(new int[] { r, c});
				}
			}
		}
		if (d[x1][y1] == 0) return -1;
		else return d[x1][y1];
	}
}