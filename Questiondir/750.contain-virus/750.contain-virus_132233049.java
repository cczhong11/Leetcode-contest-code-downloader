	class Solution {
	    public int containVirus(int[][] grid) {
	        int n = grid.length, m = grid[0].length;
	        int[][] a = new int[2*n-1][2*m-1];
	        for(int i = 0;i < n;i++){
	        	for(int j = 0;j < m;j++){
	        		a[2*i][2*j] = grid[i][j];
	        	}
	        }
	        int installed = 0;
	        while(true){
	        	DJSet ds = new DJSet(n*m);
	        	for(int i = 0;i < n;i++){
	        		for(int j = 0;j < m;j++){
	        			if(2*j+2 < 2*m-1 && a[2*i][2*j] == 1 && a[2*i][2*j+2] == 1 && a[2*i][2*j+1] == 0){
	        				ds.union(i*m+j, i*m+j+1);
	        			}
	        			if(2*i+2 < 2*n-1 && a[2*i][2*j] == 1 && a[2*i+2][2*j] == 1 && a[2*i+1][2*j] == 0){
	        				ds.union(i*m+j, (i+1)*m+j);
	        			}
	        		}
	        	}
	        	
	        	int[] dr = { 1, 0, -1, 0 };
				int[] dc = { 0, 1, 0, -1 };
//				int[] af = new int[n*m];
				List<Set<Integer>> lists = new ArrayList<>();
				for(int i = 0;i < n*m;i++)lists.add(null);
				
	        	for(int i = 0;i < n;i++){
	        		for(int j = 0;j < m;j++){
	        			if(a[2*i][2*j] == 1){
	        				for(int k = 0;k < 4;k++){
	        					int ni = i + dr[k], nj = j + dc[k];
	        					if(ni >= 0 && ni < n && nj >= 0 && nj < m &&
	        							a[ni*2][nj*2] == 0 && 
	        							a[i*2+dr[k]][j*2+dc[k]] == 0){
	        						int root = ds.root(i*m+j);
	        						if(lists.get(root) == null){
	        							lists.set(root, new HashSet<>());
	        						}
	        						lists.get(root).add(ni*m+nj);
	        					}
	        				}
	        			}
	        		}
	        	}
//	        	for(int i = 0;i < n;i++){
//	        		for(int j = 0;j < m;j++){
//	        			if(a[2*i][2*j] == 1){
//	        				for(int k = 0;k < 4;k++){
//	        					int ni = i + dr[k], nj = j + dc[k];
//	        					if(ni >= 0 && ni < n && nj >= 0 && nj < m &&
//	        							a[ni*2][nj*2] == 0 && 
//	        							a[i*2+dr[k]][j*2+dc[k]] == 0){
//	        						af[ds.root(i*m+j)]++;
//	        					}
//	        				}
//	        			}
//	        		}
//	        	}
	        	int arg = -1;
	        	int best = 0;
	        	for(int i = 0;i < n*m;i++){
	        		if(lists.get(i) != null){
		        		if(lists.get(i).size() > best){
		        			best = lists.get(i).size();
		        			arg = i;
		        		}
	        		}
//	        		if(af[i] > best){
//	        			best = af[i];
//	        			arg = i;
//	        		}
	        	}
//	        	tr(best, arg);
	        	if(arg == -1)break;
	        	for(int i = 0;i < n;i++){
	        		for(int j = 0;j < m;j++){
	        			if(ds.root(i*m+j) == arg){
	        				for(int k = 0;k < 4;k++){
	        					int ni = i + dr[k], nj = j + dc[k];
	        					if(ni >= 0 && ni < n && nj >= 0 && nj < m &&
	        							a[ni*2][nj*2] == 0 && 
	        							a[i*2+dr[k]][j*2+dc[k]] == 0){
	        						installed++;
	        						a[i*2+dr[k]][j*2+dc[k]] = 1;
	        					}
	        				}
	        			}
	        		}
	        	}
	        	
	        	for(int i = 0;i < n;i++){
	        		for(int j = 0;j < m;j++){
	        			if(a[2*i][2*j] == 1){
	        				for(int k = 0;k < 4;k++){
	        					int ni = i + dr[k], nj = j + dc[k];
	        					if(ni >= 0 && ni < n && nj >= 0 && nj < m &&
	        							a[ni*2][nj*2] == 0 && 
	        							a[i*2+dr[k]][j*2+dc[k]] == 0){
	        						a[ni*2][nj*2] = 2;
	        					}
	        				}
	        			}
	        		}
	        	}
	        	for(int i = 0;i < n;i++){
	        		for(int j = 0;j < m;j++){
	        			if(a[2*i][2*j] == 2)a[2*i][2*j] = 1;
	        		}
	        	}
//	        	for(int i = 0;i < n;i++){
//	        		String u = "";
//	        		for(int j = 0;j < m;j++){
//	        			u += a[2*i][2*j];
//	        		}
//	        		tr(u);
//	        	}
	        }
	        return installed;
	    }
	    
	    class DJSet {
			public int[] upper;

			public DJSet(int n) {
				upper = new int[n];
				Arrays.fill(upper, -1);
			}

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

	}	
