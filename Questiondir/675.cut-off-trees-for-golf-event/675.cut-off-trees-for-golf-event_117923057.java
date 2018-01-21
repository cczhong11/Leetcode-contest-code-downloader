class Solution {
    public static final int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
    int m;
    int n;
    public int cutOffTree(List<List<Integer>> forest) {
        LinkedList<ToCut> list = new LinkedList<>();
        if(forest.isEmpty() || forest.get(0).isEmpty()) {
            return -1;
        }
        m = forest.size();
        n = forest.get(0).size();
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = forest.get(i).get(j);
            }
        }
        int start = matrix[0][0];
        if(start == 0) {
            return -1;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] > 1) {
                    list.add(ToCut.of(matrix[i][j], i, j));
                }
            }
        }
        Collections.sort(list, Comparator.comparingInt(c -> c.height));
        int[] curr = new int[] {0, 0};
        int distance = 0;
        while(!list.isEmpty()) {
            ToCut next = list.poll();
            int d = minDistance(curr, next, matrix);
            if(d == -1) {
                return -1;
            }
            distance += d;
            curr = new int[]{next.x, next.y};
        }
        return distance;
    }

    private int minDistance(int[] curr, ToCut next, int[][] matrix) {
        if(curr[0] == next.x && curr[1] == next.y) return 0;
        int[][] dist = new int[m][n];
        for(int[] d : dist) {
            Arrays.fill(d, -1);
        }
        dist[curr[0]][curr[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(curr);
        while(!q.isEmpty()) {
            int[] v = q.poll();
            for(int[] d : DIR) {
                int x = v[0] + d[0];
                int y = v[1] + d[1];
                int dis = dist[v[0]][v[1]];
                if(x == next.x && y == next.y) {
                    return dis + 1;
                }
                if(x >= 0 && y >= 0 && x < m && y < n && dist[x][y] == -1 && matrix[x][y] > 0) {
                    dist[x][y] = dis + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    public static class ToCut {
        int height;
        int x;
        int y;

        public static ToCut of(int height, int x, int y) {
            ToCut c = new ToCut();
            c.height = height;
            c.x = x;
            c.y = y;
            return c;
        }
    }
}