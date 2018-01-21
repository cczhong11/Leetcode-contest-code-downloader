	class Solution {
	    public boolean canPartitionKSubsets(int[] nums, int k) {
	        int n = nums.length;
	        int sum = 0;
	        for(int v : nums)sum += v;
	        if(sum % k != 0){
	        	return false;
	        }
	        sum /= k;
	        boolean[] ok = new boolean[1<<n];
	        for(int i = 0;i < 1<<n;i++){
	        	int s = 0;
	        	for(int j = 0;j < n;j++){
	        		if(i<<~j<0){
	        			s += nums[j];
	        		}
	        	}
	        	ok[i] = s == sum;
	        }
	        
	        boolean[] dp = new boolean[1<<n];
	        dp[0] = true;
	        
	        for(int i = 0;i < 1<<n;i++){
	        	if(!dp[i])continue;
	        	for(int j = i;j < 1<<n;j=j+1|i){ 
	        		if(ok[i^j])dp[j] = true;
	        	}
	        }
	        return dp[(1<<n)-1];
	    }
	}	
