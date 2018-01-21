class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    void helper(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || newColor == oldColor) {
            return;
        }
        if (image[r][c] == oldColor) {
            image[r][c] = newColor;
            helper(image, r + 1, c, oldColor, newColor);
            helper(image, r - 1, c, oldColor, newColor);
            helper(image, r, c + 1, oldColor, newColor);
            helper(image, r, c - 1, oldColor, newColor);
        }
    }
}