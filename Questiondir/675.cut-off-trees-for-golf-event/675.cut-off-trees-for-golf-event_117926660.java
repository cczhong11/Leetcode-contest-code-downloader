class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0)  return -1;
        if (forest.get(0).get(0) == 0)  return -1;
        int row = forest.size(), col = forest.get(0).size(), path = 0;
        int r = 0, c = 0;
        PriorityQueue<int[]> height = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1)   height.offer(new int[]{forest.get(i).get(j), i, j});
            }
        }
        while (!height.isEmpty()) {
            int[] nxt = height.poll();           
            int temp = BFS(forest, nxt, r, c, row, col);
            if (temp == -1)     return -1;
            r = nxt[1];
            c = nxt[2];
            path += temp;
        }
        return height.isEmpty() ? path : -1;
    }
    private int BFS(List<List<Integer>> forest, int[] pos, int x, int y, int row, int col) {
        if (x == pos[1] && y == pos[2]) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[row][col];
        visited[x][y] = true;
        int path = -1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == pos[1] && cur[1] == pos[2])   return path;
                for (int[] d : dirs) {
                    int m = cur[0] + d[0];
                    int n = cur[1] + d[1];
                    if (m < 0 || m >= row || n < 0 || n >= col) continue;
                    if (forest.get(m).get(n) == 0 || visited[m][n])  continue;
                    queue.offer(new int[]{m, n});
                    visited[m][n] = true;
                }
            }
        }
        return -1;
    }
}