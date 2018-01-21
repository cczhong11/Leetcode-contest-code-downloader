class Solution {
    public int[][] candyCrush(int[][] board) {
    
    	while (getNext(board)) {
    		int i , j , n = board.length , m = board[0].length;
    		for (i = 0;i < n;i ++) {
    			for (j = 0;j < m;j ++) {
    				board[i][j] = temp[i][j];
    			}
    		}
    	}
    	return board;
    	
    }
    
    private boolean[][] del = new boolean[100][100];
    private int[][] temp = new int[100][100];
    
    private boolean getNext(int[][] board) {
    	
    	boolean flag = false;
    	int i , j , n = board.length , m = board[0].length;
    	for (i = 0;i < n;i ++) {
    		for (j = 0;j < m;j ++) {
    			del[i][j] = false;
    			temp[i][j] = 0;
    		}
    	}
    	for (i = 0;i < n;i ++) {
    		for (j = 0;j < m;j ++) {
    			if (board[i][j] > 0) {
	    			int from = j , to = j , cnt = 0;
	    			while (j < m && (board[i][from] == board[i][j])) {
	    				to = j;
	    				cnt ++;
	    				j ++;
	    			}
	    			j --;
	    			if (cnt >= 3) {
	    				for (int k = from;k <= to;k ++) {
	    					del[i][k] = true;
	    				}
	    				flag = true;
	    			}
    			}
    		}
    	}
    	for (j = 0;j < m;j ++) {
    		for (i = 0;i < n;i ++) {
    			if (board[i][j] > 0) {
	    			int from = i , to = i , cnt = 0;
	    			while (i < n && (board[i][j] == board[from][j])) {
	    				to = i;
	    				cnt ++;
	    				i ++;
	    			}
	    			i --;
	    			if (cnt >= 3) {
	    				for (int k = from;k <= to;k ++) {
	    					del[k][j] = true;
	    				}
	    				flag = true;
	    			}
    			}
    		}
    	}
    	for (j = 0;j < m;j ++) {
    		int next = n - 1;
    		for (i = n - 1;i >= 0;i --) {
    			if (!del[i][j]) {
    				temp[next][j] = board[i][j];
    				next --;
    			}
    		}
    	}
    	return flag;
    	
    }    				
	
}