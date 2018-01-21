public class Solution {
	private static class Pair implements Comparable<Pair> {
		public int start , end;
		public Pair(int start , int end) {
			this.start = start;
			this.end = end;
		}
		public int compareTo(Pair pair) {
			if (this.end < pair.end) {
				return - 1;
			} else if (this.end > pair.end) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
    public int findLongestChain(int[][] pairs) {
     
    	int i , j , n = pairs.length;
    	if (n == 0) {
    		return 0;
    	}
    	
    	List<Pair> list = new ArrayList<>();
    	for (i = 0;i < n;i ++) {
    		list.add(new Pair(pairs[i][0] , pairs[i][1]));
    	}
    	Collections.sort(list);
    	int end = list.get(0).end , ans = 1;
    	for (i = 0;i < n;i ++) {
    		while (i < n && list.get(i).start <= end) {
    			i ++;
    		}
    		if (i < n) {
    			end = list.get(i).end;
    			ans ++;
    		}
    	}
    	return ans;
    	
    }
}