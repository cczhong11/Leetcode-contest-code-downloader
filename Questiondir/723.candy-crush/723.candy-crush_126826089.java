import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    int r, c;

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] res = sol.candyCrush(new int[][]{
                {110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314}, {410, 411, 412, 5, 414}, {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714}, {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}
        });

        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }

    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};


    private void move(int[][] a) {
        for (int j = 0; j < c; j++) {
            int pos = r - 1;
            for (int i = r - 1; i >= 0; i--) {
                if (a[i][j] != 0) {
                    a[pos--][j] = a[i][j];
                }
            }
            for (int i = pos; i >= 0; i--) {
                a[i][j] = 0;
            }
        }
    }

    private int[][] doit(int[][] board) {
        boolean recur = false;
        r = board.length;
        c = board[0].length;

        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        System.out.println();

        boolean[][] delete = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; ) {
                if (board[i][j] == 0) {
                    j++;
                    continue;
                }

                int jj = j;
                for (; jj < c && board[i][j] == board[i][jj]; jj++) ;
                if (jj - j >= 3) {
                    for (int k = j; k < jj; k++) delete[i][k] = true;
                    recur = true;
                }
                j = jj;
            }
        }

        for (int j = 0; j < c; j++)
            for (int i = 0; i < r; ) {
                if (board[i][j] == 0) {
                    i++;
                    continue;
                }

                int ii = i;
                for (; ii < r && board[i][j] == board[ii][j]; ii++) ;
                if (ii - i >= 3) {
                    for (int k = i; k < ii; k++) delete[k][j] = true;
                    recur = true;
                }
                i = ii;
            }

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (delete[i][j]) {
                    board[i][j] = 0;
                }
        move(board);


        if (recur) {
            return doit(board);
        } else {
            return board;
        }

    }

    public int[][] candyCrush(int[][] board) {
        r = board.length;
        c = board[0].length;
        return doit(board);
    }
}
