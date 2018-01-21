import java.util.Arrays;

class Solution {
	int N, value;
	int[][] dp;
	int[] nums;
	int[] sums;
	
	int solve(int mask, int k) {
        if (k < 0) return 0;
		if (k == 0) return mask == 0 ? 1 : 0;
		if (mask == 0) return k == 0 ? 1 : 0;

		if (dp[mask][k] >= 0) return dp[mask][k];
		int res = 0;
		for (int sub = mask; ; sub = ((sub - 1) & mask)) {
			if (sub == 0) break;
			if (sums[sub] == value) {
				res |= solve(mask - sub, k - 1);
			}
		}
		dp[mask][k] = res;
		return res;
	}
	
    public boolean canPartitionKSubsets(int[] nums, int k) {
    	N = nums.length;
        int sum = 0;
        for (int x : nums) {
        	sum += x;
        }
        if (sum % k != 0) return false;
        sums = new int[1 << N];
        for (int i = 1; i < (1 << N); ++i) {
        	for (int j = 0; j < N; ++j) {
        		if ((1 << j & i) > 0) {
        			sums[i] = sums[i ^ (1 << j)] + nums[j];
        		}
        	}
        }
        
        this.nums = nums;
        value = sum / k;
        dp = new int[1 << N][k + 1];
        for (int[] d : dp) {
        	Arrays.fill(d, -1);
        }
        
        
        return solve((1 << N) - 1, k) == 1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] nums = {5,2,5,5,5,5,5,5,5,5,5,5,5,5,5,3};
    	int k = 15;
    	boolean s = solution.canPartitionKSubsets(nums, k);
    	System.out.println(s);
    }
}