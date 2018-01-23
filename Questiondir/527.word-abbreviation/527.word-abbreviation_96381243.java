public class Solution {
    class Node {
        int count;
        Node[] children;
        Node() {
            count = 0;
            children = new Node[26];
        }
    }
    private void addWord(Node root, String word) {
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(root.children[index] == null) root.children[index] = new Node();
            root = root.children[index];
            root.count++;
        }
    }
    private int uniqueIndex(Node root, String word) {
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            root = root.children[index];
            if(root.count == 1) return i + 1;
        }
        return word.length();
    }
    public List<String> wordsAbbreviation(List<String> dict) {
        if(dict == null) return new ArrayList<>();
        List<String> res = new ArrayList<>(dict.size());
        for(String word : dict) {
            if(word.length() < 4) res.add(word);
            else {
                res.add(word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1));
            }
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < res.size(); i++) {
            List<Integer> list = map.get(res.get(i));
            if(list == null) {
                list = new ArrayList<>();
                map.put(res.get(i), list);
            }
            list.add(i);
        }
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> indices = entry.getValue();
            if(indices.size() > 1) {
                Node root = new Node();
                for(int index : indices) {
                    addWord(root, dict.get(index));
                }
                for(int index : indices) {
                    String word = dict.get(index);
                    int i = uniqueIndex(root, word);
                    if(word.length() - i > 2) {
                        res.set(index, word.substring(0, i) + 
                                Integer.toString(word.length() - i - 1) + 
                                word.charAt(word.length() - 1));
                    } else {
                        res.set(index, word);
                    }
                }
            }
        }
        return res;
    }
}