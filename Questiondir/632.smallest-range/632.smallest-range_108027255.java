public class Solution {
	public int[] smallestRange(int[][] nums) {
		if (nums.length == 0) return new int[0];
		class Node {
			public int[] num;
			public int index;
			public Node(int[] num, int index) {
				this.num = num;
				this.index = index;
			}
		}
		TreeSet<Node> set = new TreeSet<>((a, b) -> {
			if (a.num[a.index] == b.num[b.index]) {
				return a.num.hashCode() - b.num.hashCode();
			} else {
				return a.num[a.index] - b.num[b.index];
			}
		});
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].length == 0) return new int[0];
			set.add(new Node(nums[i], 0));
		}
		int[] res = null;
		while (true) {
			Node first = set.first();
			Node last = set.last();
			int firstValue = first.num[first.index];
			int lastValue = last.num[last.index];
			if (res == null) {
				res = new int[2];
				res[0] = firstValue;
				res[1] = lastValue;
			} else if (res[1] - res[0] > lastValue - firstValue) {
				res[0] = firstValue;
				res[1] = lastValue;
			}
			if (first.index + 1 >= first.num.length) break;
			Node newNode = new Node(first.num, first.index + 1);
			set.remove(first);
			set.add(newNode);
		}
		return res;
	}
}