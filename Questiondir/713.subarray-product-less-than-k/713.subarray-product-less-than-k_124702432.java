class Solution {
 	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int ans = 0;
		int n = nums.length;
		long product = 1;
		for (int i = 0, j = 0; i < n; i++) {
			if (nums[i] >= k) {
				product = 1;
				j = i;
				continue;
			}
			if (i - 1 >= 0) {
				product = Math.max(1L, product / nums[i - 1]);
			}
			if (j < i) j = i;
			while (j < n && product * nums[j] < k) {
				product *= nums[j++];
			}
			//System.out.println("j = " + j + " i = " + i + " product = " + product);
			ans += (j - i);
		}
		return ans;
	}
}