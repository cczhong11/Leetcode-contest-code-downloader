class Solution {
    public int[][][] f = new int[27][101][101];
    public String str;
    public int ff(int c, int start, int len) {
        if (len == 0) return 0;
        if (f[c][start][len] == -1) {
            int newc = str.charAt(start) - 'a' + 1;
            char newchar = str.charAt(start);
            int left = start, right = left + len - 1;
            while (left <= right && str.charAt(left) == newchar) ++ left;
            while (left <= right && str.charAt(right) == newchar) -- right;
            int fval = ff(newc, left, right - left + 1);
            for (int pivotlen = 1; pivotlen < len; ++ pivotlen) {
                int val = ff(newc, start, pivotlen) + ff(c, start + pivotlen, len - pivotlen);
                if (val < fval) {
                    fval = val;
                }
            }
            if (newc != c) ++ fval;
            f[c][start][len] = fval;
            
            //System.out.println("f: " + c + "," + start + "," + len + " = " + fval);
        }
        return f[c][start][len];
    }
    public int strangePrinter(String s) {
        str = s;
        for (int i = 0; i < 27; ++ i)
            for (int j = 0; j < 101; ++ j)
                for (int k = 0; k < 101; ++ k)
                    f[i][j][k] = -1;
        return ff(0, 0, s.length());
    }
}