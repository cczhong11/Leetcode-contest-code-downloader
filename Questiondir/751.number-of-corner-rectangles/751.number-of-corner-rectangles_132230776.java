class Solution {
public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m==1||n==1) return 0;
        int res = 0;
        for (int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if (grid[i][j]==0) continue;
                for (int k=j+1;k<n;k++){
                    if (grid[i][k]==0) continue;
                    for (int l=i+1;l<m;l++){
                        if (grid[l][j]==0) continue;
                        if (grid[l][k]==1)
                            res++;
                    }
                }
            }
        }
        return res;
    }
}