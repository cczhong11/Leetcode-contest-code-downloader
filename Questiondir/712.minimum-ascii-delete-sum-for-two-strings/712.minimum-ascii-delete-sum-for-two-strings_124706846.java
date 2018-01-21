class Solution {
    public int minimumDeleteSum(String word1, String word2) {
        int n=word1.length(), m=word2.length();
        if(n==0) return m;
        if(m==0) return n;
        int dp[][]=new int[n+1][m+1];
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            dp[i][0]=dp[i - 1][0] + word1.charAt(i-1);
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=dp[0][j - 1] + word2.charAt(j-1);
        }
        for(int i=1;i<=n;i++) for(int j=1;j<=m;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1];
            }else{
                dp[i][j]=Math.min(dp[i-1][j]+word1.charAt(i-1), dp[i][j-1]+word2.charAt(j-1));
            }
        }
        return dp[n][m];
    }
}