class Solution {
 	public int flipLights(int n, int m) {
		if (n > 9) {
			return flipLights(9, m); 
		}
		if (m > 6) {
			return flipLights(n, 6);
		}
		Set<String> set = new HashSet<>();
		String status = "";
		for (int i = 0; i < n; i++) {
			status += '0';
		}
		dfs(status, set, 0, m);
		return set.size();
	}
	
	void dfs(String status, Set<String> set, int count, int m) {
		if (count == m) {
			set.add(status);
			return;
		}
		char[] chars = status.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '0') {
				chars[i] = '1';
			} else {
				chars[i] = '0';
			}
		}
		dfs(new String(chars), set, count + 1, m);
		
		chars = status.toCharArray();
		for (int i = 0; i < chars.length; i += 2) {
			if (chars[i] == '0') {
				chars[i] = '1';
			} else {
				chars[i] = '0';
			}
		}
		dfs(new String(chars), set, count + 1, m);
		
		chars = status.toCharArray();
		for (int i = 1; i < chars.length; i += 2) {
			if (chars[i] == '0') {
				chars[i] = '1';
			} else {
				chars[i] = '0';
			}
		}
		dfs(new String(chars), set, count + 1, m);
		
		chars = status.toCharArray();
		for (int i = 0; i < chars.length; i += 3) {
			if (chars[i] == '0') {
				chars[i] = '1';
			} else {
				chars[i] = '0';
			}
		}
		dfs(new String(chars), set, count + 1, m);
	}
}