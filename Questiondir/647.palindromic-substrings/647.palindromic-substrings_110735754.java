public class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        boolean P[][] = new boolean[n][n];
        for (int i= 0; i< n; i++)
            P[i][i] = true;
      
        for (int i=0; i<n-1; i++)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                P[i][i+1] = true;
                dp[i][i+1] = 1 ;
            }
        }
      
        for (int gap=2 ; gap<n; gap++)
        {
            for (int i=0; i<n-gap; i++)
            {
                int j = gap + i;
                if (s.charAt(i) == s.charAt(j) && P[i+1][j-1] ) P[i][j] = true;
                if (P[i][j] == true)
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }
        return dp[0][n-1]+s.length();
    }
}