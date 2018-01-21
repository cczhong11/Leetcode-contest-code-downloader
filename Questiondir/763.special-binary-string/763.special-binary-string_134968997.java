class Solution {
	boolean isSpecial(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '1') {
				sum++;
			} else {
				sum--;
			}
			if (sum < 0) return false;
		}
		return sum == 0;
	}
	
    public String makeLargestSpecial(String S) {
    	int N = S.length();
        for (int i = N - 2; i >= 0; --i) {
        	String tS = S;
        	for (int j = i + 1; j <= N; ++j) {
        		for (int k = j + 1; k <= N; ++k) {
	        		String s1 = S.substring(i, j);
	        		String s2 = S.substring(j, k);
	        		if (isSpecial(s1) && isSpecial(s2) && (s2 + s1).compareTo(s1 + s2) > 0) {
	        			String mS = S.substring(0, i) + s2 + s1 + S.substring(k);
	        			if (mS.compareTo(tS) > 0) {
	        				tS = mS;
	        			}
	        		}
        		}
        	}
        	S = tS;
        }
        return S;
    }
}