class Solution {
    int[] DR = {-1, 0, 1, 0};
    int[] DC = {0, 1, 0, -1};
    
    public int slidingPuzzle(int[][] board) {
        Board answer = new Board(new int[][] {{1, 2, 3}, {4, 5, 0}});
        HashSet<Board> seen = new HashSet<Board>();
        Queue<Board> q = new ArrayDeque<Board>();
        Queue<Integer> d = new ArrayDeque<Integer>();
        Board init = new Board(board);
        q.offer(init);
        d.offer(0);
        seen.add(init);
        while (!q.isEmpty()) {
            Board b = q.poll();
            int dd = d.poll();
            if (b.equals(answer)) {
                return dd;
            }
            for (int r = 0; r < 2; ++r) {
                for (int c = 0; c < 3; ++c) {
                    if (b.b[r][c] != 0) {
                        continue;
                    }
                    for (int i = 0; i < 4; ++i) {
                        int rr = r + DR[i];
                        int cc = c + DC[i];
                        if (rr >= 0 && rr < 2 && cc >= 0 && cc < 3) {
                            Board next = b.copy();
                            next.b[r][c] = next.b[rr][cc];
                            next.b[rr][cc] = 0;
                            if (!seen.contains(next)) {
                                q.offer(next);
                                d.offer(dd + 1);
                                seen.add(next);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public static class Board {
        public int[][] b;
        
        public Board(int[][] board) {
            this.b = board;
        }
        
        public Board copy() {
            int[][] x = new int[2][3];
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 3; ++j) {
                    x[i][j] = b[i][j];
                }
            }
            return new Board(x);
        }
        
        @Override
        public int hashCode() {
            int hash = 0;
            for (int[] row : b) {
                for (int v : row) {
                    hash = (hash << 3) | v;
                }
            }
            return hash;
        }
        
        @Override
        public boolean equals(Object obj) {
            Board board = (Board)obj;
            return this.hashCode() == board.hashCode();
        }
    }
}