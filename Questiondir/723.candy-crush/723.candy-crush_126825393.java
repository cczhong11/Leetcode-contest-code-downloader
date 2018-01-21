class Solution {
    void fall(int[][] board) {
        int row = board.length, col = board[0].length;
        for (int r = row - 1; r >= 0; r--)
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 0)
                    continue;
                int tr = r;
                while (tr + 1 < row && board[tr + 1][c] == 0) {
                    board[tr + 1][c] = board[tr][c];
                    board[tr][c] = 0;
                    tr++;
                }
            }
    }
    boolean stable(int[][] board) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 0)
                    continue;
                if (r + 2 < row && board[r][c] == board[r + 1][c] && board[r][c] == board[r + 2][c])
                    return false;
                if (c + 2 < col && board[r][c] == board[r][c + 1] && board[r][c] == board[r][c + 2])
                    return false;
            }
        return true;
    }
    void remove(int[][] board, boolean[][] tb) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                tb[r][c] = false;
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 0)
                    continue;
                int left = r, right = r, len = 1;
                while (left - 1 >= 0 && board[left - 1][c] == board[r][c])
                    left--;
                while (right + 1 < row && board[right + 1][c] == board[r][c])
                    right++;
                len = Math.max(len, right - left + 1);
                left = c;
                right = c;
                while (left - 1 >= 0 && board[r][left - 1] == board[r][c])
                    left--;
                while (right + 1 < col && board[r][right + 1] == board[r][c])
                    right++;
                len = Math.max(len, right - left + 1);
                if (len >= 3)
                    tb[r][c] = true;
            }
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                if (tb[r][c])
                    board[r][c] = 0;
    }
    void print(int[][] board) {
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(board[r][c]);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("======================");
    }
    public int[][] candyCrush(int[][] board) {
        int row = board.length, col = board[0].length;
        boolean[][] tb = new boolean[row][col];
        fall(board);
        while (!stable(board)) {
            remove(board, tb);
            fall(board);
        }
        return board;
    }
}