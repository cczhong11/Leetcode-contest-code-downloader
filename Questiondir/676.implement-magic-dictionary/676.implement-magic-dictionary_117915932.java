class MagicDictionary {
    Set<String> set;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if (dict == null) return;
        for (int i = 0; i < dict.length; i++) {
            set.add(dict[i]);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null) return false;
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i + 1);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(prefix).append(ch).append(suffix);
                if (set.contains(sb.toString())) return true;
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