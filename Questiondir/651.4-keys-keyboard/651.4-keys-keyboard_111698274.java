public class Solution {
	public class Pair {
		 int cur;
		 int buffer;
		 Pair(int cur, int buffer) { this.cur = cur; this.buffer = buffer;}
	}
	
    public int maxA(int N) {
    		if(N == 1) return 1;
    		int step = 1;
    		
    		ArrayList<PriorityQueue<Pair>> haha = new ArrayList<PriorityQueue<Pair>>();
    		for(int i = 0; i <= N; i++) {
    			haha.add(new PriorityQueue<>(new Comparator<Pair>() {public int compare(Pair p1, Pair p2) {
	    				return Integer.compare(p2.cur, p1.cur);
	    			}
	    		}));
    		}
    			
    		haha.get(1).add(new Pair(1, 0));
    		for(int i = 1; i < N; i++) {
    			PriorityQueue<Pair> queue = haha.get(i);
    			Pair p = queue.poll();
    			int bufferSize = p.buffer;
    			
    			haha.get(i+1).add(new Pair(p.cur + 1, p.buffer)); // A
    			if(i + 2 <= N) haha.get(i+2).add(new Pair(p.cur, p.cur)); // Select and Copy
    			haha.get(i+1).add(new Pair(p.cur + p.buffer, p.buffer)); // Paste
        		
        		while(!queue.isEmpty()) {
        			Pair p2 = queue.poll();
        			if(p2.buffer < bufferSize) {
        				continue;
        			} else {
        				bufferSize = p2.buffer;
        				haha.get(i+1).add(new Pair(p2.cur + 1, p2.buffer)); // A
            			if(i + 2 <= N) haha.get(i+2).add(new Pair(p2.cur, p2.cur)); // Select and Copy
            			haha.get(i+1).add(new Pair(p2.cur + p2.buffer, p2.buffer)); // Paste
        			}
        		}
    		}
    		
    		int res = 0;
    		PriorityQueue<Pair> queue = haha.get(N);
    		while(!queue.isEmpty()) res = Integer.max(res, queue.poll().cur);
    		return res;
    }
}