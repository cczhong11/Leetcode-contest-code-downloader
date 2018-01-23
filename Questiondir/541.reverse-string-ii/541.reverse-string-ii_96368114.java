public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0, j;
        while (i < n) {
            reverse(cs, i, Math.min(n - 1, i + k - 1));
            i += 2 * k;
        }
        String res = new String(cs);
        return res;
    }
    
    void reverse(char[] cs, int s, int t) {
        for (int i = s, j = t; i < j; i ++, j --) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
        }
    }
}