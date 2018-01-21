class Solution {
    public int[][] candyCrush(int[][] board) {
        while (true) {
            boolean killed = iterate(board);
            // System.out.println(killed);
            if (!killed) {
                break;
            }
        }
        return board;
    }
    
    public static boolean iterate(int[][] board) {
        boolean killed = false;
        // horizontal
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j + 3 <= board[i].length; j++) {
                if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) && Math.abs(board[i][j + 1]) == Math.abs(board[i][j + 2])) {
                    int val = Math.abs(board[i][j]);
                    board[i][j] = -val;
                    board[i][j + 1] = -val;
                    board[i][j + 2] = -val;
                    killed = true;
                }
            }
        }
        // vertical
        for (int i = 0; i + 3 <= board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0 && Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) && Math.abs(board[i + 1][j]) == Math.abs(board[i + 2][j])) {
                    int val = Math.abs(board[i][j]);
                    board[i][j] = -val;
                    board[i + 1][j] = -val;
                    board[i + 2][j] = -val;
                    killed = true;
                }
            }
        }
        // collapse
        for (int j = 0; j < board[0].length; j++) {
            int ht = board.length - 1;
            for (int i = board.length - 1; i >= 0; i--) {
                board[ht][j] = board[i][j];
                if (board[ht][j] > 0) {
                    ht--;
                }
            }
            for (int i = 0; i <= ht; i++) {
                board[i][j] = 0;
            }
        }
        return killed;
    }
    
    public static int[] DR = {-1, 0, 1, 0};
    public static int[] DC = {0, 1, 0, -1};
    
    public static void kill(int[][] board, int target, int r, int c, List<Point> pts) {
        if (!valid(board, r, c) || board[r][c] != target) {
            return;
        }
        board[r][c] = -Math.abs(board[r][c]);
        pts.add(new Point(r, c));
        for (int d = 0; d < 4; d++) {
            int nr = r + DR[d];
            int nc = c + DC[d];
            kill(board, target, nr, nc, pts);
        }
    }
    
    public static boolean valid(int[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[r].length;
    }
    
    public static class Point {
        public int R, C;
        
        public Point(int r, int c) {
            this.R = r;
            this.C = c;
        }
    }
}