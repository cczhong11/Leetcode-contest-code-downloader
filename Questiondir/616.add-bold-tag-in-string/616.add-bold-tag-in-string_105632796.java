public class Solution {
      public String addBoldTag(String s, String[] dict) {
    	Map<Integer, Set<String>> lookup = new HashMap<>();
    	for (String d : dict) {
    		int l = d.length();
    		if (!lookup.containsKey(l)) {
    			lookup.put(l, new HashSet<String>());
    		}
    		Set<String> set = lookup.get(l);
    		set.add(d);
    	}
    	boolean[] p = new boolean[s.length()];
    	for (int len = 1; len <= s.length(); len++) {
    		Set<String> curr = lookup.get(len);
    		if (curr == null) {
    			continue;
    		}
    		for (int st = 0; st <= s.length() - len; st++) {
    			if (curr.contains(s.substring(st, st + len))) {
    				for (int i = st; i < st + len; i++) {
    					p[i] = true;
    				}
    			}
    		}
    	}
    	String ret = "";
    	// System.out.println(Arrays.toString(p));
    	boolean include = false;
    	for (int i = 0; i < s.length(); i++) {
    		boolean in = p[i];
    		if ((!include && !in) || (include && in)) {
    			ret += s.charAt(i);
    			continue;
    		}
    		if (!include && in) {
    			include = in;
    			ret += "<b>" + s.charAt(i);
    			continue;
    		}
    		if (include && !in) {
    			include = in;
    			ret += "</b>" + s.charAt(i);
    			continue;
    		}
    	}
    	if (include) {
    		ret += "</b>";
    	}
    	return ret;
    }
}