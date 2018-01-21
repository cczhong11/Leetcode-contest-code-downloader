class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = nums[1] - nums[0];
        int n = nums.length;
        for (int i = 1; i <= n - 2; i++) {
        	low = Math.min(low, nums[i + 1] - nums[i]);
        }
        int high = nums[n - 1] - nums[0];
        while (low < high) {
        	int mid = low + (high - low) / 2;
        	if (countPairs(nums, n, mid) < k) low = mid + 1;
        	else high = mid;
        }
        return low;
    }
	
	public int countPairs(int[] nums, int n, int mid) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			int index = binarySearch(nums, i, n, nums[i] + mid) - (i + 1);
			res += index;
		}
		return res;
	}
	
	public int binarySearch(int[] nums, int startIndex, int endIndex, int value) {
		int low = startIndex;
		int high = endIndex;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] <= value) low = mid + 1;
			else high = mid;
		}
		return low;
	}
}