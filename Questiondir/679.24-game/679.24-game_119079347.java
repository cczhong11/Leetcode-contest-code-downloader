 class Solution {
    public boolean judgePoint24(int[] nums) {
        int n = nums.length;
        double[] f = new double[n];
        for (int i = 0; i < n; ++i) {
            f[i] = nums[i];
        }
        return judge(f);
    }
    
    boolean judge(double[] nums) {
    	int n = nums.length;
    	if (n == 1) {
    		return Math.abs(nums[0] - 24) < 1e-8;
    	} else {
    		for (int i = 0; i < n; ++i) {
    			for (int j = 0; j < n; ++j) {
    				if (i == j) continue;
    				double[] next = new double[n - 1];
    				int index = 0;
    				for (int k = 0; k < n; ++k) {
    					if (k != i && k != j) {
    						next[index++] = nums[k];
    					}
    				}
    				next[index] = nums[i] + nums[j]; if (judge(next)) return true;
    				next[index] = nums[i] - nums[j]; if (judge(next)) return true;
    				next[index] = nums[i] * nums[j]; if (judge(next)) return true;
    				if (Math.abs(nums[j]) > 1e-6) {
    					next[index] = nums[i] / nums[j]; if (judge(next)) return true;
    				}
    			}
    		}
    		return false;
    	}
    }
}