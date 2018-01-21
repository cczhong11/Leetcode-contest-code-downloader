public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += expand(s, i, i);
            res += expand(s, i, i + 1);
        }
        return res;
    }
    
    public int expand(String s, int left, int right) {
        int lo = left, hi = right;
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--; hi++;
        }
        return (hi - lo) / 2;
    }
}