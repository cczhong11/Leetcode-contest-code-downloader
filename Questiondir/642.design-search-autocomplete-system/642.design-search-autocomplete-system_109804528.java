import java.util.*;

public class AutocompleteSystem {
    StringBuilder builder = new StringBuilder();
    Map<String, Integer> map = new HashMap<>();

    class TrieNode {
        List<String> words = new ArrayList<>();
        TrieNode[] nodes = new TrieNode[27];
    }

    TrieNode root = new TrieNode();
    TrieNode last = root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i=0; i<sentences.length; i++) {
            String s = sentences[i];
            map.put(s, times[i]);
            TrieNode node = root;
            for(char c: s.toCharArray()) {
                int index = 26;
                if(c != ' ') index = (c-'a');
                if(node.nodes[index] == null) {
                    node.nodes[index] = new TrieNode();
                }
                node = node.nodes[index];
                node.words.add(s);
            }
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            String s = builder.toString();
            builder = new StringBuilder();
            map.put(s, map.getOrDefault(s, 0)+1);

            TrieNode node = root;
            for(char cc: s.toCharArray()) {
                int index = 26;
                if(cc != ' ') index = (cc-'a');
                if(node.nodes[index] == null) {
                    node.nodes[index] = new TrieNode();
                }
                node = node.nodes[index];
                if(!node.words.contains(s)) {
                    node.words.add(s);
                }
            }

            last = root;
            return new ArrayList<>();
        } else {
            builder.append(c);
            int index = 26;
            if(c != ' ') index = (c-'a');
            if(last == null || last.nodes[index] == null) {
                last = null;
                return new ArrayList<>();
            }
            last = last.nodes[index];
            List<String> words = last.words;
            if(words.size() <=1) return words;

            int[][] arrays = new int[words.size()][2];
            for(int i=0; i<words.size(); i++) {
                arrays[i][0] = map.get(words.get(i));
                arrays[i][1] = i;
            }

            Arrays.sort(arrays, (a,b) -> {
                if(a[0] != b[0]) {
                    return b[0]-a[0];
                }
                return words.get(a[1]).compareTo(words.get(b[1]));
            });

            List<String> list = new ArrayList<>();
            for(int i=0; i<Math.min(3, arrays.length); i++) {
                list.add(words.get(arrays[i][1]));
            }

            return list;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */