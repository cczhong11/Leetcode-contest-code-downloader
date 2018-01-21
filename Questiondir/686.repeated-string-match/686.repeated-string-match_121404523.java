class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        
        int res = 0;
        while (sb.length() < B.length()) {
        	sb.append(A);
        	++res;
        }
        
        if (sb.toString().indexOf(B) != -1) {
        	return res;
        }
        
        ++res;
        sb.append(A);
        if (sb.toString().indexOf(B) != -1) {
        	return res;
        }
        
        return -1;
    }
}