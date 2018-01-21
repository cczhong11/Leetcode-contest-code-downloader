import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        { int[][] a = {
//                    {0, 1, -1},
//                    {1, 0, -1},
//                    {1, 1, 1},
//            };
//            System.out.println(sol.cherryPickup(a));
//        }
//
//        {
//            int[][] a = {
//                    {0, 1, -1},
//                    {1, 0, -1},
//                    {1, 1, -1},
//            };
//            System.out.println(sol.cherryPickup(a));
//        }
//
//        {
//            int[][] a = {
//                    {1, 1, -1},
//                    {1, -1, 1},
//                    {-1, 1, 1},
//            };
//            System.out.println(sol.cherryPickup(a));
//        }

        {
            int[][] a = {
                    {1, 1, -1, 1, 1},
                    {1, 1, -1, 1, 1},
                    {1, 1, 1, -1, 1},
                    {0, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
            };
            System.out.println(sol.cherryPickup(a));
        }
    }

    int[][] a;

    int inf = 1 << 29;

    long val(int i, int j) {
        if (a[i][j] == 1)
            return 1;
        else if (a[i][j] == 0)
            return 0;
        else return -inf;
    }

    public int cherryPickup(int[][] grid) {
        a = grid;
        int n = grid.length;
        long[][][] f = new long[2 * n - 1][n][n];

        for (int i = 0; i < f.length; i++)
            for (int j = 0; j < f[i].length; j++)
                Arrays.fill(f[i][j], -inf);

        f[0][0][0] = val(0, 0);
        for (int t = 1; t <= 2 * n - 2; t++) {
            for (int i = 0; i <= t && i < n; i++)
                for (int x = 0; x <= t && x < n; x++) {
                    int j = t - i;
                    int y = t - x;
                    if (j >= n || y >= n) continue;

                    long val = i == x ? val(i, j) : (val(i, j) + val(x, y));

                    f[t][i][x] = Math.max(f[t][i][x], f[t - 1][i][x] + val);
                    if (x - 1 >= 0)
                        f[t][i][x] = Math.max(f[t][i][x], f[t - 1][i][x - 1] + val);
                    if (i - 1 >= 0)
                        f[t][i][x] = Math.max(f[t][i][x], f[t - 1][i - 1][x] + val);
                    if (i - 1 >= 0 && x - 1 >= 0)
                        f[t][i][x] = Math.max(f[t][i][x], f[t - 1][i - 1][x - 1] + val);
                }

//            System.out.println(t);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++)
//                    System.out.print(f[t][i][j] + " ");
//                System.out.println();
//
//            }
//            System.out.println();
        }

        return (int) Math.max(f[2 * n - 2][n - 1][n - 1], 0);
    }
}