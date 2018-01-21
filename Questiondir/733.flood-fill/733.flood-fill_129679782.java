class Solution {
    public void dfs(int r, int c, int[][] image, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length)
            return;
        if (image[r][c] != color)
            return;
        image[r][c] = -1;
        dfs(r - 1, c, image, color);
        dfs(r + 1, c, image, color);
        dfs(r, c - 1, image, color);
        dfs(r, c + 1, image, color);
    }
        
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(sr, sc, image, image[sr][sc]);
        for (int r = 0; r < image.length; r++)
            for (int c = 0; c < image[0].length; c++)
                if (image[r][c] == -1)
                    image[r][c] = newColor;
        return image;
    }
}