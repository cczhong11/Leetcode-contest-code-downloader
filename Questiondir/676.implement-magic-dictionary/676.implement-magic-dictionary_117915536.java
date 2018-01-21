class MagicDictionary {
    
    private Set<String> set;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            set.add(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == letter) {
                    continue;
                }
                chars[i] = c;
                if (set.contains(new String(chars))) {
                    return true;
                }
            }
            chars[i] = letter;
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