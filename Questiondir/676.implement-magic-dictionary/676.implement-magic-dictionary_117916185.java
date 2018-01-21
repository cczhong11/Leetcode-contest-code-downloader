class MagicDictionary {
    private Set<String> set = new HashSet<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        set.clear();
        set.addAll(Arrays.asList(dict));
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] ca = word.toCharArray();
        for(int i = 0 ; i < ca.length; i++) {
            char origin = ca[i];
            for(char j = 'a'; j <= 'z'; j++) {
                if(j == origin) continue;
                ca[i] = j;
                if(set.contains(new String(ca))) {
                    return true;
                }
            }
            ca[i] = origin;
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