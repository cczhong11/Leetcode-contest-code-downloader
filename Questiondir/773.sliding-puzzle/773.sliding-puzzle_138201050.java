	class Solution {
	    public int slidingPuzzle(int[][] board) {
	        int[] a = new int[6];
	        for(int i = 0;i < 2;i++){
	        	for(int j = 0;j < 3;j++){
	        		a[i*3+j] = board[i][j];
	        	}
	        }
	        int to = encPerm(new int[]{1, 2, 3, 4, 5, 0});
	        
	        int[] d = new int[720];
	        Queue<int[]> q = new ArrayDeque<>();
	        q.add(a);
	        Arrays.fill(d, 9999999);
	        d[encPerm(a)] = 0;
	        int[] dr = { 1, 0, -1, 0 };
			int[] dc = { 0, 1, 0, -1 };
	        while(!q.isEmpty()){
	        	int[] cur = q.poll();
	        	int ec = encPerm(cur);
	        	for(int i = 0;i < 6;i++){
	        		if(cur[i] == 0){
	        			int r = i/3, c = i % 3;
	        			for(int k = 0;k < 4;k++){
	        				int nr = r + dr[k], nc = c + dc[k];
	        				if(nr >= 0 && nr < 2 && nc >= 0 && nc < 3){
	        					int ne = nr*3+nc;
	        	        		int[] nex = Arrays.copyOf(cur, 6);
	        	        		int dum = nex[i]; nex[i] = nex[ne]; nex[ne] = dum;
	        	        		int e = encPerm(nex);
	        	        		if(d[e] > d[ec] + 1){
	        	        			d[e] = d[ec] + 1;
	        	        			q.add(nex);
	        	        		}
	        				}
	        			}
	        		}
	        	}
	        }
	        if(d[to] > 99999)return -1;
	        return d[to];
	    }
	    
		public int encPerm(int[] a)
		{
			int n = a.length;
			int used = 0;
			int ret = 0;
			for(int i = 0;i < n;i++){
				ret = ret * (n - i) + a[i] - Integer.bitCount(used & ((1<<a[i]) - 1));
				used |= 1<<a[i];
			}
			return ret;
		}
	}	
