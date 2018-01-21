class Solution {
    public int countBinarySubstrings(String s) {
        
        if (s.length() == 0) return 0;
        
        int ans = 0;
        char c = s.charAt(0);
        
        
        int i = 0;
        int j =0 , k = 0;
        while (i < s.length()){
                
            k = j;
            j = i;
            while (i < s.length() && s.charAt(i) == c) {
                i++;
            }
            ans += Math.min(j - k, i - j);
            c = oppo(c);
        }
        
        return ans;
        
    }
    
    private char oppo(char c) {
        return c == '0' ? '1' : '0';
    }
}