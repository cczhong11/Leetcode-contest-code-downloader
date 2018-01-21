public class Solution {
	public String replaceWords(List<String> dict, String sentence) {
		if (sentence.length() == 0)
			return sentence;
		int maxLen = 0;
		for (String word : dict) {
			maxLen = Math.max(maxLen, word.length());
		}
		Set<String> st = new HashSet<>(dict);

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				int j = i + 1;
				while (j < sentence.length() && sentence.charAt(j) >= 'a' && sentence.charAt(j) <= 'z') {
					j++;
				}
				String word = sentence.substring(i, j);
				int len = Math.min(maxLen, word.length());

				boolean found = false;
				for (int k = 0; k < len; k++) {
					String sub = word.substring(0, k + 1);
					if (st.contains(sub)) {
						res.append(sub);
						found = true;
						break;
					}
				}

				if (!found) {
					res.append(word);
				}

				i = j - 1;
			} else {
				res.append(ch);
			}

		}
		return res.toString();
	}
}