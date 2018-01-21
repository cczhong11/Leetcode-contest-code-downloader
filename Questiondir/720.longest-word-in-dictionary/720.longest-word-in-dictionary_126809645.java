class Solution {
    private static class TrieNode {
        TrieNode[] subs = new TrieNode[26];
        boolean accept = false;
        
        public void insert(String word, int idx) {
            if (idx == word.length()) {
                accept = true;
            } else {
                int i = word.charAt(idx)-'a';
                if (null == subs[i]) {
                    subs[i] = new TrieNode();
                }
                subs[i].insert(word, idx+1);
            }
        }
    }
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            @Override public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    return b.compareTo(a);
                }
            }
        });
        TrieNode root = new TrieNode();
        String result = "";
        for (String word : words) {
            TrieNode node = root;
            for (int i=0; i+1<word.length(); i++) {
                node = node.subs[word.charAt(i)-'a'];
                if (null == node || !node.accept) {
                    break;
                }
            }
            if (word.length() == 1 || null != node && node.accept) {
                result = word;
            }
            root.insert(word, 0);
        }
        return result;
    }
}