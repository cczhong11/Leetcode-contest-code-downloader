class Solution {
	boolean isUpperCase(char ch) {
		return ch >= 'A' && ch <= 'Z';
	}
	
	boolean isLowerCase(char ch) {
		return ch >= 'a' && ch <= 'z';
	}
	
	boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	TreeMap<String, Integer> dfs(String formula) {
		TreeMap<String, Integer> ans = new TreeMap<>();
		if (formula.length() == 0) return ans;
		
		//System.out.println("formula = " + formula);
//		if (formula.charAt(0) == '(') {
//			int lastPos = formula.lastIndexOf(')');
//			int count = 1;
//			
//			if (lastPos + 1 < formula.length()) {
//				count = Integer.valueOf(formula.substring(lastPos + 1));
//			}
//			TreeMap<String, Integer> t = dfs(formula.substring(1, lastPos));
//			
//			for (Map.Entry<String, Integer> entry : t.entrySet()) {
//				ans.put(entry.getKey(), entry.getValue() * count);
//			}
//			return ans;
//		}
		for (int i = 0; i < formula.length(); ) {
			if (isUpperCase(formula.charAt(i))) {
				int j = i + 1;
				while (j < formula.length() && isLowerCase(formula.charAt(j))) {
					j++;
				}
				String key = formula.substring(i, j);
				int count = 1;
				i = j;
				if (j < formula.length() && isDigit(formula.charAt(j))) {
					int k = j;
					while (k < formula.length() && isDigit(formula.charAt(k))) {
						k++;
					}
					count = Integer.valueOf(formula.substring(j, k));
					i = k;
				}
				ans.put(key, ans.getOrDefault(key, 0) + count);
			} else if (formula.charAt(i) == '(') {
				int left = 1;
				int j = i + 1;
				while (left > 0) {
					if (formula.charAt(j) == ')') {
						left--;
					} else if (formula.charAt(j) == '(') {
						left++;
					}
					j++;
				}
				
				//int count = Integer.valueOf(formula.substring(lastPos + 1));
				TreeMap<String, Integer> t = dfs(formula.substring(i + 1, j - 1));
				
				int count = 1;
				i = j;
				if (j < formula.length() && isDigit(formula.charAt(j))) {
					int k = j;
					while (k < formula.length() && isDigit(formula.charAt(k))) {
						k++;
					}
					count = Integer.valueOf(formula.substring(j, k));
					i = k;
				}
				
				for (Map.Entry<String, Integer> entry : t.entrySet()) {
					ans.put(entry.getKey(), ans.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
				}
				
				
				
			}
		}
		return ans;
	}

	public String countOfAtoms(String formula) {
		TreeMap<String, Integer> map = dfs(formula);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			if (entry.getValue() > 1) {
				sb.append(entry.getValue());
			}
		}
		return sb.toString();
	}

}