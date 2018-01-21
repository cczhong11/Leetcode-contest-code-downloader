class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n = image[0].length;
		dfs(image, new boolean[m][n], sr, sc, newColor, image[sr][sc]);
		return image;
	}
	
	void dfs(int[][] image, boolean[][] vst, int x, int y, int newColor, int oldColor) {
		int m = image.length;
		int n = image[0].length;
		if (!(x >= 0 && x < m && y >= 0 && y < n)) {
			return;
		}
		if (image[x][y] != oldColor) {
			return;
		}
		if (vst[x][y]) return;
		vst[x][y] = true;
		image[x][y] = newColor;
		dfs(image, vst, x + 1, y, newColor, oldColor);
		dfs(image, vst, x - 1, y, newColor, oldColor);
		dfs(image, vst, x, y + 1, newColor, oldColor);
		dfs(image, vst, x, y - 1, newColor, oldColor);
	}
}