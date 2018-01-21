class Solution {
    public int findNumberOfLIS(int[] nums) {
    	if (nums.length == 0) return 0;
    	int[] dp = new int[nums.length];
    	List<Set<Integer>> pre = new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) pre.add(new HashSet<>());
    	dp[0] = 1;
    	int maxLen = 1;
    	for (int i = 1; i < nums.length; i++) {
    		dp[i] = 1;
    		for (int j = 0; j < i; j++) {
    			if (nums[i] > nums[j]) {
    				if (dp[j] + 1 > dp[i]) {
    					pre.get(i).clear();
    					pre.get(i).add(j);
    					dp[i] = dp[j] + 1;
    				} else if (dp[j] + 1 == dp[i]) {
    					pre.get(i).add(j);
    				}
    			}
    		}
    		maxLen = Math.max(maxLen, dp[i]);
    	}
    	int res = 0;
    	for (int i = 0; i < dp.length; i++) {
    		if (dp[i] == maxLen) {
    			int tmp = solve(pre, i);
    			res += tmp;
    		}
    	}
    	return res;
    }
    
	private int solve(List<Set<Integer>> pre, int i) {
		if (pre.get(i).size() == 0) return 1;
		int res = 0;
		for (int p: pre.get(i)) {
			res += solve(pre, p);
		}
		return res;
	}

}