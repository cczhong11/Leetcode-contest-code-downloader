class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) {
        	return image;
        }
        floodFill(image, sr, sc, color, newColor);
        return image;
    }
	
	private void floodFill(int[][] image, int sr, int sc, int color, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
			return;
		}
		if (image[sr][sc] != color) {
			return;
		}
		image[sr][sc] = newColor;
		floodFill(image, sr + 1, sc, color, newColor);
		floodFill(image, sr - 1, sc, color, newColor);
		floodFill(image, sr, sc + 1, color, newColor);
		floodFill(image, sr, sc - 1, color, newColor);
		
	}
}