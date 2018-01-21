
class Solution {
	boolean check(String s) {
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			++l;
			--r;
		}
		return true;
	}

	public boolean validPalindrome(String s) {
		int l = 0, r = s.length() - 1;
	    while (l < r) {
	      if (s.charAt(l) == s.charAt(r)) {
	        ++l;
	        --r;
	      } else {
	        if (check(s.substring(l, r)) || check(s.substring(l + 1, r + 1))) return true; else return false;
	      }
	    }
	    return true;
	}
}