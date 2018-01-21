class Solution {
    public String minWindow(String S, String T) {
        int minVal = Integer.MAX_VALUE;
        int minBeg = -1;
        int minEnd = T.length() + 1;
        int ptr = 0;
        while (true) {
            int[] occTinS = new int[T.length()];
            occTinS[T.length() - 1] = -1;
            int j = 0;
            for (int i = ptr; i < S.length() && j < T.length(); i++) {
                if (T.charAt(j) == S.charAt(i)) {
                    occTinS[j++] = i;
                }
            }
            if (occTinS[T.length() - 1] == -1) {
                break;
            }
            if (occTinS[T.length() - 1] - occTinS[0] < minVal) {
                minVal = occTinS[T.length() - 1] - occTinS[0];
                minBeg = occTinS[0];
                minEnd = occTinS[T.length() - 1] + 1;
            }
            ptr = occTinS[0] + 1;
            if (ptr >= S.length()) {
                break;
            }
        }
        if (minVal == Integer.MAX_VALUE) {
            return "";
        }
        return S.substring(minBeg, minEnd);
    }
}