class Solution {
    private static final int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int containVirus(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        
        while (true) {
            int cnt = 0;
            Set<Integer> virus = null;
            boolean[][] visited = new boolean[m][n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 1 || visited[i][j]) continue;
                    
                    Set<Integer> ones = new HashSet<>();
                    Set<Integer> zeros = new HashSet<>();
                    
                    dfs(grid, i, j, visited, ones, zeros);
                    
                    if (zeros.size() > cnt) {
                        cnt = zeros.size();
                        virus = ones;
                    }
                }
            }
            
            if (cnt == 0 || virus == null) break;
            
            for (int key : virus) {
                int i = key / n, j = key % n;
                
                grid[i][j] = -1;
                
                for (int[] d : D) {
                    int ni = i + d[0], nj = j + d[1];
                    if (0 <= ni && ni < m && 0 <= nj && nj < n && grid[ni][nj] == 0) res++;
                }
            }
            
            visited = new boolean[m][n];
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 1 || visited[i][j]) continue;
                    infect(grid, i, j, visited);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited, 
                     Set<Integer> ones, Set<Integer> zeros) {
        
        int m = grid.length, n = grid[0].length, key = i * n + j;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1 || visited[i][j]) return;
        
        visited[i][j] = true;
        ones.add(key);
        
        for (int[] d : D) {
            int ni = i + d[0], nj = j + d[1], nkey = ni * n + nj;
            
            if (0 <= ni && ni < m && 0 <= nj && nj < n && grid[ni][nj] == 0) zeros.add(nkey);
            
            dfs(grid, ni, nj, visited, ones, zeros);
        }
    }
                
    private void infect(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1 || visited[i][j]) return;
        
        visited[i][j] = true;
        
        for (int[] d : D) {
            int ni = i + d[0], nj = j + d[1];
            
            if (0 <= ni && ni < m && 0 <= nj && nj < n && grid[ni][nj] == 0) {
                grid[ni][nj] = 1;
                visited[ni][nj] = true;
                continue;
            }
            
            infect(grid, ni, nj, visited);
        }
    }
}