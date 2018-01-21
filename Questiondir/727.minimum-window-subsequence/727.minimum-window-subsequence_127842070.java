import java.util.Arrays;

class Solution {
    public String minWindow(String S, String T) {
        int[][] next = new int[S.length() + 1][26];
        for (int[] ints : next) {
            Arrays.fill(ints, -1);
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            next[i][c - 'a'] = i;
        }
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != T.charAt(0)) {
                continue;
            }
            int cur = i;
            for (int ti = 0; ti < T.length(); ti++) {
                char c = T.charAt(ti);
                cur = next[cur][c - 'a'];
                if (cur == -1) {
                    break;
                }
                cur++;
            }
            if (cur == -1) {
                continue;
            }
            if (cur - i < minLength) {
                minLength = cur - i;
                start = i;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return S.substring(start, start + minLength);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("wcbsuiyzacfgrqsqsnodwmxzkz", "xwqe"));
    }
}