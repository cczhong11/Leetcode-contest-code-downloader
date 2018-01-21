class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] board = new double[N][N], temp;
        for(int i = 0; i < N; ++i) Arrays.fill(board[i], 1.0);
        int[][] next = new int[][]{{1, 1, -1, -1, 2, 2, -2, -2}, {2, -2, 2, -2, 1, -1, 1, -1}};
        while(K > 0) {
            temp = new double[N][N];
            for(int i = 0; i < N; ++i) {
                for(int j = 0; j < N; ++j) {
                    double temp1 = 0;
                    for(int k = 0; k < 8; ++k) {
                        int x = i + next[0][k], y = j + next[1][k];
                        if(x >= 0 && x < N && y >= 0 && y < N) temp1 += board[x][y];
                    }
                    temp[i][j] = temp1/8.0;
                }
            }
            board = temp;
            --K;
        }
        return board[r][c];
    }
}