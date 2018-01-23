public class Solution {
        public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        if(matrix.size() == 0 || matrix.get(0).size() == 0) return matrix;
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < matrix.size(); i ++) {
        	for(int j = 0; j < matrix.get(0).size(); j ++) {
        		if(matrix.get(i).get(j) == 0) queue.offer(new Node(i, j));
        	}
        }
        
        Set<Integer> set = new HashSet<>();
        int counter = 1;
        while(!queue.isEmpty()) {
        	Queue<Node> nextQueue = new LinkedList<>();
        	while(!queue.isEmpty()) {
        		Node node = queue.poll();
        		if(node.row - 1 >= 0 && matrix.get(node.row - 1).get(node.col) != 0 && !set.contains((node.row - 1) * 31 * 31 + (node.col) * 91)) {
        			matrix.get(node.row - 1).set(node.col, counter);
        			nextQueue.offer(new Node(node.row - 1, node.col));
        			set.add((node.row - 1) * 31 * 31 + (node.col) * 91);
        		}
        		if(node.row + 1 < matrix.size() && matrix.get(node.row + 1).get(node.col) != 0 && !set.contains((node.row + 1) * 31 * 31 + (node.col) * 91)) {
        			matrix.get(node.row + 1).set(node.col, counter);
        			nextQueue.offer(new Node(node.row + 1, node.col));
        			set.add((node.row + 1) * 31 * 31 + (node.col) * 91);
        		}
        		if(node.col - 1 >= 0 && matrix.get(node.row).get(node.col - 1) != 0 && !set.contains((node.row) * 31 * 31 + (node.col - 1) * 91)) {
        			matrix.get(node.row).set(node.col - 1, counter);
        			nextQueue.offer(new Node(node.row, node.col - 1));
        			set.add((node.row) * 31 * 31 + (node.col - 1) * 91);
        		}
        		if(node.col + 1 < matrix.get(0).size() && matrix.get(node.row).get(node.col + 1) != 0 && !set.contains((node.row) * 31 * 31 + (node.col + 1) * 91)) {
        			matrix.get(node.row).set(node.col + 1, counter);
        			nextQueue.offer(new Node(node.row, node.col + 1));
        			set.add((node.row) * 31 * 31 + (node.col + 1) * 91);
        		}
        	}
        	counter ++;
        	queue = nextQueue;
        }
        return matrix;
    }
    
    class Node {
    	int row;
    	int col;
    	public Node(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    }
}