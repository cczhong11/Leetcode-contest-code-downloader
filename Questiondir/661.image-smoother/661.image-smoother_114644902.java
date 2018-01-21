class Solution {
    static int[][] direction = {{-1,-1}, {-1, 0}, {-1,1}, {0,-1}, {1, -1}, {1, 0}, {0, 1}, {1,1}};
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        if(m == 0) return null;
        int n = M[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                int sum = M[i][j];
                int count = 1;
                for(int dir[] : direction) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n) {
                        sum += M[x][y];
                        count++;
                    }
                }
                res[i][j] = sum/count;
            } 
        }
        return res;
    }
}