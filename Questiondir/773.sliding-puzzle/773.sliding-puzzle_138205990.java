class Solution {
    
    class Board {
        int[][] board;
        int step;
        public Board(int[][] b) {
            step = 0;
            board = new int[2][3];
            for(int i=0;i<2;i++) for(int j=0;j<3;j++) board[i][j] = b[i][j];
        }
        
        public Board(int[][] b, int step) {
            this(b);
            setStep(step);
        }
        
        private void setStep(int step) {
            this.step = step;
        }
        
        public boolean equals(Object o) {
            if (o instanceof Board) return equals((Board) o);
            else return false;
        }
        public boolean equals(Board b) {
            for(int i=0;i<2;i++) for(int j=0;j<3;j++) {
                if (board[i][j] != b.board[i][j]) return false;
            }
            return true;
        }
        
        public int hashCode() {
            int ret = 0, base = 1;
            for(int i=0;i<2;i++) for(int j=0;j<3;j++) {
                ret = ret + base * board[i][j];
                base *= 6;
            }
            return ret;
        }
        
        public List<Board> getNext() {
            int nextstep = step + 1;
            for(int i=0;i<2;i++) for(int j=0;j<3;j++) if(board[i][j]==0) {
                LinkedList<Board> ret = new LinkedList<Board>();
                Board next;
                next = swap(i, j, 1-i, j);
                next.setStep(nextstep);
                ret.add(next);
                if(j!=0) {
                    next = swap(i, j, i, j-1);
                    next.setStep(nextstep);
                    ret.add(next);
                }
                if(j!=2) {
                    next = swap(i, j, i, j+1);
                    next.setStep(nextstep);
                    ret.add(next);
                }
                return ret;
            }
            throw new RuntimeException("No 0 found.");
        }
        
        private Board swap(int i1, int j1, int i2, int j2) {
            int[][] ret = new int[2][3];
            for(int i=0;i<2;i++) for(int j=0;j<3;j++) ret[i][j] = board[i][j];
            int tmp = ret[i1][j1];
            ret[i1][j1] = ret[i2][j2];
            ret[i2][j2] = tmp;
            return new Board(ret);
        }
        
    }
    
    public int slidingPuzzle(int[][] board) {
        LinkedList<Board> bag = new LinkedList<Board>();
        Board target = new Board(
            new int[][] {{1,2,3},{4,5,0}}
        );
        bag.add(new Board(board));
        HashSet<Board> dedupe = new HashSet<Board>();
        while(bag.size()>0) {
            Board curboard = bag.removeFirst();
            dedupe.add(curboard);
            if (curboard.equals(target)) {
                return curboard.step;
            }
            for(Board nextboard : curboard.getNext()) {
                if (!dedupe.contains(nextboard)) {
                    bag.add(nextboard);
                }
            }
        }
        return -1;
    }
}