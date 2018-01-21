class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<Point> heap = new PriorityQueue<>();
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] matrix = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = forest.get(i).get(j);
                if (matrix[i][j] == 0 || matrix[i][j] == 1) {
                    continue;
                }
                
                heap.offer(new Point(i, j, matrix[i][j]));
            }
        }
        
        if (matrix[0][0] == 0) {
            return -1;
        }
        
        int count = 0;
        int i = 0;
        int j = 0;
        while (!heap.isEmpty()) {
            Point cur = heap.poll();
            int diff = getDistance(i, j, cur.x, cur.y, matrix);
            if (diff == -1) {
                return -1;
            }
            i = cur.x;
            j = cur.y;
            count += diff;
        }
        return count;
    }
    
    private int getDistance(int x, int y, int xx, int yy, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int count = -1;
        queue.offer(new int[] { x, y });
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == xx && curY == yy) {
                    matrix[curX][curY] = 1;
                    return count;
                }
                
                for (int[] dir : dirs) {
                    int newX = curX + dir[0];
                    int newY = curY + dir[1];
                    
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] || matrix[newX][newY] == 0) {
                        continue;
                    }
                    
                    queue.offer(new int[] { newX, newY });
                    visited[newX][newY] = true;
                }
            }
        }
        
        return -1;
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int height;
    Point(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
    @Override
    public int compareTo(Point that) {
        return this.height - that.height;
    }
}