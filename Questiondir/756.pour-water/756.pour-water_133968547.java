class Solution {
	public int[] pourWater(int[] heights, int V, int K) {
    
		int n = heights.length;
		for (int i = 0;i < V;i ++) {
			int index = K;
			heights[index] ++;
			while (true) {
				heights[index] --;
				// check left
				int left = index - 1;
				while (left >= 0 && heights[left] == heights[index]) {
					left --;
				}
				if (left >= 0) {
					if (heights[left] < heights[index]) {
						heights[left] ++;
						index = left;
						continue;
					}
				}
				int right = index + 1;
				while (right < n && heights[right] == heights[index]) {
					right ++;
				}
				if (right < n) {
					if (heights[right] < heights[index]) {
						heights[right] ++;
						index = right;
						continue;
					}
				}
				heights[index] ++;
				break;
			}
		}
		return heights;
		
    }
}