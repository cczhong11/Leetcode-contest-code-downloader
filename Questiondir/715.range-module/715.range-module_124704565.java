	class RangeModule {
		int[][] curs;

	    public RangeModule() {
	    	curs = new int[0][];
	    }
	    
	    public void addRange(int left, int right) {
	        curs = or(curs, new int[][]{{left, right}});
	    }
	    
	    public boolean queryRange(int left, int right) {
	    	if(curs.length == 0)return false;
	    	int low = 0, high = curs.length;
	    	while(high - low > 1){
	    		int h = high+low>>1;
	    		if(curs[h][0] <= left){
	    			low = h;
	    		}else{
	    			high = h;
	    		}
	    	}
        	if(curs[low][0] <= left && right <= curs[low][1])return true;
	        return false;
	    }
	    
	    public void removeRange(int left, int right) {
	        curs = and(curs, new int[][]{{LI, left}, {right, HI}});
	    }
	    
		public int[][] or(int[][] a, int[][] b)
		{
			int na = a.length;
			int nb = b.length;
			int[][] rs = new int[na+nb][2];
			int p = 0;
			int i = 0, j = 0;
			for(;i < na && j < nb;){
				int[] tar = a[i][0] < b[j][0] ? a[i++] : b[j++];
				if(p == 0 || rs[p-1][1] < tar[0]){
					rs[p][0] = tar[0]; rs[p][1] = tar[1]; p++;
				}else if(rs[p-1][1] < tar[1]){
					rs[p-1][1] = tar[1];
				}
			}
			while(i < na){
				int[] tar = a[i++];
				if(p == 0 || rs[p-1][1] < tar[0]){
					rs[p][0] = tar[0]; rs[p][1] = tar[1]; p++;
				}else if(rs[p-1][1] < tar[1]){
					rs[p-1][1] = tar[1];
				}
			}
			while(j < nb){
				int[] tar = b[j++];
				if(p == 0 || rs[p-1][1] < tar[0]){
					rs[p][0] = tar[0]; rs[p][1] = tar[1]; p++;
				}else if(rs[p-1][1] < tar[1]){
					rs[p-1][1] = tar[1];
				}
			}
			return Arrays.copyOf(rs, p);
		}
		
		int LI = -1000000007;
		int HI = 1000000007;
		
		public int[][] and(int[][] a, int[][] b)
		{
			int[][] rs = new int[a.length + b.length][2];
			int p = 0;
			for(int i = 0, j = 0;i < a.length && j < b.length;){
				int from = Math.max(a[i][0], b[j][0]);
				int to = Math.min(a[i][1], b[j][1]);
				if(from < to)rs[p++] = new int[] {from, to};
				
				if(a[i][1] < b[j][1]){
					i++;
				}else{
					j++;
				}
			}
			return Arrays.copyOf(rs, p);
		}
	}	
