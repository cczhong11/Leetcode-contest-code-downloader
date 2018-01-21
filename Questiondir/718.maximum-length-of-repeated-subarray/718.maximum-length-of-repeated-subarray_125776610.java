class Solution {
    public int findLength(int[] A, int[] B) {
        int n=A.length;
        int m=B.length;
        int[][] dp=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(A[i]==B[j])
                    if(i>0&&j>0)dp[i][j]=dp[i-1][j-1]+1;
                    else dp[i][j]=1;
                ans=Math.max(ans,dp[i][j]);
            }
        return ans;
    }
}