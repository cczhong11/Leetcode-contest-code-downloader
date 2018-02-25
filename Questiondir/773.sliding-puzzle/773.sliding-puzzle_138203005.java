class Solution {
public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int n = board.length;
        int m = board[0].length;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                sb.append(board[i][j]);
        q.add(sb.toString());
        if (sb.toString().equals(target)) return 0;
        visited.add(sb.toString());
        int step = 0;
        int[][] dir = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                sb = new StringBuilder(cur);
                int p = 0;
                for (int j = 0; j < cur.length(); j++)
                    if (cur.charAt(j) == '0')
                        p = j;
                int r = p / m;
                int c = p % m;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dir[k][0];
                    int nc = c + dir[k][1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        int np = nr * m + nc;
                        sb.setCharAt(p, sb.charAt(np));
                        sb.setCharAt(np, '0');
                        if (!visited.contains(sb.toString())) {
                            if (sb.toString().equals(target)) return step;
                            visited.add(sb.toString());
                            q.add(sb.toString());
                        }
                        sb.setCharAt(np, sb.charAt(p));
                        sb.setCharAt(p, '0');
                    }
                }
            }
        }
        return -1;
    }

}