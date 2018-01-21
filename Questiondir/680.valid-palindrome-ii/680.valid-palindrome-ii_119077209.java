class Solution {
    public boolean validPalindrome(String s) {
        int count = ifP(s, 0);
        return count <= 1;
       
    }
    
    public int ifP(String s, int count) {
        if(count > 1) {
            return count;
        }
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                count++;
                if(count > 1) {
                    return count;
                }else {
                   int a = ifP(s.substring(i+1, j+1), count);
                   int b = ifP(s.substring(i, j), count);
                   return Math.min(a, b);
                }
                
            }
        }
        return count;
    }
}