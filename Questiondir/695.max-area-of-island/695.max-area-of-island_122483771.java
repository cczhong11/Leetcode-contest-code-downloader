class Solution {
	private static int[][] DELTAS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		boolean[][] inIsland = new boolean[grid.length][grid[0].length];
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 0) {
					continue;
				}
				if (inIsland[y][x]) {
					continue;
				}
				Queue<int[]> queue = new LinkedList<>();
				int area = 0;
				queue.offer(new int[] { y, x });
				inIsland[y][x] = true;
				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					area++;
					for (int[] delta : DELTAS) {
						int dy = curr[0] + delta[0];
						if (dy < 0 || dy >= grid.length) {
							continue;
						}
						int dx = curr[1] + delta[1];
						if (dx < 0 || dx >= grid[dy].length) {
							continue;
						}
						if (grid[dy][dx] == 0) {
							continue;
						}
						if (!inIsland[dy][dx]) {
							queue.offer(new int[] { dy, dx });
							inIsland[dy][dx] = true;
						}
					}
				}
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}
}