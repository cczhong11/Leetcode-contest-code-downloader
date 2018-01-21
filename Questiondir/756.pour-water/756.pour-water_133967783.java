class Solution {
    int findLeft(int[] heights,int K)
    {
        int left=-1,min=10000000;
        for (int j=K-1;j>=0;j--)
        {
            if (heights[j+1]<heights[j]) break;
            if (heights[j+1]>heights[j]) left=j;
        }
        return left;
    }
    int findRight(int[] heights,int K)
    {
        int right=-1,min=10000000;
        for (int j=K+1;j<heights.length;j++)
        {
            if (heights[j-1]<heights[j]) break;
            if (heights[j-1]>heights[j]) right=j;
        }
        return right;
    }
    public int[] pourWater(int[] heights, int V, int K) {
        int n=heights.length,left=findLeft(heights,K),right=findRight(heights,K);
        for (int i=0;i<V;i++)
        {
            if (left>=0)
            {
                heights[left]++;
                left=findLeft(heights,K);
            }
            else
            {
                if (right>=0)
                {
                    heights[right]++;
                    right=findRight(heights,K);
                }
                else 
                {
                    heights[K]++;
                    left=findLeft(heights,K);
                    right=findRight(heights,K);
                }
            }
        }
        return heights;
    }
}