class Solution {

	private boolean isPalindrome(String s , int from , int to) {
		
		while (from < to && (s.charAt(from) == s.charAt(to))) {
			from ++;
			to --;
		}
		return from >= to;
		
	}
	
    public boolean validPalindrome(String s) {
    
    	if (isPalindrome(s , 0 , s.length() - 1)) {
    		return true;
    	} else {
    		if (isPalindrome(s , 0 , s.length() - 2) || isPalindrome(s , 1 , s.length() - 1)) {
    			return true;
    		} else {
    			int from = 0 , to = s.length() - 1;
    			while (from < to && s.charAt(from) == s.charAt(to)) {
    				from ++;
    				to --;
    			}
    			if (isPalindrome(s , from + 1 , to) || isPalindrome(s , from , to - 1)) {
    				return true;
    			} else {
    				return false;
    			}
    		}
    	}
    	
    }
    
}