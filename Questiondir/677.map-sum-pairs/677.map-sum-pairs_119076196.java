import java.util.HashMap;
import java.util.Map;

class MapSum {

    private static class Trie {
        int num;
        int sum;
        boolean isWord;
        Map<Character, Trie> next;

        public Trie() {
            num = 0;
            sum = 0;
            isWord = false;
            next = new HashMap<>();
        }

        int insert(String s, int index, int val) {
            if (index == s.length()) {
                if (isWord) {
                    int delta = val - num;
                    num = val;
                    sum += delta;
                    return delta;
                } else {
                    isWord = true;
                    num = val;
                    sum += val;
                    return val;
                }
            }
            char c = s.charAt(index);
            if (!next.containsKey(c)) {
                next.put(c, new Trie());
            }
            int delta = next.get(c).insert(s, index + 1, val);
            sum += delta;
            return delta;
        }

        int getSum(String s, int index) {
            if (index == s.length()) {
                return sum;
            }
            char c = s.charAt(index);
            if (next.containsKey(c)) {
                return next.get(c).getSum(s, index + 1);
            } else {
                return 0;
            }
        }

    }

    Trie trie;

    /** Initialize your data structure here. */
    public MapSum() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, 0, val);
    }

    public int sum(String prefix) {
        return trie.getSum(prefix, 0);
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
        obj.insert("apple", 1);
        System.out.println(obj.sum("ap"));


    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */