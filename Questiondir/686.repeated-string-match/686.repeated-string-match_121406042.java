class Solution {
	String merge(String s, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(s);
		}
		return sb.toString();
	}

    public int repeatedStringMatch(String A, String B) {
    	int num = B.length() / A.length();
    	if (num == 0) {
    		num = 1;
    	}
    	for (int i = 0; i <= 1; i++) {
    		String s = merge(A, num + i);
    		if (s.contains(B)) {
    			return num + i;
    		}
    	}
    	return -1;
    }
}