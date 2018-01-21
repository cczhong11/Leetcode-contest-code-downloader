public class Solution {

	private int[] dp;
	private static List<Integer>[] prev = new ArrayList[1010];
	private List<Integer> ans = new ArrayList<>();
	
    public List<Integer> cheapestJump(int[] A, int B) {
    
    	int i , j , n = A.length;
    	dp = new int[n];
    	for (i = 0;i < n;i ++) {
    		prev[i] = new ArrayList<>();
    	}
    	Arrays.fill(dp , - 1);
        ans = new ArrayList<>();
    	
    	if (A[0] == - 1 || A[n - 1] == - 1) {
    		return Arrays.asList();
    	}
    	
    	if (n == 1) {
    		return Arrays.asList(1);
    	}
    	
    	dp[0] = 0;
    	for (i = 1;i < n;i ++) {
    		if (A[i] == - 1) {
    			dp[i] = - 1;
    		} else {
	    		for (j = Math.max(i - B , 0);j <= i - 1;j ++) {
	    			if (dp[j] >= 0) {
	    				int temp = dp[j] + A[i];
	    				if (temp < dp[i] || dp[i] < 0) {
	    					dp[i] = temp;
	    					prev[i].clear();
	    					prev[i].add(j);
	    				} else if (temp == dp[i]) {
	    					prev[i].add(j);
	    				}
	    			}
	    		}
    		}
    	}
    	if (dp[n - 1] < 0) {
    		return Arrays.asList();
    	} else {
    		dfs(n - 1 , new ArrayList<>());
    		return ans;
    	}
    	
    }
    
    private boolean check(List<Integer> list) {
    	
    	if (ans.isEmpty()) {
    		return true;
    	} else {
    		int i , n1 = list.size() , n2 = ans.size();
    		for (i = 0;i < Math.min(n1 , n2);i ++) {
    			if (list.get(i) < ans.get(i)) {
    				return true;
    			} else if (list.get(i) > ans.get(i)) {
    				return false;
    			}
    		}
    		if (n1 < n2) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    }
    
    private void dfs(int current , List<Integer> list) {
    	
    	list.add(current + 1);
    	if (prev[current].isEmpty()) {
    		List<Integer> temp = new ArrayList<>(list);
    		Collections.reverse(temp);
    		if (check(temp)) {
    			ans = temp;
    		}
    	} else { 
    		for (int next : prev[current]) {
    			dfs(next , list);
    		}
    	}
    	list.remove(list.size() - 1);
    	
    }
    
}