public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
		int[] nums = new int[arr.size()];
		int i = 0;
		for (int num : arr) {
			nums[i++] = num;
		}
		int index = Arrays.binarySearch(nums, x);
		if (index < 0) {
			index = -1 - index;
		}
		if (index == 0) {
			return arr.subList(0, k);
		}
		if (index == nums.length) {
			return arr.subList(nums.length - k, nums.length);
		}
		int left = index - 1;
		int right = index;
		int count = 0;
		while (count < k) {
			int leftDiff = left >= 0 ? Math.abs(x - nums[left]) : Integer.MAX_VALUE;
			int rightDiff = right < nums.length ? Math.abs(x - nums[right]) : Integer.MAX_VALUE;
			if (leftDiff <= rightDiff) {
				left--;
			} else {
				right++;
			}
			count++;
		}
		return arr.subList(left + 1, right);
    }
}