class Solution {
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        int[] count = new int[7 * 7];
        for(String s: allowed){
        	int next = (s.charAt(0) - 'A') * 7 + (s.charAt(1) - 'A');
        	count[next]++;
        }
        char[][] converted = new char[7 * 7][];
        for(int i = 0; i < count.length; i++){
        	converted[i] = new char[count[i]];
        	count[i] = 0;
        }
        for(String s: allowed){
        	int next = (s.charAt(0) - 'A') * 7 + (s.charAt(1) - 'A');
        	converted[next][count[next]++] = s.charAt(2);
        }
        HashMap<String, Boolean> ret = new HashMap<>();
        explore(bottom, converted, ret);
        
        return ret.get(bottom);
    }
	public static void explore(String s, char[][] allowed, HashMap<String, Boolean> all){
		System.out.println("CHECK:" + s);
		if(all.containsKey(s))return;
		
		if(s.length() == 1){
			all.put(s, true);
			return;
		}
		
		HashSet<String> check = getAll(s, allowed);
		for(String curr: check){
			if(!all.containsKey(curr))explore(curr, allowed, all);
			if(all.get(curr)){
				all.put(s, true);
				return;
			}
		}
		all.put(s, false);
	}
	public static HashSet<String> getAll(String s, char[][] allowed){
		HashSet<String> ret = new HashSet<>();
		bash(ret, s, "", 0, allowed);
		
		return ret;
	}
	public static void bash(HashSet<String> ret, String s, String curr, int n, char[][] allowed){
		if(n == s.length() - 1)ret.add(curr);
		else if(n < s.length() - 1){
			int next = (s.charAt(n) - 'A') * 7 + (s.charAt(n+1) - 'A');
			for(char c: allowed[next]){
				bash(ret, s, curr + c, n + 1, allowed);
			}
		}
	}
}