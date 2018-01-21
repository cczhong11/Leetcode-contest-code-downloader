class Solution {
	private int[][] dp;
	
    public int findLength(int[] A, int[] B) {
     
    	int i , j , n1 = A.length , n2 = B.length , ans = 0;
    	dp = new int[n1][n2];
    	for (i = 0;i < n1;i ++) {
    		if (A[i] == B[0]) {
    			dp[i][0] = 1;
    		} else {
    			dp[i][0] = 0;
    		}
    	}
    	for (j = 0;j < n2;j ++) {
    		if (A[0] == B[j]) {
    			dp[0][j] = 1;
    		} else {
    			dp[0][j] = 0;
    		}
    	}
    	for (i = 1;i < n1;i ++) {    		
    		for (j = 1;j < n2;j ++) {
    			if (A[i] == B[j]) {
    				dp[i][j] = dp[i - 1][j - 1] + 1;
    			} else {
    				dp[i][j] = 0;
    			}
    		}
    	}
    	for (i = 0;i < n1;i ++) {
    		for (j = 0;j < n2;j ++) {
    			if (dp[i][j] > ans) {
    				ans = dp[i][j];
    			}
    		}
    	}
    	return ans;
    }
}