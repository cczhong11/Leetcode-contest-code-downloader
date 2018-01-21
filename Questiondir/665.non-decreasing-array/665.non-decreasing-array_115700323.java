class Solution {
	public boolean checkPossibility(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				int prev = nums[i - 1];
				int curr = nums[i];

				nums[i] = prev;
				//System.out.println(Arrays.toString(nums));
				boolean ok = true;
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] < nums[j - 1]) {
						ok = false;
						break;
					}
				}
				if (ok)
					return true;

				nums[i - 1] = curr;
				nums[i] = curr;
				
				//System.out.println(Arrays.toString(nums));

				ok = true;
				for (int j = 1; j < nums.length; j++) {
					if (nums[j] < nums[j - 1]) {
						ok = false;
						break;
					}
				}
				if (!ok)
					return false;
				return true;
			}
		}
		return true;
	}
}