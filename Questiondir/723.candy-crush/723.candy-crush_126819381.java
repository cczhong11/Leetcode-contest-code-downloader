class Solution {
    public int[][] candyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        while (true) {
            Set<Integer> toCrush = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j]==0)
                        continue;
                    if (i>0&&i<n-1&&board[i-1][j]==board[i][j]&&board[i+1][j]==board[i][j]) {
                        toCrush.add((i-1)*m+j);
                        toCrush.add(i*m+j);
                        toCrush.add((i+1)*m+j);
                    }
                    if (j>0&&j<m-1&&board[i][j-1]==board[i][j]&&board[i][j+1]==board[i][j]) {
                        toCrush.add(i*m+j-1);
                        toCrush.add(i*m+j);
                        toCrush.add(i*m+j+1);
                    }
                }
            }
            if (toCrush.isEmpty())
                return board;
            for (int tc : toCrush) {
                board[tc/m][tc%m] = 0;
            }
            for (int z = 0; z < n; z++) {
                for (int i = n-1; i >= 1; i--) {
                    for (int j = 0; j < m; j++) {
                        if (board[i][j] == 0 && board[i-1][j] != 0) {
                            board[i][j] = board[i-1][j];
                            board[i-1][j] = 0;
                        }
                    }
                }
            }
        }
    }
}