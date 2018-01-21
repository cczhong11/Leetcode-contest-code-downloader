class Solution {
private int upperBound(int[] nums , int target) {
		
		int low = 0 , high = nums.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] > target) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		high --;
		return high;
		
	}
	
	private int get(int[] nums , int target) {
	
		int i , n = nums.length , ans = 0;
		for (i = 0;i < n;i ++) {
			int pos = upperBound(nums , nums[i] + target);
			if (pos >= 0) {
				ans += (pos - i);
			}
		}
		return ans;
		
	}
	
	public int smallestDistancePair(int[] nums, int k) {

		Arrays.sort(nums);
		int low = 0 , high = 2000000;
		while (low < high) {			
			int mid = (low + high) / 2;
			int temp = get(nums , mid);
			if (temp < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
		   
	}
}