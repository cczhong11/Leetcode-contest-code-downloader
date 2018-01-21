class Solution {
    public int[][] imageSmoother(int[][] M) {
        int w = M.length;
        int h = M[0].length;
        int[][] res = new int[w][h];
        for (int i = 0; i < w; i++) for (int j = 0; j < h; j++) {
            double sum = 0;
            int count = 0;
            for (int x = -1; x <= 1; x++) for (int y = -1; y <= 1; y++) {
                int nx = i + x;
                int ny = j + y;
                if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    sum += M[nx][ny];
                    count++;
                }
            }
            res[i][j] = (int) Math.floor(sum/count);
        }
        return res;
    }
}