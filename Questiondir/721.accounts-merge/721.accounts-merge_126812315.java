class Solution {
	private int[] set;
	private String[] accountNames;
	private Map<String , Integer> map = new HashMap<>();
	
	private int findSet(int x) {
		if (x == set[x]) {
			return x;
		} else {
			return set[x] = findSet(set[x]);
		}
	}
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
    	Map<Integer , List<String>> resultMap = new TreeMap<>();
    	int i , j , n = accounts.size();
    	set = new int[n];
    	accountNames = new String[n];
    	for (i = 0;i < n;i ++) {
    		set[i] = i;
    	}
    	for (i = 0;i < n;i ++) {
    		List<String> list = accounts.get(i);
    		accountNames[i] = list.get(0);
    		for (j = 1;j < list.size();j ++) {
    			String string = list.get(j);
    			if (!map.containsKey(string)) {
    				map.put(string , i);
    			}
    			int f1 = findSet(map.get(list.get(1)));
    			int f2 = findSet(map.get(string));
    			set[f1] = f2;
    		}
    	}
    	for (Map.Entry<String , Integer> entry : map.entrySet()) {
    		int f = findSet(entry.getValue());
    		if (!resultMap.containsKey(f)) {
    			resultMap.put(f , new ArrayList<>());
    		}
    		resultMap.get(f).add(entry.getKey());
    	}
    	List<List<String>> ans = new ArrayList<>();
    	for (Map.Entry<Integer , List<String>> entry : resultMap.entrySet()) {
    		List<String> list = entry.getValue();
    		Collections.sort(list);
    		list.add(0 , accountNames[entry.getKey()]);
    		ans.add(list);
    	}
    	return ans;
    	
    }
}