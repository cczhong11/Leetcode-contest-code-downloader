class Solution {
    public int countCornerRectangles(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        //int[][] count=new int[m][m];
        int ans=0;
        for (int i=0;i<m;i++)
            for (int j=i+1;j<m;j++)
            {
                int count=0;
                for (int k=0;k<n;k++)
                    if (grid[k][i]==1 && grid[k][j]==1) count++;
                ans+=count*(count-1)/2;
            }
        return ans;
    }
}