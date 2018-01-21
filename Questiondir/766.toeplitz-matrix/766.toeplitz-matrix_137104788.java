class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
            {
                if (i>0 && j>=i) continue;
                int x=matrix[i][j];
                for (int k=1;k<m;k++)
                {
                    if (i+k>=n || j+k>=m) break;
                    if (matrix[i+k][j+k]!=x) return false;
                }
            }
        return true;
    }
}