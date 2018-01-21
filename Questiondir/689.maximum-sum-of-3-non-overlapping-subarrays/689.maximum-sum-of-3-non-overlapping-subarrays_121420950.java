class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        System.out.println("length"+nums.length);
    	int[] s = new int[nums.length];
        int sum = 0;
        for (int i=0;i<k;++i) {
        	sum+=nums[i];
        }
        s[0]=sum;
        for (int i=1;i<=nums.length-k;++i) {
        	sum-=nums[i-1];
        	sum+=nums[i+k-1];
        	s[i]=sum;
        }

        int[] dp = new int[nums.length];
        for (int i=0;i<nums.length;++i) {
        	dp[i]=-1;
        }
        for (int i=nums.length-k;i>=0;--i) {
        	dp[i]=i;
        	if (i+1<nums.length && dp[i+1]>=0) {
        		if (s[dp[i+1]]>s[dp[i]]) {
        			dp[i]=dp[i+1];
        		}
        	}
        }
        
        int[][] dp2 = new int[nums.length][2];
        for (int i=0;i<nums.length;++i) {
        	for (int j=0;j<2;++j) {
        		dp2[i][j]=-1;
        	}
        }
        for (int i=nums.length-2*k;i>=0;--i) {
        	dp2[i][0]=i;
        	dp2[i][1]=dp[i+k];
        	if (i+1<nums.length && dp2[i+1][0]>-1 && dp2[i+1][1]>-1) {
        		int sum1 = s[dp2[i][0]]+s[dp2[i][1]];
        		int sum2 = s[dp2[i+1][0]]+s[dp2[i+1][1]];
        		if (sum2>sum1) {
        			dp2[i][0]=dp2[i+1][0];
        			dp2[i][1]=dp2[i+1][1];
        		}
        	}
        }
        int[][] dp3 = new int[nums.length][3];
        for (int i=0;i<nums.length;++i) {
        	for (int j=0;j<3;++j) {
        		dp3[i][j]=-1;
        		}
        }
        for (int i=nums.length-3*k;i>=0;--i) {
        	dp3[i][0]=i;
        	dp3[i][1]=dp2[i+k][0];
        	dp3[i][2]=dp2[i+k][1];
        	if (i+1<nums.length && check(dp3[i+1])) {
        		int sum1 = getSum(s,dp3[i]);
        		int sum2 = getSum(s,dp3[i+1]);
        		if (sum2>sum1) {
        			dp3[i][0]=dp3[i+1][0];
        			dp3[i][1]=dp3[i+1][1];
        			dp3[i][2]=dp3[i+1][2];
        		}
        	}
        }
        
        return dp3[0];
    }


	private int getSum(int[] s, int[] is) {
		int sum = 0;
		for (int i=0;i<is.length;++i) {
			sum+=s[is[i]];
		}
		return sum;
	}


	private boolean check(int[] is) {
		for (int i=0;i<is.length;++i) {
			if (is[i]==-1)
				return false;
		}
		return true;
	}
}