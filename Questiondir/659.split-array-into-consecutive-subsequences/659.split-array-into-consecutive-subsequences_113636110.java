public class Solution {
    static class Sequence implements Comparable<Sequence> {
		int count = 0;
		int last = 0;
		Sequence(int first) {
			this.last = first;
			count = 1;
		}
		
		boolean add(int next) {
			if (next == last+1) {
				last = next;
				count++;
				return true;
			}
			return false;
		}
		
		@Override
		public int compareTo(Sequence arg0) {
			return count - arg0.count;
		}
	}
	
	public boolean isPossible(int[] nums) {
		PriorityQueue<Sequence> cur = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (cur.isEmpty()) {
				cur.add(new Sequence(n));
				continue;
			}
			PriorityQueue<Sequence> next = new PriorityQueue<>();
			boolean add = false;
			while (!cur.isEmpty()) {
				Sequence s = cur.remove();
				if (!add) {
					add = s.add(n);
				}
				if (s.last < n - 1) {
					if (s.count < 3) {
						return false;
					}
				} else {
					next.add(s);
				}
			}
			if (!add) {
				next.add(new Sequence(n));
			}
			cur = next;
		}
		while (!cur.isEmpty()) {
			Sequence s = cur.remove();
			if (s.count < 3) {
				return false;
			}
		}
		return true;
    }
}