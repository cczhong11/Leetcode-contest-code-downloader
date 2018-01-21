class Solution {
    public int cherryPickup(int[][] grid) {
        // find two paths from start to end
        // the two paths may have overlap
       
        int res = dp(0, 0, grid, new HashMap<String, Integer>());
        
        if (res == -1) return 0;
        
        res += grid[0][0];
        
        return res;
        
    }
    
    private int dp(int start, int end, int[][] grid, Map<String, Integer> cache) {
        // find the best path from start to end by passing (n-1, n-1)
        // 
        int N = grid.length;
        
        // the location of start
        int x_s = start/N;
        int y_s = start%N;
        
        // the location of end
        int x_e = end/N;
        int y_e = end%N;
        
        int[][] moves = {{1, 0}, {0, 1}};
        
        if (x_s == N-1 && y_s == N-1) return 0;    
            
        if (!cache.containsKey(String.valueOf(start) + "_" +  String.valueOf(end))) {
        
            int max = -1;
            // condition on the next (previous) location
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 2; ++j) {

                    int tmp = 0;
                    
                    int x_s_n = x_s + moves[i][0];
                    int y_s_n = y_s + moves[i][1];
                    
                    int x_e_p = x_e + moves[j][0];
                    int y_e_p = y_e + moves[j][1];
                    
                    if (x_s_n >= N || y_s_n >= N || x_e_p >= N || y_e_p >= N) continue;
                    if (grid[x_s_n][y_s_n] == -1 || grid[x_e_p][y_e_p] == -1) continue;
                    
                    
                    tmp = dp(x_s_n*N+y_s_n, x_e_p*N+y_e_p, grid, cache);
                    if (tmp == -1) continue;

                    // if move to the same location
                    if (x_s_n == x_e_p && y_s_n == y_e_p) tmp += grid[x_s_n][y_s_n];
                    else tmp += grid[x_s_n][y_s_n] + grid[x_e_p][y_e_p];
                    
                    if (tmp > max) max = tmp;

                }
            }
            
            cache.put(String.valueOf(start) + "_" +  String.valueOf(end), max);

        }
        
        return cache.get(String.valueOf(start) + "_" +  String.valueOf(end));
    }
    
}