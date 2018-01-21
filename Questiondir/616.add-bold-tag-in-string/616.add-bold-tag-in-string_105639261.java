public class Solution {
	public String addBoldTag(String s, String[] dict) {
		int n = s.length();
		boolean[] dp = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			int max = 0;
			String sub = s.substring(i);
			for (String d : dict) {
				if (sub.startsWith(d)) {
					max = Math.max(max, d.length());
				}
			}
			for (int j = i; j < i + max; j++) {
				dp[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ) {
			int j = i;
			while (j < n && dp[i] == dp[j]) j++;
			if (dp[i]) {
				sb.append("<b>" + s.substring(i, j) + "</b>");
			} else {
				sb.append(s.substring(i, j));
			}
			i = j;
		}
		return sb.toString();
		
	}
}