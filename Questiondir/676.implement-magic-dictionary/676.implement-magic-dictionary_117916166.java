import java.util.HashSet;
import java.util.Set;

class MagicDictionary {
	String[] theDict;
	int n;
    /** Initialize your data structure here. */
    public MagicDictionary() {
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        int n = dict.length;
        theDict = new String[n];
        for (int i = 0; i < n; ++i) {
        	theDict[i] = new String(dict[i]);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String str : theDict) {
        	if (match(str, word)) {
        		return true;
        	}
        }
        return false;
    }
    
    boolean match(String str, String word) {
    	if (str.length() != word.length()) return false;
    	int cnt = 0;
    	for (int i = 0; i < word.length(); ++i) {
    		cnt += str.charAt(i) != word.charAt(i) ? 1 : 0;
    	}
    	return cnt == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */