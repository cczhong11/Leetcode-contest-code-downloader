class Solution {
    public static int[] pourWater(int[] heights, int V, int K) {
        int[] copy = new int[heights.length];
        System.arraycopy(heights, 0, copy, 0, heights.length);
        
        for(int i = 0; i < V; i++){
        	drip(copy, K);
        }
        return copy;
    }
	public static void drip(int[] heights, int K){
		for(int i = K; i >= 0; i--){
			if(heights[i] < heights[K]){
				drip(heights, i);
				return;
			}else if(heights[i] > heights[K]){
				break;
			}
		}
		for(int i = K; i < heights.length; i++){
			if(heights[i] < heights[K]){
				drip(heights, i);
				return;
			}else if(heights[i] > heights[K]){
				break;
			}
		}
		heights[K]++;
	}
}