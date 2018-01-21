class Solution {
   public String countOfAtoms(String formula) {
     
    	LinkedList<Map<String , Integer>> stack = new LinkedList<Map<String , Integer>>();
    	int i , length = formula.length();
    	for (i = 0;i < length;i ++) {
    		char ch = formula.charAt(i);
    		if (ch >= '0' && ch <= '9') {
    			int cnt = 0;
    			while (i < length && (formula.charAt(i) >= '0' && formula.charAt(i) <= '9')) {
    				cnt = cnt * 10 + (formula.charAt(i) - '0');
    				i ++;
    			}
    			i --;
    			Map<String , Integer> newMap = new HashMap<>();
    			Map<String , Integer> map = stack.pop();
    			for (Map.Entry<String , Integer> entry : map.entrySet()) {
    				newMap.put(entry.getKey() , entry.getValue() * cnt);
    			}
    			stack.push(newMap);
    		} else if (ch == '(') {
    			stack.push(null);
    		} else if (ch == ')') {
    			Map<String , Integer> newMap = new HashMap<>();
    			while (!stack.isEmpty() && stack.peek() != null) {
    				Map<String , Integer> map = stack.pop();
    				for (Map.Entry<String , Integer> entry : map.entrySet()) {
    					String string = entry.getKey();
    					int cnt = entry.getValue();
    					if (!newMap.containsKey(string)) {
    						newMap.put(string , cnt);
    					} else {
    						newMap.put(string , newMap.get(string) + cnt);
    					}
    				}
    			}
    			stack.pop();
    			stack.push(newMap);
    		} else {
    			Map<String , Integer> map = new HashMap<>();
    			StringBuilder builder = new StringBuilder();	
    			builder.append(formula.charAt(i));
    			i ++;
    			while (i < length && (isAlpha(formula.charAt(i)))) {
    				char c = formula.charAt(i);
    				builder.append(c);
    				i ++;
    			}
    			map.put(builder.toString() , 1);
    			i --;
    			stack.push(map);
    		}
    	}
    	Map<String , Integer> map = new HashMap<>();
    	for (Map<String , Integer> m : stack) {
    		for (Map.Entry<String , Integer> entry : m.entrySet()) {
    			if (!map.containsKey(entry.getKey())) {
    				map.put(entry.getKey() , entry.getValue());
    			} else {
    				map.put(entry.getKey() , map.get(entry.getKey()) + entry.getValue());
    			}
    		}
    	}
    	List<Element> list = new ArrayList<>();
    	for (Map.Entry<String , Integer> entry : map.entrySet()) {
    		list.add(new Element(entry.getKey() , entry.getValue()));
    	}
    	Collections.sort(list);
    	StringBuilder builder = new StringBuilder();
    	for (Element e : list) {
    		builder.append(e.string);
    		if (e.cnt > 1) {
    			builder.append(e.cnt);
    		}
    	}
    	return builder.toString();
    	
    }
    
    private static class Element implements Comparable<Element> {
    	public String string;
    	public int cnt;
    	public Element(String string , int cnt) {
    		this.string = string;
    		this.cnt = cnt;
    	}
    	public int compareTo(Element e) {
    		return this.string.compareTo(e.string);
    	}
    }

    private boolean isAlpha(char ch) {
    	
    	if (ch >= 'a' && ch <= 'z') {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
}