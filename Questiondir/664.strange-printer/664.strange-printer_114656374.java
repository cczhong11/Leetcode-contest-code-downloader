class Solution {
    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;
        int[][] mem = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) mem[i][i] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int limit = j + i;
                if (limit < s.length()) {
                    int res = Integer.MAX_VALUE / 10;
                    for (int k = j; k < limit; k++) {
                        res = Math.min(res, mem[j][k] + mem[k + 1][limit]);
                        if (s.charAt(k) == s.charAt(k + 1)) res = Math.min(res, mem[j][k] + mem[k + 1][limit] - 1);
                        if (s.charAt(j) == s.charAt(limit)) res = Math.min(res, mem[j][k] + mem[k + 1][limit] - 1);
                    }
                    mem[j][limit] = res;
                }
            }
        }
        return mem[0][s.length() - 1];
    }
}