class Solution {
	private Map<Integer , Queue<Integer>> map = new HashMap<>();
	
    public int[] anagramMappings(int[] A, int[] B) {
     
    	int i , j , n = A.length;
    	for (i = 0;i < n;i ++) {
    		if (!map.containsKey(B[i])) {
    			map.put(B[i] , new LinkedList<>());
    		}
    		map.get(B[i]).add(i);
    	}
    	int[] ans = new int[n];
    	for (i = 0;i < n;i ++) {
    		ans[i] = map.get(A[i]).poll();
    	}
    	return ans;
    	
    }
}