public class Solution {
	public boolean judgeSquareSum(int c) {
		if (c == 0)
			return true;
		long n = (long) c;
		Set<Long> set = new HashSet<>();
		set.add(0L);
		for (long i = 0; i * i <= n; i++) {
			long j = n - i * i;
			set.add(i * i);
			if (set.contains(j))
				return true;
		}
		return false;
	}
}