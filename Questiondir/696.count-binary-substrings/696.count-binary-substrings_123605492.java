class Solution {
    public int countBinarySubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				count++;
				int left = i - 1;
				int right = i + 2;
				while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(i)
						&& s.charAt(right) == s.charAt(i + 1)) {
					count++;
					left--;
					right++;
				}
			}
		}
		return count;
    }
}