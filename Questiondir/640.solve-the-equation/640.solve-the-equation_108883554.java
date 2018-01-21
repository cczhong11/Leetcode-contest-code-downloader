public class Solution {
    public String solveEquation(String equation) {
    	String[] parts = equation.split("=");
    	List<Integer> leftSide = parse(parts[0]);
    	List<Integer> rightSide = parse(parts[1]);
    	int xC = leftSide.get(0) - rightSide.get(0);
    	int c = rightSide.get(1) - leftSide.get(1);
    	if (xC == 0) {
    		if (c == 0) {
    			return "Infinite solutions";
    		} else {
    			return "No solution";
    		}
    	}
    	return "x=" + c / xC;
    }
	
	private List<Integer> parse(String string) {
		int xC = 0;
		int c = 0;
		boolean positive = true;
		String args = "";
		for (int i = 0; i < string.length(); i++) {
			char curr = string.charAt(i);
			if (curr ==  '+' || curr == '-') {
				if (!args.isEmpty()) {
					if (args.endsWith("x")) {
						args = args.substring(0, args.length()-1);
						if (args.isEmpty()) {
							xC = positive ? xC + 1 : xC - 1;
						} else {
							int n = Integer.valueOf(args);
							xC = positive ? xC + n : xC - n;
						}
					} else {
						int n = Integer.valueOf(args);
						c = positive ? c + n : c - n;
					}
				}
				args = "";
				positive = curr == '+';
			} else {
				args = args + curr;
			}
		}
		if (args.endsWith("x")) {
			args = args.substring(0, args.length()-1);
			if (args.isEmpty()) {
				xC = positive ? xC + 1 : xC - 1;
			} else {
				int n = Integer.valueOf(args);
				xC = positive ? xC + n : xC - n;
			}
		} else {
			int n = Integer.valueOf(args);
			c = positive ? c + n : c - n;
		}
		return Arrays.asList(xC, c);
	}
}