class Solution {
    public int numJewelsInStones(String J, String S) {
    	int res = 0;
        for (int i = 0; i < S.length(); ++i) {
        	char x = S.charAt(i);
        	for (int j = 0; j < J.length(); ++j) {
        		if (x == J.charAt(j)) {
        			++res;
        			break;
        		}
        	}
        }
        return res;
    }
}