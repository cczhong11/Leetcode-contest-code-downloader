class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length() == 0) return 0;
        int c1 = 1, c2 = 0, ans = 0;
        for(int i = 1; i < s.length(); ++i) {
            if(s.charAt(i) == s.charAt(i-1)) ++c1;
            else {
                ans += Math.min(c1, c2);
                c2 = c1;
                c1 = 1;
            }
        }
        return ans + Math.min(c1,c2);
    }
}