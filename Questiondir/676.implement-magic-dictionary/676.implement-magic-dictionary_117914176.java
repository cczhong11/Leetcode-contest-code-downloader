class MagicDictionary {
    HashSet<String> set;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        set = new HashSet<>();
        for (String word: dict){
            set.add(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String word2: set){
            if (dis(word,word2)==1)
                return true;
        }
        return false;
    }
    
    private int dis(String word1, String word2){
        if (word1.length()!=word2.length())
            return Integer.MAX_VALUE;
        int res = 0;
        for (int i=0; i<word1.length(); i++){
            if (word1.charAt(i)!=word2.charAt(i))
                res++;
            if (res>1)
                return 2;
        }
        return res;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */