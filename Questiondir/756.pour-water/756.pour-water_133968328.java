class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; ++ i) {
            int j = K;
            for(; j-1 >= 0 && heights[j-1] <= heights[j]; -- j);
            if(heights[j] < heights[K]) {
                for (; heights[j+1] == heights[j]; ++ j);
                ++ heights[j];
                continue;
            }
            j = K;
            for(; j+1 < heights.length && heights[j+1] <= heights[j]; ++ j);
            if(heights[j] < heights[K]) {
                for (; heights[j-1] == heights[j]; -- j);
                ++ heights[j];
                continue;
            }
            ++ heights[K];
        }
        return heights;
    }
}