public class AutocompleteSystem {
	private final Map<String, Integer> sMap;
	
    public AutocompleteSystem(String[] sentences, int[] times) {
        sMap = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
        	sMap.put(sentences[i], times[i]);
        }
    }
    
    static class SearchTerm implements Comparable<SearchTerm> {
    	String sentence;
    	int time;
    	SearchTerm(String sentence, int time) {
    		this.sentence = sentence;
    		this.time = time;
    	}
		@Override
		public int compareTo(SearchTerm o) {
			if (time == o.time) {
				return sentence.compareTo(o.sentence);
			}
			return o.time - time;
		}
    }
    
    private PriorityQueue<SearchTerm> pq = new PriorityQueue<>();
    private int idx = 0;
    private String cur = "";
    
    public List<String> input(char c) {
    	List<String> ret = new ArrayList<>();
        if (c == '#') {
        	pq = new PriorityQueue<>();
        	idx = 0;
        	sMap.put(cur, sMap.getOrDefault(cur, 0) + 1);
        	cur = "";
        	return ret;
        }
        cur += c;
        if (idx == 0) {
        	// first char
        	for (Map.Entry<String, Integer> e : sMap.entrySet()) {
        		if (e.getKey().length() > 0 && e.getKey().charAt(0) == c) {
        			pq.add(new SearchTerm(e.getKey(), e.getValue()));
        		}
        	}
        } else {
        	// subsequent char
        	PriorityQueue<SearchTerm> pqr = new PriorityQueue<>();
        	while(!pq.isEmpty()) {
        		SearchTerm t = pq.poll();
        		if (t.sentence.length() > idx && t.sentence.charAt(idx) == c) {
        			pqr.add(t);
        		}
        	}
        	pq = pqr;
        }
        List<SearchTerm> l = new ArrayList<>();
        while(!pq.isEmpty() && ret.size() < 3) {
    		SearchTerm t = pq.poll();
    		ret.add(t.sentence);
    		l.add(t);
    	}
        pq.addAll(l);
        idx++;
        return ret;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */