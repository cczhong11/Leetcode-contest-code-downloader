
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.containVirus(new int[][]{
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
        }));

        System.out.println(sol.containVirus(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        }));

        System.out.println(sol.containVirus(new int[][]{
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
        }));

        System.out.println(sol.containVirus(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        }));

        System.out.println(sol.containVirus(new int[][]{
                {0, 1, 0, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0, 1, 1, 0, 1}, {0, 0, 0, 1, 0, 1, 0, 1, 1, 1}, {0, 1, 0, 0, 1, 0, 0, 1, 1, 0}, {0, 1, 0, 1, 0, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 1, 1, 0, 0, 1}, {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
        }));

        System.out.println(sol.containVirus(new int[][]{
                {0, 1, 0, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
        }));


    }

    int[][] visited;
    int[][] threaten;
    int[][] a;
    int r, c;
    int ts;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};


    int cell, edge;


    private void dfs(int i, int j) {
        visited[i][j] = ts;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < r && y >= 0 && y < c) {
                if (a[x][y] == 1 && visited[x][y] >= 0 && visited[x][y] < ts) {
                    dfs(x, y);
                } else {
                    if (a[x][y] == 0) {
                        edge++;
                        if (threaten[x][y] < ts) {
                            cell++;
                            threaten[x][y] = ts;
                        }
                    }
                }
            }
        }
    }

    private int doit() {
//        for (int i = 0; i < r; i++) {
//            System.out.println(Arrays.toString(a[i]) + " " + Arrays.toString(visited[i]));
//        }
//        System.out.println();

        int maxCell = 0, maxEdge = 0, maxTs = 0, ans = 0;
        int lb = ts;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 1 && visited[i][j] >= 0 && visited[i][j] <= lb) {
                    cell = edge = 0;
                    ts++;
                    dfs(i, j);
                    if (cell > maxCell) {
                        maxCell = cell;
                        maxEdge = edge;
                        maxTs = ts;
                    }
                }
            }
        if (maxCell > 0) {
//            System.out.println("max = " + maxCell + ", maxTx = " + maxTs);
            ans = maxEdge;
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    if (visited[i][j] == maxTs) {
                        visited[i][j] = -visited[i][j];
                    }
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++) {
                    if (visited[i][j] > lb) {
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if (x >= 0 && x < r && y >= 0 && y < c && visited[x][y] >= 0) {
                                a[x][y] = 1;
                            }
                        }
                    }
                }
            ans += doit();
        }
        return ans;
    }

    public int containVirus(int[][] grid) {
        a = grid;
        r = grid.length;
        c = grid[0].length;
        visited = new int[r][c];
        threaten = new int[r][c];
        ts = 0;
        return doit();
    }
}

