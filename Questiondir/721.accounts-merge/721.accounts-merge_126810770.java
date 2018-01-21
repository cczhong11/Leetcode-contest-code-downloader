	class Solution {
	    public List<List<String>> accountsMerge(List<List<String>> accounts) {
	    	int n = accounts.size();
	    	DJSet ds = new DJSet(n);
	    	List<Set<String>> sets = new ArrayList<>();
	    	for(List<String> li : accounts){
	    		Set<String> set = new HashSet<>();
	    		for(int i = 1;i < li.size();i++)set.add(li.get(i));
	    		sets.add(set);
	    	}
	    	for(int i = 0;i < n;i++){
	    		for(int j = i+1;j < n;j++){
	    			if(accounts.get(i).get(0).equals(accounts.get(j).get(0)) &&
	    					!Collections.disjoint(sets.get(i), sets.get(j))
	    					){
	    				ds.union(i, j);
	    			}
	    		}
	    	}
	    	for(int i = 0;i < n;i++){
	    		int r = ds.root(i);
	    		sets.get(r).addAll(sets.get(i));
	    	}
	    	List<List<String>> ret = new ArrayList<>();
	    	for(int i = 0;i < n;i++){
	    		if(ds.upper[i] < 0){
	    			List<String> row = new ArrayList<>(sets.get(i));
	    			Collections.sort(row);
	    			row.add(0, accounts.get(i).get(0));
	    			ret.add(row);
	    		}
	    	}
	    	return ret;
	    }
	    
    class DJSet { public int[] upper; public DJSet(int n){ upper = new int[n]; Arrays.fill(upper, -1);} public int root(int x){	return upper[x] < 0 ? x : (upper[x] = root(upper[x]));}	public boolean equiv(int x, int y){ return root(x) == root(y);} public boolean union(int x, int y){ x = root(x);y = root(y);if(x != y) { if(upper[y] < upper[x]) { int d = x; x = y; y = d;	} upper[x] += upper[y]; upper[y] = x;} return x == y;} public int count(){ int ct = 0; for(int u : upper)if(u < 0)ct++; return ct; }}
	    
	}	
