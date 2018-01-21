class Solution {
    public int minimumDeleteSum(String s1, String s2) {
		int[][] cache = new int[s1.length() + 1][s2.length() + 1];
		for (int[] c : cache) {
			Arrays.fill(c, -1);
		}
		return deleteChar(s1, s2, 0, 0, cache);
	}

	private static int deleteChar(String s1, String s2, int index1, int index2, int[][] cache) {
		if (cache[index1][index2] == -1) {
			int sum;
			if (index1 == s1.length() && index2 == s2.length()) {
				sum = 0;
			} else if (index1 == s1.length()) {
				sum = s2.charAt(index2) + deleteChar(s1, s2, index1, index2 + 1, cache);
			} else if (index2 == s2.length()) {
				sum = s1.charAt(index1) + deleteChar(s1, s2, index1 + 1, index2, cache);
			} else if (s1.charAt(index1) == s2.charAt(index2)) {
				sum = deleteChar(s1, s2, index1 + 1, index2 + 1, cache);
			} else {
				sum = Integer.min(s1.charAt(index1) + deleteChar(s1, s2, index1 + 1, index2, cache),
						s2.charAt(index2) + deleteChar(s1, s2, index1, index2 + 1, cache));
			}
			cache[index1][index2] = sum;
		}
		return cache[index1][index2];
    }
}