class Solution {
    public String minWindow(String S, String T) {
        int[][] M = new int[T.length() + 1][S.length() + 1];
        for (int row = 0; row < T.length(); row++) M[row][S.length()] = -1;
        for (int col = S.length() - 1; col >= 0; col--) {
            for (int row = T.length() - 1; row >= 0; row--) {
                if (S.charAt(col) == T.charAt(row)) {
                    if (M[row+1][col+1] < 0 && M[row][col+1] < 0) M[row][col] = -1;
                    else if (M[row+1][col+1] < 0) M[row][col] = 1 + M[row][col+1];
                    else if (M[row][col+1] < 0) M[row][col] = 1 + M[row+1][col+1];
                    else M[row][col] = Math.min(M[row+1][col+1] + 1, M[row][col+1] + 1);
                } else {
                    M[row][col] = M[row][col+1] < 0 ? -1 : (1 + M[row][col+1]);
                }
            }
        }
        // for (int row = 0; row <= T.length(); row++) {
            // StringBuilder sb = new StringBuilder();
            // for (int col = 0; col <= S.length(); col++) {
                // sb.append(M[row][col] + " ");
            // }
            // System.out.println(sb.toString());
        // }
        int length = Integer.MAX_VALUE;
        int start = 0;
        for (int col = 0; col <= S.length(); col++) {
            if (M[0][col] >= 0 && M[0][col] < length) {
                length = M[0][col];
                start = col;
            }
        }
        if (length == Integer.MAX_VALUE) return "";
        else return S.substring(start, start + length);
    }
}