public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2 || k == 1)
            return s;
        char[] cs = s.toCharArray();
        reverse(cs, k);
        return new String(cs);
    }
    
    private void reverse(char[] cs, int k) {
        for (int i = 0; i < cs.length; i += k * 2) {
            for (int l = i, r = (i + k - 1) < cs.length ? (i + k - 1) : (cs.length - 1); l < r; l++, r--) {
                char t = cs[l];
                cs[l] = cs[r];
                cs[r] = t;
            }
        }
    }
}