public class Solution {
    public int findLongestChain(int[][] pairs) {
    	Arrays.sort(pairs, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[1] - arg1[1];
			}
    	});
    	int total = 1;
    	int end = pairs[0][1];
    	for (int i = 1; i < pairs.length; i++) {
    		if (pairs[i][0] > end) {
    			end = pairs[i][1];
    			total++;
    		}
    	}
    	return total;
    }
}