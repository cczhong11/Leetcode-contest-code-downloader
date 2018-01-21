class Solution {
    public String minWindow(String S, String T) {
        String result = null;
        for (int i=0; i+T.length()<=S.length(); ) {
            int j = 0;
            for (; i<S.length(); i++) {
                if (S.charAt(i) == T.charAt(j)) {
                    if (++j == T.length()) {
                        break;
                    }
                }
            }
            if (j == T.length()) {
                int ii = i;
                j--;
                for (; i>=0; i--) {
                    if (S.charAt(i) == T.charAt(j)) {
                        if (--j < 0) {
                            break;
                        }
                    }
                }
                if (null == result || ii-i+1 < result.length()) {
                    result = S.substring(i, ii+1);
                }
                i++;
            }
        }
        return (null == result)? "" : result;
    }
}