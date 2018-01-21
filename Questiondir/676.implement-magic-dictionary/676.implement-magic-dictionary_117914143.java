import java.util.HashSet;
import java.util.Set;

class MagicDictionary {

    Set<String> set;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        set = new HashSet<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        set = new HashSet<>();
        for (String str : dict)
            set.add(str);
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        char[] s = word.toCharArray();
        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            for (char j = 'a'; j <= 'z'; j++)
                if (j != ch) {
                    s[i] = j;
                    if (set.contains(String.valueOf(s))) return true;
                }
            s[i] = ch;
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