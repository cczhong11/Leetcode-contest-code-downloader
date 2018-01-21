	class Solution {
	    public List<Integer> fallingSquares(int[][] positions) {
	        int n = positions.length;
	        int[] xs = new int[2*n];
	        for(int i = 0;i < n;i++){
	        	xs[i] = positions[i][0];
	        	xs[i+n] = positions[i][0] + positions[i][1];
	        }
	        Arrays.sort(xs);
	        xs = uniq(xs);
	        
	        List<Integer> ret = new ArrayList<>();
	        int[] h = new int[xs.length+2];
	        int cmax = 0;
	        for(int[] pos : positions){
	        	int l = Arrays.binarySearch(xs, pos[0]);
	        	int r = Arrays.binarySearch(xs, pos[0]+pos[1]);
	        	int maxh = 0;
	        	for(int i = l;i < r;i++){
	        		maxh = Math.max(maxh, h[i]);
	        	}
	        	for(int i = l;i < r;i++){
	        		h[i] = maxh + pos[1];
	        	}
	        	cmax = Math.max(cmax, maxh + pos[1]);
	        	ret.add(cmax);
	        }
	        return ret;
	    }
	    
		public int[] uniq(int[] a)
		{
			int n = a.length;
			int p = 0;
			for(int i = 0;i < n;i++) {
				if(i == 0 || a[i] != a[i-1])a[p++] = a[i];
			}
			return Arrays.copyOf(a, p);
		}

	}	
