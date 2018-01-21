class Solution {
    boolean helper(char[] cs, int i, int left) {
        if (left < 0) return false;
        if (i == cs.length) {
            return left == 0;
        }

        if (cs[i] == '(') return helper(cs, i + 1, left + 1);
        if (cs[i] == ')') return helper(cs, i + 1, left - 1);
        return helper(cs, i + 1, left) || helper(cs, i + 1, left - 1) || helper(cs, i + 1, left + 1);
    }

    public boolean checkValidString(String s) {
        char[] cs = s.toCharArray();
        return helper(cs, 0, 0);
    }
}