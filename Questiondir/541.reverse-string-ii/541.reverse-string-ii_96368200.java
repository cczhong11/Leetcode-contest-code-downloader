public class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int counter = 0;
        while(counter < cs.length) {
            reverse(cs, counter, k);
            counter += 2 * k;
        }
        return new String(cs);
    }
    void reverse(char[] cs, int start, int k) {
        int end = Math.min(cs.length - 1, start + k - 1);
        while(start < end) {
            char c = cs[start];
            cs[start] = cs[end];
            cs[end] = c;
            end--;
            start++;
        }
    }
}