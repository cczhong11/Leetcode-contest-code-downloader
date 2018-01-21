class MapSum {
    private Map<String, Integer> words2Sum;
    private Map<String, Set<String>> prefix2Word;

    /** Initialize your data structure here. */
    public MapSum() {
        words2Sum = new HashMap<>();
        prefix2Word = new HashMap<>();
    }

    public void insert(String key, int val) {
        words2Sum.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            if (!prefix2Word.containsKey(prefix)) {
                prefix2Word.put(prefix, new HashSet<>());
            }
            prefix2Word.get(prefix).add(key);
        }
    }

    public int sum(String prefix) {
        if (!prefix2Word.containsKey(prefix)) {
            return 0;
        }
        int sum = 0;
        for (String word : prefix2Word.get(prefix)) {
            sum += words2Sum.get(word);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */