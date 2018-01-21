import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();


    }


    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private void dfs(int[][] a, int i, int j, int oldColor, int newColor) {
        if (a[i][j] == newColor) return;
        a[i][j] = newColor;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == oldColor) {
                dfs(a, x, y, oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
}