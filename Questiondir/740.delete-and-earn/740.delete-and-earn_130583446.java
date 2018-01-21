import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
    	int n = nums.length;
    	if (n == 0) return 0;
    	Arrays.sort(nums);
        int maxD = nums[n - 1];
        int[] dp = new int[maxD + 1];
        int index = 0;
        for (int k = 1; k <= maxD; ++k) {
        	if (index == n || nums[index] > k) {
        		dp[k] = dp[k - 1];
        	} else {
	        	int d = nums[index];
	        	int next = index;
	        	while (next < n && nums[next] == d) {
	        		++next;
	        	}
	        	dp[d] = d * (next - index);
	            if (d - 1 >= 0) {
	                dp[d] = Math.max(dp[d], dp[d - 1]);
	            }
	        	if (d - 2 >= 0) {
	        		dp[d] = Math.max(dp[d - 2] + d * (next - index), dp[d]);
	        	}
	        	index = next;
        	}
        	//System.out.println(k + " " + dp[k] + " " + index);
        }
        //System.out.println(dp[maxD]);
        return dp[maxD];
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,2,4,5,5,5,6};
        solution.deleteAndEarn(nums);
        		
    }
}