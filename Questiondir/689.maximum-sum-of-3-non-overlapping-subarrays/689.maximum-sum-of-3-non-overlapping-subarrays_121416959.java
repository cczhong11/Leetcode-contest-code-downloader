class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    	int n = nums.length;
    	if (n < 3) return null;
    	
        long[] sum = new long[n + 1];
        long[][] dp = new long[3][n + 1];
        
        for (int i = 1; i <= n; ++i) {
        	sum[i] = sum[i - 1] + nums[i - 1];
        }
        
        for (int i = 0; i < 3; ++i) {
        	for (int j = 1; j <= n; ++j) {
        		dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        		if (j - k >= 0) {
        			long tmp = sum[j] - sum[j - k];
        			if (i > 0) tmp += dp[i - 1][j - k];
        			dp[i][j] = Math.max(dp[i][j], tmp);
        		}
        	}
        }
        
        int[] res = new int[3];
        int lastP = n;
        for (int steps = 2; steps >= 0; --steps) {
        	long maxSum = 0;
        	int index = -1;
        	for (int i = 1; i <= lastP; ++i) {
        		if (dp[steps][i] > maxSum) {
        			maxSum = dp[steps][i];
        			index = i;
        		}
        	}
        	//System.out.println(maxSum + " " + index + " " + lastP );
        	res[steps] = index - k; 
        	//System.out.println("res: " + res[steps]);
        	lastP = res[steps];
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,1,2,6,7,5,1};
        solution.maxSumOfThreeSubarrays(nums, 2);
     }
}