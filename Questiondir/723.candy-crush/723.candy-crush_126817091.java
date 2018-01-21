class Solution {
    public int[][] candyCrush(int[][] board) {
        while (true) {
            boolean crushed = crush(board);
            if (!crushed) break;
            drop(board);
        }
        return board;
    }

    boolean crush(int board[][]) {
        int r = board.length;
        int c = board[0].length;
        boolean flag[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) {
            if (board[i][j] == 0) continue;

            int vCount = 1;
            for (int rr = i-1; rr>=0 && vCount < 3; rr--) {
                if (board[rr][j] != board[i][j]) break;
                vCount++;
            }
            for (int rr = i+1; rr<r && vCount < 3; rr++) {
                if (board[rr][j] != board[i][j]) break;
                vCount++;
            }
            if (vCount >= 3) {
                flag[i][j] = true;
                continue;
            }

            int hCount = 1;
            for (int cc = j-1; cc>=0 && hCount < 3; cc--) {
                if (board[i][cc] != board[i][j]) break;
                hCount++;
            }
            for (int cc = j+1; cc<c && hCount < 3; cc++) {
                if (board[i][cc] != board[i][j]) break;
                hCount++;
            }
            if (hCount >= 3) flag[i][j] = true;
        }

        boolean ans = false;
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) {
            if (flag[i][j]) {
                ans = true;
                board[i][j] = 0;
            }
        }
        return ans;
    }

    void drop(int board[][]) {
        int r = board.length;
        int c = board[0].length;
        for (int i = r-1; i>=0; i--) for (int j = 0; j < c; j++) {
            if (board[i][j] == 0) continue;

            int k;
            for (k = i+1; k < r; k++) {
                if (board[k][j] != 0) {
                    k--;
                    break;
                }
            }
            if (k==r) k--;
            if (k != i) {
                board[k][j] = board[i][j];
                board[i][j] = 0;
            }
        }
    }
}