class Solution {
	private static int[][] DELTAS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private List<Integer> minLand(int maxY, int maxX, Set<List<Integer>> lands) {
		List<Integer> minLand = Arrays.asList(maxY, maxX);
		for (List<Integer> land : lands) {
			if (land.get(0) < minLand.get(0) || land.get(0) == minLand.get(0) && land.get(1) < minLand.get(1)) {
				minLand = land;
			}
		}
		return minLand;
	}

	private boolean isSameIsland(int maxY, int maxX, Set<List<Integer>> island1, Set<List<Integer>> island2) {
		if (island1.size() != island2.size()) {
			return false;
		}
		List<Integer> minLand1 = minLand(maxY, maxX, island1);
		List<Integer> minLand2 = minLand(maxY, maxX, island2);
		int dy = minLand1.get(0) - minLand2.get(0);
		int dx = minLand1.get(1) - minLand2.get(1);
		for (List<Integer> land1 : island1) {
			List<Integer> land2 = Arrays.asList(land1.get(0) - dy, land1.get(1) - dx);
			if (!island2.contains(land2)) {
				return false;
			}
		}
		return true;
	}

	public int numDistinctIslands(int[][] grid) {
		boolean[][] inIsland = new boolean[grid.length][grid[0].length];
		List<Set<List<Integer>>> islands = new ArrayList<>();
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 0) {
					continue;
				}
				if (inIsland[y][x]) {
					continue;
				}
				Queue<List<Integer>> queue = new LinkedList<>();
				Set<List<Integer>> island = new HashSet<>();
				queue.offer(Arrays.asList(y, x));
				inIsland[y][x] = true;
				while (!queue.isEmpty()) {
					List<Integer> curr = queue.poll();
					island.add(curr);
					for (int[] delta : DELTAS) {
						int dy = curr.get(0) + delta[0];
						if (dy < 0 || dy >= grid.length) {
							continue;
						}
						int dx = curr.get(1) + delta[1];
						if (dx < 0 || dx >= grid[dy].length) {
							continue;
						}
						if (grid[dy][dx] == 0) {
							continue;
						}
						if (!inIsland[dy][dx]) {
							queue.offer(Arrays.asList(dy, dx));
							inIsland[dy][dx] = true;
						}
					}
				}
				boolean isNewIsland = true;
				for (Set<List<Integer>> currIsland : islands) {
					if (isSameIsland(grid.length, grid[0].length, island, currIsland)) {
						isNewIsland = false;
						break;
					}
				}
				if (isNewIsland) {
					islands.add(island);
				}
			}
		}
		return islands.size();
	}
}