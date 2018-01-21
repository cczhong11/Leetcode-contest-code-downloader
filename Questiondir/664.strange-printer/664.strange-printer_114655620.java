class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int size = s.length();
        
        int[][] dp = new int[size][size];
        
        for (int i = 0; i < size; ++i)
            dp[i][i] = 1;
        
        for (int i = 0; i < size-1; ++i) {
            if (s.charAt(i) == s.charAt(i+1))
                dp[i][i+1] = 1;
            else
                dp[i][i+1] = 2;
        }
        
        for (int gap = 2; gap < size; ++gap) {
            for (int i = 0; i+gap < size; ++i) {
                int j = i+gap;
                int temp = 0x7fffffff;
                for (int k = i; k < j; ++k) {
                    int cur = dp[i][k] + dp[k+1][j];
                    if (s.charAt(i) == s.charAt(k+1) || s.charAt(i) == s.charAt(j) 
                       || s.charAt(k) == s.charAt(k+1) || s.charAt(k) == s.charAt(j))
                        cur--;
                    temp = Math.min(temp, cur);
                }
                dp[i][j] = temp;
            }
        }
        
        return dp[0][size-1];
    }
}