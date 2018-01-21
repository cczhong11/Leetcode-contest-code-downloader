class Solution {
    public int openLock(String[] deadends, String target) {
    	Set<String> vis = new HashSet<>();
    	for (int i = 0; i < deadends.length; ++i) {
    		vis.add(deadends[i]);
    	}
    	
    	Queue<String> queue = new ArrayDeque<>();
    	queue.offer("0000");
    	if (vis.contains("0000")) return -1;
    	
    	vis.add("0000");
    	int[] downUp = {1, -1};
    	int turn = 0;
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		for (int i = 0; i < size; ++i) {
    			String now = queue.poll();
    			if (now.equals(target)) {
    				return turn;
    			}
    			for (int j = 0; j < 4; ++j) {
    				for (int k = 0; k < 2; ++k) {
    					char[] cs = now.toCharArray();
    					int digit = (cs[j] - '0' + downUp[k] + 10) % 10;
    					cs[j] = (char) ('0' + digit);
    					String nxt = new String(cs);
    					if (!vis.contains(nxt)) {
    						vis.add(nxt);
    						queue.offer(nxt);
    					}
    				}
    			}
    		}
    		turn ++;
    	}
    	return -1;
    }
}