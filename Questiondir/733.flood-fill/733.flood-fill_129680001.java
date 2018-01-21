class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor) return image;
        int h = image.length;
        int w = image[0].length;
        Queue<int[]>q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.offer(new int[]{sr, sc});
        int[][] directions = {{0, 1},{0, -1},{1,0},{-1, 0}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir: directions){
                int y = cur[0] + dir[0];
                int x = cur[1] + dir[1];
                if(y >= 0 && x>=0 && y < h && x < w && image[y][x] == oldColor) {
                    image[y][x] = newColor;
                    q.offer(new int[]{y, x});
                }
            }
        }
        return image;
    }
}