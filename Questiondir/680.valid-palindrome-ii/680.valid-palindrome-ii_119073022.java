class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else{
                return valid(s, i + 1, j) || valid(s, i, j - 1);
            }
        }
        
        return true;
        
    }
     
    private boolean valid(String s, int left, int right){
        int i = left, j = right;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}