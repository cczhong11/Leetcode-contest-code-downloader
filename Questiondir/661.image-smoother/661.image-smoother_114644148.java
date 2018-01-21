class Solution {
   public int[][] imageSmoother(int[][] a) {
        int[] DX9 = {0, 1, 1, 1, 0, -1, -1, -1, 0};
        int[] DY9 = {0, -1, 0, 1, 1, 1, 0, -1, -1};
        int[][] res = new int[a.length][a[0].length];
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[0].length; col++) {
                int top = 0;
                int bottom = 0;
                for (int dir = 0; dir < DX9.length; dir++) {
                    int nrow = row + DX9[dir];
                    int ncol = col + DY9[dir];
                    if (nrow >= 0 && nrow < a.length && ncol >= 0 && ncol < a[0].length) {
                        bottom++;
                        top += a[nrow][ncol];
                    }
                }
                res[row][col] = (top - top % bottom) / bottom;
            }
        }
        return res;
    }
}