class Solution {
  public int countBinarySubstrings(String s) {
    int n = s.length();
    int[] left = new int[n];
    int[] right = new int[n];
    for (int i = 0; i < n; ++i) {
      left[i] = i > 0 && s.charAt(i - 1) == s.charAt(i) ? left[i - 1] + 1 : 1;
    }
    for (int i = n - 1; i >= 0; --i) {
      right[i] = i + 1 < n && s.charAt(i + 1) == s.charAt(i) ? right[i + 1] + 1 : 1;
    }
    int res = 0;
    for (int i = 1; i < n; ++i) if (s.charAt(i - 1) != s.charAt(i)) {
      res += Math.min(left[i - 1], right[i]);
    }
    return res;
  }
}