class Solution {
    
    int[][] adj = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int slidingPuzzle(int[][] board) {
        HashSet<Integer> set = new HashSet<Integer>();
        int step = 0;
        Queue<int[][]> q = new LinkedList<int[][]>();
        q.offer(board);
        int count = 1;
        int count_next = 0;
        set.add(hash(board));
        while (q.size() > 0) {
            int[][] cur_board = q.poll();
            if (isResult(cur_board)) return step;
            --count;
            List<int[][]> next_boards = next_board(cur_board);
            for (int[][] b: next_boards) {
                if (set.contains(hash(b))) continue;
                set.add(hash(b));
                q.offer(b);
                ++count_next;
            }
            if (count == 0) {
                count = count_next;
                count_next = 0;
                ++step;
            }
        }
        return -1;
    }
        
    private boolean isResult(int[][] board) {
        return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 && board[1][0] == 4 && board[1][1] == 5 && board[1][2] == 0;
    }
    
    private int hash(int[][] board) {
        int ret = 0;
        for (int i = 0; i != 2; ++i)
            for (int j = 0; j != 3; ++j) {
                ret *= 6;
                ret += board[i][j];
            }
        return ret;
    }
    
    private List<int[][]> next_board(int[][] board) {
        List<int[][]> ret = new ArrayList<int[][]>();
        for (int i = 0; i != 2; ++i)
            for (int j = 0; j != 3; ++j) {
                if (board[i][j] != 0) continue;
                for (int k = 0; k != 4; ++k) {
                    int x = i + adj[k][0];
                    int y = j + adj[k][1];
                    if (x < 0 || x >= 2 || y < 0 || y >= 3) continue;
                    int[][] next = clone(board);
                    next[i][j] = next[x][y];
                    next[x][y] = 0;
                    ret.add(next);
                }
            }
        return ret;
    }
    
    private int[][] clone(int[][] board) {
        int[][] ret = new int[2][3];
        for (int i = 0; i != 2; ++i)
            for (int j = 0; j != 3; ++j)
                ret[i][j] = board[i][j];
        return ret;
    }
}