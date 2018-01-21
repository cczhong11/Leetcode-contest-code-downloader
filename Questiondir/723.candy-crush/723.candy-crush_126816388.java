	class Solution {
	    public int[][] candyCrush(int[][] board) {
	        int n = board.length, m = board[0].length;
	        while(true){
		        int[][] mark = new int[n][m];
	        	for(int j = 0;j < m;j++){
		        	int rep = 0;
	        		for(int i = 0;i < n;i++){
	        			if(board[i][j] == 0)continue;
		        		if(i > 0 && board[i][j] == board[i-1][j]){
		        			rep++;
		        			if(rep == 3){
		        				mark[i-2][j] = mark[i-1][j] = 1;
		        			}
		        			if(rep >= 3){
		        				mark[i][j] = 1;
		        			}
		        		}else{
		        			rep = 1;
		        		}
	        		}
		        }
	    		for(int i = 0;i < n;i++){
		        	int rep = 0;
		        	for(int j = 0;j < m;j++){
	        			if(board[i][j] == 0)continue;
		        		if(j > 0 && board[i][j] == board[i][j-1]){
		        			rep++;
		        			if(rep == 3){
		        				mark[i][j-2] = mark[i][j-1] = 1;
		        			}
		        			if(rep >= 3){
		        				mark[i][j] = 1;
		        			}
		        		}else{
		        			rep = 1;
		        		}
	        		}
		        }
	    		
	    		boolean some = false;
	    		for(int i = 0;i < n;i++){
	    			for(int j = 0;j < m;j++){
	    				if(mark[i][j] == 1){
	    					board[i][j] = 0;
	    					some = true;
	    				}
	    			}
	    		}
	    		if(!some)break;
	    		
				for(int j = 0;j < m;j++){
					int to = n-1;
					for(int i = n-1;i >= 0;i--){
						if(board[i][j] > 0){
							board[to][j] = board[i][j];
							if(to > i)board[i][j] = 0;
							to--;
						}
	    			}
	    		}
	        }
	        
	        return board;
	    }
	}	
