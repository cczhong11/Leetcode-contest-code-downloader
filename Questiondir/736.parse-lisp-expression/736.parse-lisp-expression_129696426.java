class Solution {
	private int[] nexts;
	// variable in level l
	private Map<String , LinkedList<Long>> map = new HashMap<>();
	
    public int evaluate(String expression) {
     
    	LinkedList<Integer> stack = new LinkedList<>();
    	int length = expression.length();
    	nexts = new int[length];
    	int i;
    	for (i = 0;i < length;i ++) {
    		if (expression.charAt(i) == '(') {
    			stack.push(i);
    		} else if (expression.charAt(i) == ')') {
    			nexts[stack.pop()] = i;
    		}
    	}
    	return (int) (dfs(expression , 0 , length - 1 , 0));
    	
    }
    
    private long dfs(String expression , int from , int to , int level) {
    	
    	if (expression.charAt(from) == '(') {
	    	from ++;
	    	// add    	
	    	if (expression.charAt(from) == 'a') {
	    		while (from <= to && expression.charAt(from) != ' ') {
	    			from ++;
	    		}
	    		from ++;
	    		
	    		int temp = 0;
	    		long value1 = 0 , value2 = 0;
	    		if (expression.charAt(from) == '(') {
	    			value1 = dfs(expression , from , nexts[from] , level + 1);
	    			from = nexts[from] + 1;
	    		} else {
		    		// first
		    		temp = from;
		    		while (from <= to && expression.charAt(from) != ' ') {
		    			from ++;
		    		}
		    		value1 = dfs(expression , temp , from - 1 , level);
	    		}
	    		
	    		// second
	    		from ++;
	    		if (expression.charAt(from) == '(') {
	    			value2 = dfs(expression , from , nexts[from] , level + 1);
	    			from = nexts[from] + 1;
	    		} else {
		    		temp = from;
		    		while (from <= to && expression.charAt(from) != ')') {
		    			from ++;
		    		}
		    		value2 = dfs(expression , temp , from - 1 , level);
	    		}
	    		
	    		return value1 + value2;
	    	} else if (expression.charAt(from) == 'm') {
	    		// mult
	    		while (from <= to && expression.charAt(from) != ' ') {
	    			from ++;
	    		}
	    		from ++;
	    		
	    		int temp = 0;
	    		long value1 = 0 , value2 = 0;
	    		if (expression.charAt(from) == '(') {
	    			value1 = dfs(expression , from , nexts[from] , level + 1);
	    			from = nexts[from] + 1;
	    		} else {
		    		// first
		    		temp = from;
		    		while (from <= to && expression.charAt(from) != ' ') {
		    			from ++;
		    		}
		    		value1 = dfs(expression , temp , from - 1 , level);
	    		}
	    		
	    		// second
	    		from ++;
	    		if (expression.charAt(from) == '(') {
	    			value2 = dfs(expression , from , nexts[from] , level + 1);
	    			from = nexts[from] + 1;
	    		} else {
		    		temp = from;
		    		while (from <= to && expression.charAt(from) != ')') {
		    			from ++;
		    		}
		    		value2 = dfs(expression , temp , from - 1 , level);
	    		}
	    		
	    		return value1 * value2;
	    	} else {
	    		// let
	    		while (from <= to && expression.charAt(from) != ' ') {
	    			from ++;
	    		}

	    		Set<String> names = new HashSet<>();
	    		long ans = 0;
	    		from ++;
	    		while (from <= to) {
	    			if (isVar(expression.charAt(from)) && notLast(expression , from , to)) {
		    			StringBuilder builder = new StringBuilder();
		    			while (from <= to && isVar(expression.charAt(from))) {
		    				builder.append(expression.charAt(from));
		    				from ++;
		    			}
		    			String name = builder.toString();
		    			
		    			from ++;
		    			long value = 0;
		    			if (expression.charAt(from) == '(') {
			    			value = dfs(expression , from , nexts[from] , level + 1);
			    			from = nexts[from] + 1;
			    		} else {
				    		int temp = from;
				    		while (from <= to && expression.charAt(from) != ' ') {
				    			from ++;
				    		}
				    		value = dfs(expression , temp , from - 1 , level);
			    		}
		    			if (!map.containsKey(name)) {
		    				map.put(name , new LinkedList<>());
		    			}		    			
		    			if (!names.contains(name)) {
		    				names.add(name);
		    				map.get(name).push(value);
		    			} else {
		    				map.get(name).pop();
		    				map.get(name).push(value);
		    			}
		    			from ++;
	    			} else {
	    				// last value
	    				if (expression.charAt(from) == '(') {
	    	    			ans = dfs(expression , from , nexts[from] , level + 1);
	    	    		} else {
	    		    		int temp = from;
	    		    		while (from <= to && expression.charAt(from) != ')') {
	    		    			from ++;
	    		    		}
	    		    		ans = dfs(expression , temp , from - 1 , level);
	    	    		}
	    				break;
	    			}
	    		}	
	    		for (String name : names) {
	    			map.get(name).pop();
	    		}
	    		return ans;
	    	}
    	} else {
    		// variable
    		if (expression.charAt(from) >= 'a' && expression.charAt(from) <= 'z') {
    			String variable = expression.substring(from , to + 1);
    			return map.get(variable).peek();
    		} else {
    			// value
    			String number = expression.substring(from , to + 1);
    			return Long.parseLong(number);
    		}
    	}
    	
    }
    
    private boolean notLast(String expression , int from , int to) {
    	
    	while (from < to && isVar(expression.charAt(from))) {
    		from ++;
    	}
    	if (from == to) {
    		return false;
    	} else {
    		return true;
    	}
    	
    }
    
    private boolean isVar(char ch) {
    	if (ch >= '0' && ch <= '9') {
    		return true;
    	} else {
    		if (ch >= 'a' && ch <= 'z') {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
}