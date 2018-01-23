public class Solution {
    public String reverseStr(String s, int k) {
        char[] carr = s.toCharArray();
        for (int i = 0; i < carr.length; i += (2*k)) {
            reverse(carr, i, i + k-1);
        }
        return new String(carr);
    }
    
    public void reverse(char[] s, int start, int end) {
        end = Math.min(s.length - 1, end);
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}