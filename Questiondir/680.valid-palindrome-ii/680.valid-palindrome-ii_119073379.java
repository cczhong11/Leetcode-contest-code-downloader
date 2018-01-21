class Solution {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int ll = 0, rr = cs.length - 1;
        boolean nomatch = false;
        while (ll < rr) {
            if (cs[ll] != cs[rr]) {
                nomatch = true;
                break;
            }
            ll++;
            rr--;
        }
        if (!nomatch) return true;

        int lll = ll, rrr = rr;
        ll++;
        nomatch = false;
        while (ll < rr) {
            if (cs[ll] != cs[rr]) {
                nomatch = true;
                break;
            }
            ll++;
            rr--;
        }
        if (!nomatch) return true;
        ll = lll;
        rr = rrr - 1;
        while (ll < rr) {
            if (cs[ll] != cs[rr]) {
                return false;
            }
            ll++;
            rr--;
        }
        return true;
    }
}