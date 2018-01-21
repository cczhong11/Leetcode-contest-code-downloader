class Solution {
	public int monotoneIncreasingDigits(int N) {
		return dfs(String.valueOf(N), 0, 0, 0);
	}
	
	int dfs(String s, int depth, int last, int cur) {
		if (depth >= s.length()) {
			return cur;
		}
		int d = s.charAt(depth) - '0';
		if (d < last) return -1;
		int t = dfs(s, depth + 1, d, cur * 10 + d);
		if (t >= 0) {
			return t;
		}
		if (d - 1 < last) return -1;
		cur = cur * 10 + (d - 1);
		for (int i = depth + 1; i < s.length(); i++) {
			cur = cur * 10 + 9;
		}
		return cur;
	}

}