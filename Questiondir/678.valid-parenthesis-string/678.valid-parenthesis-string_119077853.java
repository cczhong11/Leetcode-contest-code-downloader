class Solution {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0)  return true;
        return check(s, 0, 0, 0);
    }
    public boolean check(String s, int index, int left, int right) {
        if(left < right)  return false;
        for(int i = index; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                right++;
                if(right > left)  return false;
            } 
            else if(s.charAt(i) == '(')  left++;
            else {
                return (check(s, i + 1, left + 1, right) || check(s, i + 1, left, right + 1) || check(s, i + 1, left, right));
            }
        }
        return left == right;
    }
}