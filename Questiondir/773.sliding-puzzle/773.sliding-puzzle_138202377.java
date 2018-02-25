class Solution {
    public int slidingPuzzle(int[][] board) {
		String ans = "123450";
        String start = "";
        for (int i = 0; i < 2; i++) {
        	for (int j = 0; j < 3; j++) {
        		start += board[i][j];
        	}
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		String curr = queue.poll();
        		if (ans.equals(curr)) {
        			return step;
        		}
        		if (visited.contains(curr)) {
        			continue;
        		}
        		visited.add(curr);
        		List<String> nextMoves = getNextMove(curr);
        		for (String nextMove : nextMoves) {
        			if (!visited.contains(nextMove)) {
        				queue.add(nextMove);
        			}
        		}
        	}
        	step++;
        }
        return -1;
    }
	
	private List<String> getNextMove(String curr) {
		List<String> nextMoves = new ArrayList<>();
		char[] arr = curr.toCharArray();
		if (arr[0] == '0') {
			int target = 0;
			for (int i : new int[]{1, 3}) {
				arr[target] = arr[i];
				arr[i] = '0';
				nextMoves.add(new String(arr));
				arr = curr.toCharArray();				
			}
			return nextMoves;
		} else if(arr[1] == '0') {
			int target = 1;
			for (int i : new int[]{0, 2, 4}) {
				arr[target] = arr[i];
				arr[i] = '0';
				nextMoves.add(new String(arr));
				arr = curr.toCharArray();				
			}
			return nextMoves;		
		} else if(arr[2] == '0') {
			int target = 2;
			for (int i : new int[]{1, 5}) {
				arr[target] = arr[i];
				arr[i] = '0';
				nextMoves.add(new String(arr));
				arr = curr.toCharArray();				
			}
			return nextMoves;		
		} else if(arr[3] == '0') {
			int target = 3;
			for (int i : new int[]{0, 4}) {
				arr[target] = arr[i];
				arr[i] = '0';
				nextMoves.add(new String(arr));
				arr = curr.toCharArray();				
			}
			return nextMoves;		
		} else if(arr[4] == '0') {
			int target = 4;
			for (int i : new int[]{1, 3, 5}) {
				arr[target] = arr[i];
				arr[i] = '0';
				nextMoves.add(new String(arr));
				arr = curr.toCharArray();				
			}
			return nextMoves;		
		} else {
			int target = 5;
			for (int i : new int[]{2, 4}) {
				arr[target] = arr[i];
				arr[i] = '0';
				nextMoves.add(new String(arr));
				arr = curr.toCharArray();				
			}
			return nextMoves;		
		}
	}
}