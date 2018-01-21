class Solution {
    public String minWindow(String S, String T) {
        int minL = S.length();
        String res = new String();
        int it = 0;
        int ps = 0;
        for (int is = 0; is < S.length(); is++) {
            char cs = S.charAt(is);
            char ct = T.charAt(it);
            if (cs == ct) {
                if (it == 0) ps = is;
                it++;
            }
            if (it == T.length()) {
                int k = is;
                it--;
                for (; k >= 0; k--) {
                    if (S.charAt(k) == T.charAt(it)) {
                        it--;
                    }
                    if (it < 0) {
                        int len = is - k + 1;
                        if (len < minL) {
                            res = S.substring(k, is + 1);
                            minL = len;
                        }
                        it = 0;
                        is = ps + 1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}