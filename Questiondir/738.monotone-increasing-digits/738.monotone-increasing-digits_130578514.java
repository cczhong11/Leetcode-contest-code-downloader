class Solution {
// could use character string.charAt(start)
	private boolean check(int start , String string) {
	
		char ch = string.charAt(start);
		for (int i = start;i < string.length();i ++) {
			if (string.charAt(i) > ch) {
				return true;
			} else if (string.charAt(i) == ch) {
				continue;
			} else {
				return false;
			}
		}
		return true;
		
	}
	
    public int monotoneIncreasingDigits(int N) {
        
    	String string = Integer.toString(N);
    	StringBuilder builder = new StringBuilder();
    	int i , length = string.length();
    	for (i = 0;i < length;i ++) {
    		if (check(i , string)) {
    			builder.append(string.charAt(i));
    		} else {
    			if (i == 0 && string.charAt(i) == '1') {
    				i ++;
    				while (i < length) {
    					builder.append('9');
    					i ++;
    				}
    			} else {
    				builder.append((char) (string.charAt(i) - 1));
    				i ++;
    				while (i < length) {
    					builder.append('9');
    					i ++;
    				}
    			}
    			break;
    		}
    	}
    	return Integer.parseInt(builder.toString());
    	
    }
}