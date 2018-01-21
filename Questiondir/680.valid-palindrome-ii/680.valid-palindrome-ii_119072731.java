class Solution {
    public boolean validPalindrome(String s) {
        int lo = 0, hi = s.length()-1;
        while (lo<hi){
            if (s.charAt(lo)==s.charAt(hi)){
                lo++;
                hi--;
            }
            else
            return check(s,lo+1,hi) || check(s,lo,hi-1);
        }
        return true;
    }
    
    private boolean check(String s, int lo, int hi){
        while (lo<hi){
            if (s.charAt(lo)==s.charAt(hi)){
                lo++;
                hi--;
            }
            else
                return false;
        }
        return true;
    }
}