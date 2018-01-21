class Solution {
 	public int pivotIndex(int[] nums) {
		if (nums.length == 0) return -1;
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		
		int cur = 0;
		for (int i = 0; i < n; i++) {
			if (sum - cur - nums[i] == cur) {
				return i;
			}
			cur += nums[i];
		}
		return -1;
	}
}