class Solution {
    /*
    think: go from outside in
    
    */
    public boolean validPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }
        // here: length is 3 or more
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        // here: i >= j OR there is mismatch between two chars
        if (i >= j) {
            return true;
        }
        // here: mismatch, i < j
        if (s.length() <= 2) {
            return true;
        }
        if (isPalindrome(s.substring(i, j))) {
            return true;
        }
        if (isPalindrome(s.substring(i + 1, j + 1))) {
            return true;
        }
        return false;
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}