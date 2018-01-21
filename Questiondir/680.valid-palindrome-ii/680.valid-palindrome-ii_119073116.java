class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0)  return true;
        int left = 0;
        int right = s.length() - 1;
        if(isPalin(s, left, right))  return true;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isPalin(s, left + 1, right) || isPalin(s, left, right - 1);
            }
            left++;
            right--;
        }
        return false;
    }
    public boolean isPalin(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--))  return false;
        }
        return true;
    }
}