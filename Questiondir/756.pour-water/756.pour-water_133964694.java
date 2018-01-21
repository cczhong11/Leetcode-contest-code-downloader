class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        for (int t = 0; t < V; ++t) {
            int L = getLeft(heights, K);
            if (L >= 0) {
                ++heights[L];
                continue;
            }
            int R = getRight(heights, K);
            if (R >= 0) {
                ++heights[R];
                continue;
            }
            ++heights[K];
        }
        return heights;
    }
    
    public static int getLeft(int[] heights, int K) {
        for (int i = K - 1; i >= 0; --i) {
            if (heights[i] > heights[K]) {
                break;
            }
            if (heights[i] < heights[K]) {
                int L = getLeft(heights, i);
                if (L >= 0) {
                    return L;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static int getRight(int[] heights, int K) {
        for (int i = K + 1; i < heights.length; ++i) {
            if (heights[i] > heights[K]) {
                break;
            }
            if (heights[i] < heights[K]) {
                int R = getRight(heights, i);
                if (R >= 0) {
                    return R;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }
}