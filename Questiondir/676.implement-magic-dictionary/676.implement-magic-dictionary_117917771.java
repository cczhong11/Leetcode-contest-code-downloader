class MagicDictionary {

    private Set<String> dict;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        dict = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            this.dict.add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String s : dict) {
            if (s.length() != word.length()) {
                continue;
            } else {
                int changesUsed = 0;
                boolean good = true;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != s.charAt(i)) {
                        if (changesUsed > 1) {
                            good = false;
                            break;
                        } else {
                            ++changesUsed;
                        }
                    } else {
                        continue;
                    }
                }
                if (changesUsed == 1) {
                    return true;
                }
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