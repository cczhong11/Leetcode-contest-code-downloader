class TrieNode {
    TrieNode[] subs = new TrieNode[26];
    int cnt = 0;
    
    public void insert(String s, int i) {
        cnt++;
        if (i < s.length()-1) {
            int idx = s.charAt(i)-'a';
            
            if (null == subs[idx]) {
                subs[idx] = new TrieNode();
            }
            subs[idx].insert(s, i+1);
        }
    }
}

public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String,TrieNode> map = new HashMap<>();
        
        for (String word : dict) {
            if (word.length() > 3) {
                String key = word.substring(0,1)+String.valueOf(word.length()-2)+
                        word.substring(word.length()-1);
                
                if (!map.containsKey(key)) {
                    map.put(key, new TrieNode());
                }
                map.get(key).insert(word, 1);
            }
        }
        for (int i=0; i<dict.size(); i++) {
            String word = dict.get(i);
            
            if (word.length() > 3) {
                String key = word.substring(0,1)+String.valueOf(word.length()-2)+
                        word.substring(word.length()-1);
                TrieNode node = map.get(key);        
                int j = 1;
                
                while (node.cnt > 1 && word.length()-j > 2) {
                    node = node.subs[word.charAt(j)-'a'];
                    j++;
                }
                if (j < word.length()-2) {
                    dict.set(i, word.substring(0, j)+String.valueOf(word.length()-j-1)+word.substring(word.length()-1));
                }
            }
        }
        return dict;
    }
}