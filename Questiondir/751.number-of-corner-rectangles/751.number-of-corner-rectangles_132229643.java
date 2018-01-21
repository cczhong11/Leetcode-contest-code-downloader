class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                
                for (int k = j + 1; k < n; k++) {
                    if (grid[i][k] == 0) continue;
                    
                    String key = j + "_" + k;
                    int cnt = map.getOrDefault(key, 0);
                    res += cnt;
                    map.put(key, cnt + 1);
                }
            }
        }
        
        return res;
    }
}