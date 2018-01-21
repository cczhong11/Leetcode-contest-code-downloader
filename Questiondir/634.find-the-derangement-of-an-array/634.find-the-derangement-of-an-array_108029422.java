public class Solution {
	public int findDerangement(int n) {
		if (n == 1) return 0;
		if (n == 2) return 1;
		
		long mod = 1000000000 + 7;
		long tn = (long) n;
		
		long last = 1;
		long d = -1;
		for (long i = 3; i <= tn; i++) {
			long cur = ((last * i + d) % mod + mod) % mod;
			d = -d;
			last = cur;
		}
		return (int) last;
	}
}