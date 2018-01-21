class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                String strWithoutStart = s.substring(start+1, end+1);
                String strWithoutEnd = s.substring(start, end);
                return isValidPalindrome(strWithoutStart) || isValidPalindrome(strWithoutEnd);
            } else {
                start ++;
                end --;
            }
        }
        return true;
    }
    private static boolean isValidPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}