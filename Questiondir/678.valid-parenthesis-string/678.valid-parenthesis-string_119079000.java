class Solution {
    public boolean checkValidString(String s) {
        int left = 0, star = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else if (ch == '*') star++;
            else {
                if (left > 0) --left;
                else if (star > 0) --star;
                else return false;
            }
        }
        if (star < left) return false;
        if (left == 0) return true;
        int right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch == ')') right++;
            else if (ch == '*') {
                if (left > 0) { right++; --left; }
            } else {
                if (right > 0) --right;
                else return false;
            }
        }
        return true;
    }
}