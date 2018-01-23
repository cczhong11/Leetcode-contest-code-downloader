public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n, m;
        if (matrix == null || (n = matrix.size()) == 0 || (m = matrix.get(0).size()) == 0) {
            return matrix;
        }
        Integer[][] ans = bfs(matrix, n, m);
        return convert(ans);
    }
    
    List<List<Integer>> convert(Integer[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(Arrays.asList(arr[i]));
        }
        return ans;
    }
    
    private Integer[][]  bfs(List<List<Integer>> mtx, int n, int m) {
        int[][] tab = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Integer[][]ans = new Integer[n][m];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mtx.get(i).get(j) == 0) {
                    ans[i][j] = 0;
                    q.offer(i * m + j);
                }
            }
        }
        int level = 1;       
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int xy = q.poll();
                int x = xy / m, y = xy % m;

                for (int i = 0; i < 4; i++) {
                    int xx = x + tab[i][0];
                    int yy = y + tab[i][1];
                    if (xx < 0 || xx >= n || yy < 0 || yy >= m || ans[xx][yy] != null) {
                        continue;
                    }
                    ans[xx][yy] = level;
                    q.offer(xx * m + yy);
                }
            }
            level++;
        }
        return ans;
    }
}