class Solution {
    public int countBinarySubstrings(String s) {
        if (s.length() <= 0) return 0;
        int prev = 0, cur = 1;
        int result = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i-1)) {
                ++cur;
            } else {
                prev = cur;
                cur = 1;
            }
            if (prev >= cur) ++result;
        }
        return result;
    }
}