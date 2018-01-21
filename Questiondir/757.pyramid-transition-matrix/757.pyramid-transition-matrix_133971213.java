class Solution {
	Map<String, List<Character>> map = new HashMap<>();

	public boolean pyramidTransition(String bottom, List<String> allowed) {
		for (int i = 0; i < allowed.size(); i++) {
			String s = allowed.get(i);
			String key = s.substring(0, 2);
			char ch = s.charAt(2);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<Character>());
			}
			map.get(key).add(ch);
		}
		
		return dfs(bottom, new StringBuilder());
	}
	
	public boolean dfs(String bottom, StringBuilder current) {
		if (bottom.length() == 1) {
			return true;
		}
		
		if (current.length() == bottom.length() - 1) {
			return dfs(current.toString(), new StringBuilder());
		}
		
		int index = current.length();
		char prevChar = 0;
		
		if (index > 0) {
			prevChar = current.charAt(index - 1);
		}
		String key = bottom.substring(index, index + 2);
		if (!map.containsKey(key)) {
			return false;
		}
		
		for (char ch : map.get(key)) {
			if (index == 0) {
				current.append(ch);
				if (dfs(bottom, current)) {
					return true;
				}
				current.deleteCharAt(current.length() - 1);
			} else {
				if (map.containsKey(prevChar + "" + ch)) {
					current.append(ch);
					if (dfs(bottom, current)) {
						return true;
					}
					current.deleteCharAt(current.length() - 1);
				}
			}
		}
		return false;
	}
}