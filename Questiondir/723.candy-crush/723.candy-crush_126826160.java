class Solution {
    public int[][] candyCrush(int[][] board) {
        while (true) {
            boolean flag = false;
            for (int i=0; i<board.length; i++) {
                for (int j=0, k=0; k<=board[i].length; k++) {
                    if (k == board[i].length || (board[i][k]&65535) != (board[i][j]&65535)) {
                        if (k-j >= 3 && board[i][j] > 0) {
                            flag = true;
                            while (j < k) {
                                board[i][j++] |= 65536;
                            }
                        }
                        j = k;
                    }
                }
            }
            for (int j=0; j<board[0].length; j++) {
                for (int i=0, k=0; k<=board.length; k++) {
                    if (k == board.length || (board[i][j]&65535) != (board[k][j]&65535)) {
                        if (k-i >= 3 && board[i][j] > 0) {
                            flag = true;
                            while (i < k) {
                                board[i++][j] |= 65536;
                            }
                        }
                        i = k;
                    }
                }
            }
            if (!flag) {
                break;
            }
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[i].length; j++) {
                    if (0 != (board[i][j] & 65536)) {
                        board[i][j] = 0;
                    }
                }
            }
            for (int j=0; j<board[0].length; j++) {
                int idx = board.length-1;
                for (int i=board.length-1; i>=0; i--) {
                    if (board[i][j] > 0) {
                        board[idx--][j] = board[i][j];
                    }
                }
                for (; idx>=0; idx--) {
                    board[idx][j] = 0;
                }
            }
        }
        return board;
    }
}