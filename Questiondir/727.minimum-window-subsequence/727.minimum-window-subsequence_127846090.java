class Solution {
    public String minWindow(String S, String T) {
        int l1 = S.length(), l2 = T.length();
        int[] pasts = new int[l2];
        String res = "";
        Arrays.fill(pasts, -1);
        for (int i = 0; i < l1; i++) {
            for (int j = l2-1; j >= 0; j--) {
                if (S.charAt(i) == T.charAt(j)) {
                    if (j == 0) pasts[j] = i;
                    else if (pasts[j-1] != -1) {
                        pasts[j] = pasts[j-1];
                    }
                }
            }
            if (pasts[l2-1] != -1) {
                if (res.length() == 0 || res.length() > i-pasts[l2-1]+1) {
                    res = S.substring(pasts[l2-1], i+1);
                } 
            }
        }
        return res;
    }
}