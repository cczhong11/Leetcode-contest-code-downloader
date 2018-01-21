class Solution {
    public int strangePrinter(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int min = getBase(s);
        int[][] dp = new int[s.length()][s.length()];
        return Math.min(min, helper(s, dp, 0, s.length() - 1));
    }
    
    private int getBase(String s) {
        int count = 0;
        int i = 0;
        while(i < s.length()) {
            int j = i + 1;
            while( j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            count++;
            i = j;
        }
        return count;
    }
    
    private int helper(String s, int[][] dp, int start, int end) {
        if (start > end || start < 0 || start >= dp.length || end < 0 || end >= dp[0].length) {
            return 0;
        }
        
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }
        if (s.charAt(start) == s.charAt(end)) {
            dp[start][end] = Math.min(helper(s, dp, start + 1, end), helper(s, dp, start, end -1));
            return dp[start][end];
        }
        dp[start][end] = Integer.MAX_VALUE;
        for (int j = start; j <= end; j++) {
            dp[start][end] = Math.min(dp[start][end], helper(s, dp, start, j) + helper(s, dp, j + 1, end));
        }
        return dp[start][end];
    } 
    
    
}