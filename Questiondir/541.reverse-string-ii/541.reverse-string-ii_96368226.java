public class Solution {

  public String reverseStr(String _s, int k) {
    final int n = _s.length();
    char[] s = _s.toCharArray();
    StringBuilder sb = new StringBuilder(n);
    int i = 0;
    while (i < n) {
      if (i + 2*k < n) {
        reverse(s, i, i+k, sb);
        append(s, i+k, i+2*k, sb);
        i += 2*k;
      } else if (i + k < n) {
        reverse(s, i, i+k, sb);
        append(s, i+k, n, sb);
        i = n;
      } else {
        reverse(s, i, n, sb);
        i = n;
      }
    }
    return sb.toString();
  }

  private static void reverse(char[] s, int start, int end, StringBuilder sb) {
    for (int i = end-1; i >= start; i--) sb.append(s[i]);
  }

  private static void append(char[] s, int start, int end, StringBuilder sb) {
    for (int i = start; i < end; i++) {
      sb.append(s[i]);
    }
  }
}