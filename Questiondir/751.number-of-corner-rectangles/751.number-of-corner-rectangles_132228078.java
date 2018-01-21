class Solution {
    public int countCornerRectangles(int[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++)
            for (int j=i+1;j<grid.length;j++)
            {
                int cc=0;
                for (int k=0;k<grid[0].length;k++)
                {
                    if ((grid[i][k]==1)&&(grid[j][k]==1))
                    {
                        cc++;
                    }
                }
                count=count+(cc-1)*cc/2;
            }
        return count;
    }
}