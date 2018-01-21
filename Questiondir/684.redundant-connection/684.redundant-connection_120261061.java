	class Solution {
		int n = 10000;
		
	    public int[] findRedundantConnection(int[][] edges) {
			upper = new int[n];
			Arrays.fill(upper, -1);
	        for(int[] e : edges){
	        	if(union(e[0], e[1])){
	        		return e;
	        	}
	        }
	        return null;
	    }
	    
			public int[] upper;

			public int root(int x) {
				return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
			}

			public boolean equiv(int x, int y) {
				return root(x) == root(y);
			}

			public boolean union(int x, int y) {
				x = root(x);
				y = root(y);
				if (x != y) {
					if (upper[y] < upper[x]) {
						int d = x;
						x = y;
						y = d;
					}
					upper[x] += upper[y];
					upper[y] = x;
				}
				return x == y;
			}

			public int count() {
				int ct = 0;
				for (int u : upper)
					if (u < 0)
						ct++;
				return ct;
			}
	}	
