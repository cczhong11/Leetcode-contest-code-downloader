class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        int row = image.length;
        int col = image[0].length;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        rowList.add(sr);
        colList.add(sc);
        boolean mark[][] = new boolean[row][col];
        int color = image[sr][sc];
        mark[sr][sc] = true;
        for (int i = 0; i < rowList.size(); i++) {
            int r = rowList.get(i);
            int c = colList.get(i);
            image[r][c] = newColor;
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !mark[nr][nc] && image[nr][nc] == color) {
                    mark[nr][nc] = true;
                    rowList.add(nr);
                    colList.add(nc);
                }
            }
        }
        return image;
    }
}