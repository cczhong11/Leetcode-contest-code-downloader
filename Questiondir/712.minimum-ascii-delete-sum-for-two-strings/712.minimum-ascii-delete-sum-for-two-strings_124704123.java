class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int n1 = c1.length, n2 = c2.length;
        
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        
        for(int i=0;i<n1;i++) dp[i+1][0] = dp[i][0] + ascii(c1[i]);
        for(int i=0;i<n2;i++) dp[0][i+1] = dp[0][i] + ascii(c2[i]);
        
        for(int i=1;i<=n1;i++) for(int j=1;j<=n2;j++) {
            int tmp1, tmp2, tmp3;
            
            tmp1 = dp[i-1][j] + ascii(c1[i-1]);
            tmp2 = dp[i][j-1] + ascii(c2[j-1]);
            tmp3 = dp[i-1][j-1] + (c1[i-1]==c2[j-1] ? 0 : ascii(c1[i-1]) + ascii(c2[j-1]));
            
            dp[i][j] = tmp1;
            if(dp[i][j]>tmp2) dp[i][j] = tmp2;
            if(dp[i][j]>tmp3) dp[i][j] = tmp3;
        }
        return dp[n1][n2];
    }
    
    public int ascii(char c) {
        return (int) (c);
    }
}