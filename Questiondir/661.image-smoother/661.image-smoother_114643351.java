class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        
        int[][] res = new int[row][col];
        
        for (int r = 0; r < row; ++r) {
        	for (int c = 0; c < col; ++c) {
        		int sum = 0;
        		int cnt = 0;
        		for (int dr = -1; dr <= 1; ++dr) {
        			for (int dc = -1; dc <= 1; ++dc) {
        				int nr = dr + r;
        				int nc = dc + c;
        				if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
        					continue;
        				}
        				++cnt;
        				sum += M[nr][nc];
        			}
        		}
        		res[r][c] = sum / cnt;
        	}
        }
        
        return res;
    }
}