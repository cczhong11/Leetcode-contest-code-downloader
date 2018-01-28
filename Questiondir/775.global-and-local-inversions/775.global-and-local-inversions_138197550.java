class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for ( Character ch: S.toCharArray() )
            if ( J.indexOf(ch) != -1 )
                ++res;
        return res;
    }
}