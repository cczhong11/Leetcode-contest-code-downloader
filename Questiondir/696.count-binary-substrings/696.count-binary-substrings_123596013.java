class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            int n1 = 0, end = i;
            while (end < chs.length && chs[end] == c) {
                n1++;
                end++;
            }
            int n2 = 0;
            while (end < chs.length && chs[end] != c && n2 < n1) {
                n2++;
                end++;
            }
            
            if (n1 == n2) {
                count++;
            }
        }
        return count;
    }
}