public class Solution {
private static class Combine implements Comparable<Combine> {
		int value;
		int listIdx;
		int idx;

		Combine(int value, int listIdx, int idx) {
			this.value = value;
			this.listIdx = listIdx;
			this.idx = idx;
		}

		@Override
		public int compareTo(Combine arg0) {
			return value - arg0.value;
		}

	}
	
	public int[] smallestRange(int[][] nums) {
		if (nums.length == 1) {
			return new int[]{nums[0][0], nums[0][0]};
		}
		PriorityQueue<Combine> q = new PriorityQueue<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i][0];
			max = Math.max(curr, max);
			min = Math.min(curr, min);
			q.add(new Combine(nums[i][0], i, 0));
		}
		int currRange = max - min;
		int pMax = max;
		int pMin = min;
		while (true) {
			Combine c = q.poll();
			// one list is exhausted
			if (nums[c.listIdx].length == c.idx + 1) {
				break;
			}
			Combine n = new Combine(nums[c.listIdx][c.idx+1], c.listIdx, c.idx + 1);
			q.add(n);
			pMax = Math.max(pMax, n.value);
			pMin = q.peek().value;
			if (pMax - pMin < currRange) {
				currRange = pMax - pMin;
				max = pMax;
				min = pMin;
			}
		}
		return new int[]{min, max};
    }
}