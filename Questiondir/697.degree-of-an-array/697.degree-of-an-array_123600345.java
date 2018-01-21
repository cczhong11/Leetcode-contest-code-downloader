class Solution {
    public int findShortestSubArray(int[] nums) {
		int[] counts = new int[50000];
		int[][] indexes = new int[50000][2];
		for (int[] index : indexes) {
			index[0] = 50000;
			index[1] = -1;
		}
		int degree = 0;
		for (int i = 0; i < nums.length; i++) {
			counts[nums[i]]++;
			if (counts[nums[i]] > degree) {
				degree = counts[nums[i]];
			}
			indexes[nums[i]][0] = Integer.min(indexes[nums[i]][0], i);
			indexes[nums[i]][1] = Integer.max(indexes[nums[i]][1], i);
		}
		int len = 50000;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == degree) {
				len = Math.min(len, indexes[i][1] - indexes[i][0] + 1);
			}
		}
		return len;
    }
}