class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int count = 0;
        int left = 0;        

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')' ){
                if (left <= 0) {
                    if (count > 0) {
                        count--;
                    } else {
                        return false;
                    }
                } else {
                    left--;
                }
            } else {
                count++;
            }
        }
        
        if (left > count) return false;
        count = 0;
        int right= 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else if (c == '(') {
                if (right <= 0) {
                    if (count > 0) {
                        count--;
                    } else {
                        return false;
                    }
                } else {
                    right--;
                }
            } else {
                count++;
            }
        }
        
        if (right > count) return false;
        
        return true;
    }
}