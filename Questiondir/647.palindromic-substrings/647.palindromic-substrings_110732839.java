public class Solution {
   public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
        	int l = i;
        	int r = i;
        	while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        		l--;
        		r++;
        	}
        	res += (r - l) / 2;
        	l = i;
        	r = i + 1;
        	while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        		l--;
        		r++;
        	}
        	if (r - l - 1 > 0) {
        		res += (r - l - 1) / 2;
        	}
        }
        return res;
    }
}