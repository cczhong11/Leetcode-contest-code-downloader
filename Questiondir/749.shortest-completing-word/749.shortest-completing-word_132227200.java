class Solution {
	public String shortestCompletingWord(String licensePlate, String[] words) {
		String plate = licensePlate.toLowerCase();
		int[] count = new int[26];
		int targetTotal = 0;
		for (int i = 0; i < plate.length(); i++) {
			char ch = plate.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				count[ch - 'a']++;
				targetTotal++;
			}
		}

		int[] count2 = new int[26];
		String ans = null;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			for (int j = 0; j < 26; j++) {
				count2[j] = count[j];
			}
			int total = 0;
			for (int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);
				if (ch >= 'a' && ch <= 'z') {
					if (count2[ch - 'a']-- > 0) {
						total++;
					}
				}
			}
			if (total == targetTotal) {
				if (ans == null || ans.length() > word.length()) {
					ans = word;
				}
			}
		}
		return ans;
	}
}