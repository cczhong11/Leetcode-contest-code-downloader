class Solution {
    public boolean judgePoint24(int[] nums) {
		double[] n = new double[4];
		for (int i = 0; i < 4; i++) {
			n[i] = nums[i]*1.0;
		}
		return judgePoint24(n);
    }
	
	private boolean judgePoint24(double[] nums) {
		if (nums.length == 2) {
			double a = nums[0];
			double b = nums[1];
			if (is24(a+b) || is24(a-b) || is24(b-a) || is24(a*b) || (a !=0 && is24(b/a)) || (b != 0 && is24(a/b))) {
				return true;
			}
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				double a = nums[i];
				double b = nums[j];
				double[] next = new double[nums.length-1];
				int idx = 0;
				for (int k = 0; k < nums.length; k++) {
					if (k != i && k !=j) {
						next[idx] = nums[k];
						idx++;
					}
				}
				next[idx] = a+b;
				if (judgePoint24(next)) {
					return true;
				}
				next[idx] = a-b;
				if (judgePoint24(next)) {
					return true;
				}
				next[idx] = b-a;
				if (judgePoint24(next)) {
					return true;
				}
				next[idx] = a*b;
				if (judgePoint24(next)) {
					return true;
				}
				if (a!=0) {
					next[idx] = b/a;
					if (judgePoint24(next)) {
						return true;
					}
				}
				if (b!=0) {
					next[idx] = a/b;
					if (judgePoint24(next)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean is24(double d) {
		return Math.abs(24 -d) < 0.00001;
	}

}