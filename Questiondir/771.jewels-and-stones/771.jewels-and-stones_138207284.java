import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
	void swap(char[] x, int i, int j) {
		char tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
	}
	
    public int slidingPuzzle(int[][] board) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String finalState = "123450";
        for (int i = 0; i < 2; ++i) {
        	for (int j = 0; j < 3; ++j) {
        		sb.append((char)(board[i][j] + '0'));
        	}
        }
        map.put(sb.toString(), 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(sb.toString());
        while (!queue.isEmpty()) {
        	String cur = queue.poll();
        	int d = map.get(cur);
        	int pos = cur.indexOf('0');
            //System.out.println(cur + " " + d + " " + pos);
        	if (cur.equals(finalState)) {
        		return d;
        	}
        	int[] npos = new int[]{pos + 1, pos - 1, (pos + 3) % 6};
        	for (int p : npos) {
        		if (p >= 0 && p < 6) {
        			if (Math.abs(p - pos) == 1 && p + pos == 5) {
        				continue;
        			}
            		char[] ns = cur.toCharArray();
            		swap(ns, pos, p);
            		String nstate = String.valueOf(ns);
            		if (!map.containsKey(nstate)) {
            			map.put(nstate, d + 1);
            			queue.offer(nstate);
            		}
        		}
        	}
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[][] board = {{3, 2, 4}, {1, 5, 0}};
    	System.out.println(solution.slidingPuzzle(board));
    }
}