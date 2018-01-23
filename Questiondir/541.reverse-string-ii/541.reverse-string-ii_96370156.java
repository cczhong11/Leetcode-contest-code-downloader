public class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int start = 0, length = ch.length;
        while (start < length) {
            int next = Math.min(start + 2 * k, length);
            int revend = Math.min(start + k, length);
            reverse(ch, start, revend);
            start = next;
        }
        return new String(ch);
    }

    private void reverse(char[] ch, int start, int end) {
        end--;
        while (start < end) {
            char t = ch[start];
            ch[start++] = ch[end];
            ch[end--] = t;
        }
    }
}