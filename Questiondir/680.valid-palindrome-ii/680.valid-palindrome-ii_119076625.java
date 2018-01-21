class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if(len <= 2) return true;
        int left = 0, right = len -1;
        boolean change  = false;
        return validPalindrome(s, left, right, change);
    }
    
    public boolean validPalindrome(String s, int left, int right, boolean change){
        while(right > left){
            if(s.charAt(right) != s.charAt(left)){
                if(change) return false;
                boolean t1 = false, t2 = false;
                if(s.charAt(left + 1) == s.charAt(right))
                    t1 = validPalindrome(s, left + 2, right -1, true);
                if(s.charAt(left) == s.charAt(right - 1))
                    t2 = validPalindrome(s, left + 1, right - 2, true);
                return t1 || t2;
            }
            left++;
            right--;
        }
        return true;
    }
}