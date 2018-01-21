class Solution {
    class Point {
        int x;
        int y;
        int d;
        
        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null) return 0;
        
        int m = forest.size();
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> (a.d - b.d));
        for (int i = 0; i < m; i++) {
            List<Integer> list = forest.get(i);
            if (list == null) return 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > 1) {
                    Point p = new Point(i, j, list.get(j));
                    pq.offer(p);
                }
            }
        }
        
        int[] start = {0, 0};
        int ans = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int[] next = {p.x, p.y};
            int step = walk(forest, start, next);
            if (step == -1) return -1;
            ans += step;
            start = next;
        }
        
        return ans;
    }
    
    private int walk(List<List<Integer>> forest, int[] start, int[] dest) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        int dist = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                if (pos[0] == dest[0] && pos[1] == dest[1]) {
                    return dist;
                }
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && forest.get(x).get(y) != 0 && !visited[x][y]) {
                        int[] next = {x, y};
                        queue.offer(next);
                        visited[x][y] = true;
                    }
                }
            }
            dist++;
        }
        
        return -1;
    }
}