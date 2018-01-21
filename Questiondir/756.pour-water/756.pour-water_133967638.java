class Solution {
  public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
        		
        		// try left;
        		int j = K;
        		for (; j >= 0; ) {
        			if (j - 1 >= 0 && heights[j - 1] <= heights[j]) {
        				j--;
        			} else {
        				break;
        			}
        		}
        		if (heights[j] < heights[K]) {
        			int k = K;
        			for (; k >= 0 && heights[k] != heights[j]; k--) {
        				
        			}
        			heights[k]++;
        			continue;
        		}
        		
        		// try right;
        		j = K;
        		for (; j < heights.length; ) {
        			if (j + 1 < heights.length && heights[j + 1] <= heights[j]) {
        				j++;
        			} else {
        				break;
        			}
        		}
        		if (heights[j] < heights[K]) {
        			int k = K;
        			for (; k < heights.length && heights[k] != heights[j]; k++) {
        				
        			}
        			heights[k]++;
        			continue;
        		}
        		heights[K]++;
        }
        return heights;
    }
}