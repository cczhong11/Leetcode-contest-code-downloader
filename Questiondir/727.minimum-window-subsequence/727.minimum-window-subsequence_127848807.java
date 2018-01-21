class Solution {
	public String minWindow(String S, String T) {
		int n = S.length();
		int[][] next = new int[n][26];
		for (int j = 0; j < 26; j++) {
			next[n - 1][j] = -1;
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < 26; j++) {
				if (S.charAt(i + 1) - 'a' == j) {
					next[i][j] = i + 1;
				} else {
					next[i][j] = next[i + 1][j];
				}
			}
		}

		int start = -1;
		int end = -1;
		int ans = -1;
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) != T.charAt(0))
				continue;
			int cur = i;
			boolean ok = true;
			for (int j = 0; j < T.length(); j++) {
				if (S.charAt(cur) != T.charAt(j)) {
					ok = false;
					break;
				}
				if (j + 1 < T.length()) {
					cur = next[cur][T.charAt(j + 1) - 'a'];
				}
				if (cur < 0) {
					ok = false;
					break;
				}
			}
			if (ok) {
				//System.out.println("i = " + i + " cur = " + cur + " ans = " + ans);
				if (ans < 0 || (cur - i + 1) < ans) {
					
					start = i;
					end = cur;
					ans = cur - i + 1;
				}
			}
		}
		if (ans >= 0)
			return S.substring(start, end + 1);
		return "";
	}
}