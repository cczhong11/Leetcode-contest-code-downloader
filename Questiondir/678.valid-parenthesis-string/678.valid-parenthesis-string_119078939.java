class Solution {
    public boolean checkValidString(String s) {
        int maxUnclosed = 0;
        int minUnclosed = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                maxUnclosed++;
                minUnclosed++;
            }
            else if (c == ')') {
                maxUnclosed--;
                if (maxUnclosed < 0) { return false; }
                minUnclosed--;
                if (minUnclosed < 0) { minUnclosed = 0; }
            }
            else if (c == '*') {
                maxUnclosed++;
                minUnclosed--;
                if (minUnclosed < 0) { minUnclosed = 0; }
            }
        }
        if (minUnclosed != 0) {
            return false;
        }
        return true;
    }
}