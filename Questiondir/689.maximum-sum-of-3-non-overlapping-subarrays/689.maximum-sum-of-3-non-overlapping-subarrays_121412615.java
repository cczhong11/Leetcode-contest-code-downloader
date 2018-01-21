	class Solution {
	    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
	    	int n = nums.length;
	        int[] cum = new int[n+1];
	        for(int i = 0;i < n;i++)cum[i+1] = cum[i] + nums[i];
	        int[][] dp = new int[n+1][];
	        for(int i = 0;i < n-k+1;i++){
	        	dp[i] = new int[]{cum[i+k] - cum[i], i, -1, -1};
	        }
	        for(int u = 0;u < 2;u++){
	        	int[] best = null;
		        int[][] ndp = new int[n+1][];
	        	for(int i = 0;i <= n;i++){
	        		if(i >= k){
	        			if(dp[i-k] != null){
		        			if(best == null || best[0] < dp[i-k][0]){
		        				best = dp[i-k];
		        			}
	        			}
	        		}
	        		if(best != null && i+k <= n){
	        			ndp[i] = Arrays.copyOf(best, 4);
	        			ndp[i][0] += cum[i+k] - cum[i];
	        			ndp[i][u+2] = i;
	        		}
	        	}
	        	dp = ndp;
	        }
	        
	        int[] best = null;
	        for(int i = 0;i <= n;i++){
    			if(dp[i] != null && (best == null || best[0] < dp[i][0])){
    				best = dp[i];
    			}
	        }
	        return new int[]{best[1], best[2], best[3]};
	    }
	}	
