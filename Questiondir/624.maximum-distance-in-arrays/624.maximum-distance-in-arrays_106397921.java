public class Solution {
    public int maxDistance(int[][] arrays) {
    	Integer min = null;
    	Integer max = null;
    	int result = 0;
        for(int i = 0; i < arrays.length; i ++) {
        	if(arrays[i].length == 0) continue;
        	int currMin = arrays[i][0];
        	int currMax = arrays[i][arrays[i].length - 1];
        	if(min != null) {
        		result = Math.max(result, Math.abs(min - currMax));
        		result = Math.max(result, Math.abs(max - currMin));
        		min = Math.min(min, currMin);
        		max = Math.max(max, currMax);
        	}
        	else {
        		min = currMin;
        		max = currMax;
        	}
        }
        return result;
    }
}