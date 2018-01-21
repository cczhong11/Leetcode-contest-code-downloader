class MagicDictionary {
    Set<String> words;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        words = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s : dict)    words.add(s);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == word.charAt(i))    continue;
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i)).append(k).append(word.substring(i + 1));
                if (words.contains(sb.toString()))  return true;
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