class MagicDictionary {

 	private Set<String> set = new HashSet<>();
	/** Initialize your data structure here. */
	public MagicDictionary() {

	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (int i = 0; i < dict.length; i++) {
			set.add(dict[i]);
		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word
	 * after modifying exactly one character
	 */
	public boolean search(String word) {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			char[] s = word.toCharArray();
			for (int j = 0; j < 26; j++) {
				if (j + 'a' == ch) continue;
				s[i] = (char) (j + 'a');
				String str = new String(s);
				if (set.contains(str)) {
					return true;
				}
				s[i] = ch;
			}
		}
		return false;
	}
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */