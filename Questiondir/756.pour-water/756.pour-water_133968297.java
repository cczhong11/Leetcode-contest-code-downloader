class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        int len = heights.length;
        for (int i = 0; i < V; i++) {
            int h = heights[K], drop = K;

            // move left
            for (int j = K - 1; j >= 0 && heights[j] <= h; j--) {
                if (heights[j] < h) {
                    h = heights[j];
                    drop = j;
                }
            }

            if (drop != K) {
                heights[drop]++;
                continue;
            }
            // move right
            for (int j = K + 1; j < len && heights[j] <= h; j++) {
                if (heights[j] < h) {
                    drop = j;
                    h = heights[j];
                }
            }

            heights[drop]++;
        }
        return heights;
    }
}