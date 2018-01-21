class Solution {
	private void action() {
		
		char ch = chStack.pop();
		Map<String , Integer> map2 = stack.pop();
		Map<String , Integer> map1 = stack.pop();
		
		if (ch == '+') {
			Map<String , Integer> map = new HashMap<>();
			for (Map.Entry<String , Integer> entry : map1.entrySet()) {
				if (!map.containsKey(entry.getKey())) {
					map.put(entry.getKey() , entry.getValue());
				} else {
					map.put(entry.getKey() , map.get(entry.getKey()) + entry.getValue());
				}
			}
			for (Map.Entry<String , Integer> entry : map2.entrySet()) {
				if (!map.containsKey(entry.getKey())) {
					map.put(entry.getKey() , entry.getValue());
				} else {
					map.put(entry.getKey() , map.get(entry.getKey()) + entry.getValue());
				}
			}
			stack.push(map);
		} else if (ch == '-') {
			Map<String , Integer> map = new HashMap<>();
			for (Map.Entry<String , Integer> entry : map1.entrySet()) {
				if (!map.containsKey(entry.getKey())) {
					map.put(entry.getKey() , entry.getValue());
				} else {
					map.put(entry.getKey() , map.get(entry.getKey()) + entry.getValue());
				}
			}
			for (Map.Entry<String , Integer> entry : map2.entrySet()) {
				if (!map.containsKey(entry.getKey())) {
					map.put(entry.getKey() , - entry.getValue());
				} else {
					map.put(entry.getKey() , map.get(entry.getKey()) - entry.getValue());
				}
			}
			stack.push(map);
		} else if (ch == '*') {
			Map<String , Integer> map = new HashMap<>();
			for (Map.Entry<String , Integer> entry1 : map1.entrySet()) {
				for (Map.Entry<String , Integer> entry2 : map2.entrySet()) {
					String string = combine(entry1.getKey() , entry2.getKey());
					int value = entry1.getValue() * entry2.getValue();
					if (!map.containsKey(string)) {
						map.put(string , value);
					} else {
						map.put(string , map.get(string) + value);
					}
				}
			}
			stack.push(map);
		}
		
	}
	
	private String combine(String string1 , String string2) {
		
		List<String> list = new ArrayList<>();
		for (String string : string1.split("[*]")) {
			if (!string.isEmpty()) {
				list.add(string);
			}
		}
		for (String string : string2.split("[*]")) {
			if (!string.isEmpty()) {
				list.add(string);
			}
		}
		Collections.sort(list);
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String string : list) {
			if (first) {
				first = false;
			} else {
				builder.append("*");
			}
			builder.append(string);
		}
		return builder.toString();
		
	}
	
	private static class Element implements Comparable<Element>{
		public String string;
		public int cnt;
		public int value;
		public Element(String string , int cnt , int value) {
			this.string = string;
			this.cnt = cnt;
			this.value = value;
		}
		public int compareTo(Element e) {
			if (this.cnt > e.cnt) {
				return - 1;
			} else if (this.cnt < e.cnt) {
				return 1;
			} else {
				return this.string.compareTo(e.string);
			}
		}
		@Override
		public String toString() {		
			if (this.cnt == 0) {
				return Integer.toString(this.value);
			} else {
				return String.format("%d*%s" , this.value , this.string);
			}
		}	
	}
	
	private int getCnt(String string) {
		
		if (string.isEmpty()) {
			return 0;
		}
		int ans = 1;
		for (char ch : string.toCharArray()) {
			if (ch == '*') {
				ans ++;
			}
		}
		return ans;
		
	}
	
	private List<String> getResult(Map<String , Integer> map) {
		
		List<String> ans = new ArrayList<>();
		List<Element> list = new ArrayList<>();
		for (Map.Entry<String , Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				int cnt = getCnt(entry.getKey());
				list.add(new Element(entry.getKey() , cnt , entry.getValue()));
			}
		}
		Collections.sort(list);
		for (Element e : list) {
			ans.add(e.toString());
		}
		return ans;
		
	}
	
	private LinkedList<Character> chStack = new LinkedList<>();
	private LinkedList<Map<String , Integer>> stack = new LinkedList<>();	
	
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
     
    	Map<String , Integer> eMap = new HashMap<>();
    	expression = expression.replaceAll("[ ]+" , "");
    	int i , length = expression.length();
    	for (i = 0;i < evalints.length;i ++) {
    		eMap.put(evalvars[i] , evalints[i]);
    	}
    	for (i = 0;i < length;i ++) {
    		if (expression.charAt(i) == '(') {
    			chStack.push('(');
    		} else if (expression.charAt(i) == ')') {
    			while (!chStack.peek().equals('(')) {
    				action();
    			}
    			chStack.pop();
    		} else if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
    			int value = 0;
    			while (i < length && (expression.charAt(i) >= '0' && expression.charAt(i) <= '9')) {
    				value = value * 10 + (expression.charAt(i) - '0');
    				i ++;
    			}
    			i --;
    			Map<String , Integer> map = new HashMap<>();
    			map.put("" , value);
    			stack.push(map);
    		} else if (expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z') {
    			StringBuilder builder = new StringBuilder();
    			while (i < length && (expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z')) {
    				builder.append(expression.charAt(i));
    				i ++;
    			}
    			i --;
    			Map<String , Integer> map = new HashMap<>();
    			if (eMap.containsKey(builder.toString())) {
    				map.put("" , eMap.get(builder.toString()));
    			} else {
    				map.put(builder.toString() , 1);
    			}
    			stack.push(map);
    		} else if (expression.charAt(i) == '+') {
    			while (!chStack.isEmpty() && (chStack.peek() == '-' || chStack.peek() == '*')) {    				
    				action();
    			}
    			chStack.push('+');
    		} else if (expression.charAt(i) == '-') {
    			while (!chStack.isEmpty() && (chStack.peek() == '-' || chStack.peek() == '*')) {    				
    				action();
    			}
    			chStack.push('-');
    		} else if (expression.charAt(i) == '*') {
    			chStack.push('*');
    		}
    	}
    	while (!chStack.isEmpty()) {
    		action();
    	}
    	return getResult(stack.pop());
    	
    }
}