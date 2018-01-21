public class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n; j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    res++;
                } else {
                    break;
                }
            }
            for (int j = 0; i - j >= 0 && i + j + 1 < n; j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}