import java.util.ArrayList;

class Solution {
    public int countBinarySubstrings(String s) {
    	if (s.length() == 0) return 0;
        ArrayList<Integer> count = new ArrayList<Integer>();
        int p = -1;
        for (int i = 0; i < s.length(); ++i) {
        	if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
        		if (p != -1) {
        			count.add(i - p);
        		}
        		p = i;
        	}
        }
        count.add(s.length() - p);
        
        int res = 0;
        for (int i = 0; i + 1 < count.size(); ++i) {
        	int l = count.get(i);
        	int r = count.get(i + 1);
        	res += Math.min(l, r);
        }
        return res;
    }
}