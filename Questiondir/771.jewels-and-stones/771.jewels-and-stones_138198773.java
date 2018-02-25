class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] isJewel = new boolean[52];
        for (int i = 0; i < J.length(); ++i)
            isJewel[ctoi(J.charAt(i))] = true;
        int ret = 0;
        for (int i = 0; i < S.length(); ++i)
            if (isJewel[ctoi(S.charAt(i))]) ++ret;
        return ret;
    }
    
    private int ctoi(char c) {
        if (c >= 'A' && c <= 'Z') return c - 'A';
        if (c >= 'a' && c <= 'z') return c - 'a' + 26;
        return 0;
    }
}