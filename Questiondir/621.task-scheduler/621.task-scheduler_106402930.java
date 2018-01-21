public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Node> taskMap = new HashMap<>();
        for(char currChar : tasks) {
        	if(taskMap.containsKey(currChar)) taskMap.get(currChar).time ++;
        	else taskMap.put(currChar, new Node(currChar));
        }
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> - n1.time + n2.time);
        for(Node node : taskMap.values()) queue.offer(node);
        Map<Integer, Node> coolDown = new HashMap<>();
        int time = 0;
        while(!queue.isEmpty() || !coolDown.isEmpty()) {
        	if(coolDown.containsKey(time - n - 1)) {
        		queue.offer(coolDown.remove(time - n - 1));
        	}
        	if(queue.isEmpty()) {
        		time ++;
        	}
        	else {
        	  Node node = queue.poll();
        	  node.time --;
        	  if(node.time != 0) coolDown.put(time, node);
        	  time ++;
        	}
        }
        return time;
    }
    
    class Node {
    	int time = 1;
    	char letter;
    	public Node(char letter) {
    		this.letter = letter;
    	}
    }
}