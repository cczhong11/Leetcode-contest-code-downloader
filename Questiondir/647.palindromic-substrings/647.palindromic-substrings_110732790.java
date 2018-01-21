public class Solution {
    public int countSubstrings(String s) {
		int total = 0;
		OUTER: for (int i = 0; i < s.length(); i++) {
			total++;
			for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
				if (s.charAt(i-j) == s.charAt(i+j)) {
					total++;
				} else {
					continue OUTER;
				}
			}
		}
		OUTER2: for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				total++;
				for (int j = 1; i - j >= 0 && i + j + 1 < s.length(); j++) {
					if (s.charAt(i-j) == s.charAt(i+j+1)) {
						total++;
					} else {
						continue OUTER2;
					}
				}
			}
		}
		return total;
    }
}