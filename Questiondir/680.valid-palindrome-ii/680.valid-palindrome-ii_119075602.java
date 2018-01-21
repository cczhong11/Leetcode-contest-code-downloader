class Solution {
    public boolean validPalindrome(String s) {
        int[] breakPoints = getPlaiBreakPoint(s);
        if(breakPoints == null) return true;
        int len = s.length();
        if(getPlaiBreakPoint(s.substring(0, breakPoints[0]) + s.substring(breakPoints[0]+1)) == null ||
          getPlaiBreakPoint(s.substring(0, breakPoints[1]) + s.substring(breakPoints[1]+1)) == null)
            return true;
        return false;
    }
    
    private int[] getPlaiBreakPoint(String s) {
        char[] cs = s.toCharArray();
        for(int i = 0, j = cs.length-1; i < j; i++, j--) {
            if(cs[i] != cs[j]) return new int[]{i, j};
        }
        return null;
    }
}