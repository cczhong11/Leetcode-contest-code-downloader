public class Solution {
	private static class Element {
		public long value1 , value2;
		public Element(long value1 , long value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
	}
	
	private Element solve(String string) {
		
		boolean prevIsAdd = true;
		long value1 = 0 , value2 = 0;
		int i , length = string.length();
		for (i = 0;i < length;i ++) {
			if (string.charAt(i) == '+') {
				prevIsAdd = true;
			} else if (string.charAt(i) == '-') {
				prevIsAdd = false;
			} else if (string.charAt(i) == 'x') {
				if (prevIsAdd) {
					value2 ++;
				} else {
					value2 --;
				}
			} else {
				long value = 0;
				while (i < length && (string.charAt(i) >= '0' && string.charAt(i) <= '9')) {
					value = value * 10 + (string.charAt(i) - '0');
					i ++;
				}
				// x
				if (i < length && string.charAt(i) == 'x') {
					if (prevIsAdd) {
						value2 += value;
					} else {
						value2 -= value;
					}
				} else {
					i --;
					if (prevIsAdd) {
						value1 += value;
					} else {
						value1 -= value;
					}
				}
			}
		}
		return new Element(value1 , value2);
		
	}
	
    public String solveEquation(String equation) {
    
    	String[] strs = equation.split("=");
    	Element e1 = solve(strs[0]) , e2 = solve(strs[1]);
    	// value1 + value2 * x
    	long value1 = e1.value1 - e2.value1;
    	long value2 = e2.value2 - e1.value2;
    	// value1 == x * value2
    	if (value1 == 0 && value2 == 0) {
    		return "Infinite solutions";
    	} else {
    		if (value2 == 0 && value1 != 0) {
    			return "No solution";
    		} else {
    			long ans = value1 / value2;
    			return String.format("x=%d" , ans);
    		}
    	}
    	
    }
}