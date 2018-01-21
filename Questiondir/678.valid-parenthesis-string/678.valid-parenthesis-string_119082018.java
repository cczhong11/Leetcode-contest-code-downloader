class Solution {
    public boolean checkValidString(String s) {
        if(s == null) return true;
        return check(s, 0, 0);
        
    }
    
    public boolean check(String s, int i, int count) {
        if(i >= s.length()) {
            return count == 0;
        }
        
        if(s.charAt(i) == '(') {
            count++;
            return check(s, i+1, count);
        } else if(s.charAt(i) == ')') {
            count--;
            if(count < 0) {
                return false;
            }
            return check(s, i+1, count);
        } else {
            return check(s, i+1, count) || check(s, i+1, count+1) || check(s, i+1, count-1);
        }
    }
    
}